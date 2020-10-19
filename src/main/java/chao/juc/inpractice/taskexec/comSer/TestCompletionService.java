package chao.juc.inpractice.taskexec.comSer;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author chao.guo
 * @version 1.0.0
 * @ClassName TestCompletionService.java
 * @Description TODO
 * @createTime 2020年07月02日 18:06:00
 */
public class TestCompletionService {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Executor executor = Executors.newFixedThreadPool(3);
        CompletionService<String> service = new ExecutorCompletionService<String>(executor);
        for (int i = 0; i < 5; i++) {
            int seqNo = i;
            service.submit(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    return "HelloWorld-" + seqNo + "-" + Thread.currentThread().getName();
                }
            });
        }
        for (int j = 0; j < 5; j++){
            System.out.println(service.take().get());
        }
        ((ExecutorService) executor).shutdown();
    }
}
