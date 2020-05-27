package chao.juc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * @author g.c
 * @date 2020年5月26日上午9:16:41
 **/
public class TestAtomic {
	public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
		TestAtomic testAtomic = new TestAtomic();
		testAtomic.testAtomicInteger();

		DemoData data = testAtomic.new DemoData();
		System.out.println("1 ==> " + testAtomic.testAtomicIntegerFieldUpdater("value1").getAndSet(data, 10));
		System.out.println("3 ==> " + testAtomic.testAtomicIntegerFieldUpdater("value2").incrementAndGet(data));
		System.out.println("2 ==> " + testAtomic.testAtomicIntegerFieldUpdater("value3").decrementAndGet(data));
		System.out.println("true ==> " + testAtomic.testAtomicIntegerFieldUpdater("value4").compareAndSet(data, 4, 5));
	}

	public void testAtomicInteger() throws InterruptedException, BrokenBarrierException {
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
		// 是个线程都调用一次incrementAndGet
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

	public AtomicIntegerFieldUpdater<DemoData> testAtomicIntegerFieldUpdater(String fieldName) {
		return AtomicIntegerFieldUpdater.newUpdater(DemoData.class, fieldName);
	}

	class DemoData {
		public volatile int value1 = 1;
		volatile int value2 = 2;
		//DemoData的字段value3/value4对于AtomicIntegerFieldUpdaterDemo类是不可见的，因此通过反射是不能直接修改其值的。
		protected volatile int value3 = 3;
		private volatile int value4 = 4;
	}
}
