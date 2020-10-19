package chao.other;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

/**
 * @author chao.guo
 * @version 1.0.0
 * @ClassName ReferenceTest.java
 * @Description TODO
 * @createTime 2020年06月23日 10:07:00
 */
public class ReferenceTest {
    public static void main(String[] args) throws InterruptedException {
//        SoftReference<String> sr = new SoftReference<>("Hello,SoftReference");
//        System.out.println(sr.get());
//        System.gc();
//        System.out.println(sr.get());

        String value = "Hello,WeakReference";
        WeakReference<String> wr = new WeakReference<>(value);
        System.gc();
        System.out.println("*******" + wr.get());
    }
}
