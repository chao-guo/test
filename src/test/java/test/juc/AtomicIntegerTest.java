package test.juc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.jupiter.api.Test;

/**
 * @author g.c
 * @date 2020年5月25日下午2:01:37
 **/
class AtomicIntegerTest {

	@Test
	void test() throws InterruptedException, BrokenBarrierException {
		AtomicInteger value = new AtomicInteger(10);
		assertEquals(value.compareAndSet(1, 2), false);
		assertEquals(value.compareAndSet(10, 2), true);
		assertEquals(value.get(), 2);
		value.set(10);
		assertEquals(value.get(), 10);
		assertEquals(value.get(), 10);
		assertTrue(value.compareAndSet(10, 3));
		assertEquals(value.get(), 3);
		value.set(0);
		//
		assertEquals(value.incrementAndGet(), 1);
		assertEquals(value.getAndAdd(2), 1);
		assertEquals(value.getAndSet(5), 3);
		assertEquals(value.get(), 5);
		//是个线程都调用一次incrementAndGet
//		CyclicBarrier barrier = new CyclicBarrier(10);
		CountDownLatch countDownLatch = new CountDownLatch(10);
		for (int i = 0; i < 10; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					value.incrementAndGet();
//					try {
//						barrier.await();
//					} catch (InterruptedException | BrokenBarrierException e) {
//						e.printStackTrace();
//					}
					countDownLatch.countDown();
				}
			}).start();
		}
//		barrier.await();
		countDownLatch.await();
		//
		assertEquals(value.get(), 5 + 10);
	}

}
