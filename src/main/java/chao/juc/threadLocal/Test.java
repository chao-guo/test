package chao.juc.threadLocal;

import chao.json.Person;

import java.util.concurrent.TimeUnit;

/**
 * @author chao.guo
 * @Description TODO
 * @create 2020/08/02 16:47:00
 */
public class Test {
    static ThreadLocal<Person> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(threadLocal.get());
        }).start();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            threadLocal.set(new Person());
        }).start();
    }
}
