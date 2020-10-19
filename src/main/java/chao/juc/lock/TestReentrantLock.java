package chao.juc.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author chao.guo
 * @Description TODO
 * @create 2020/07/16 11:29:00
 */
public class TestReentrantLock extends Thread {

    public static ReentrantLock reentrantLock = new ReentrantLock();
    public static int i = 0;

    public TestReentrantLock(String name) {
        super.setName(name);
    }

    @Override
    public void run() {
        for (int j = 0; j < 10000; ++j) {
            reentrantLock.lock();
            try {
                System.out.println(this.getName() + " " + i);
                i++;
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TestReentrantLock testReentrantLock1 = new TestReentrantLock("---1---");
        TestReentrantLock testReentrantLock2 = new TestReentrantLock("---2---");
        testReentrantLock1.start();
        testReentrantLock2.start();
        testReentrantLock1.join();
        testReentrantLock2.join();
        System.out.println(i);
    }
}
