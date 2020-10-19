package chao.juc.future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author chao.guo
 * @version 1.0.0
 * @ClassName FutureTest.java
 * @Description TODO
 * @createTime 2020年07月01日 10:22:00
 */
public class FutureTest {
    public static void main(String[] args) {
        Callable<Void> task = () -> {
//            TimeUnit.SECONDS.sleep(10L);
            int a = 1/0;
            return null;
        };

        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<Void> submit = executorService.submit(task);
        executorService.shutdown();
        try {
            submit.get(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.getCause().printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
}