package chao.other.cacheline;

/**
 * @author chao.guo
 * @Description TODO
 * @create 2020/07/30 10:41:00
 */
public class test2 {

    public static class Padding {
        //7*8=56字节
        public volatile long p1, p2, p3, p4, p5, p6, p7;
    }

    public static class T extends Padding {
        //8字节，尚未达到缓存行最大字节，故arr[0]与arr[1]可能在同一个缓存行
        private volatile long x = 0L;
    }

    private static T classT1 = new T();
    private static T classT2 = new T();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000000L; i++) {
                classT1.x = i;
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10000000L; i++) {
                classT2.x = i;
            }
        });
        long start = System.nanoTime();
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println((System.nanoTime() - start) / 1000000);
    }
}
