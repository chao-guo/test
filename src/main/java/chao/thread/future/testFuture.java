package chao.thread.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
* @author g.c
* @date 2020年5月13日上午9:48:36
**/
public class testFuture {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		FutureTask<Boolean> futureTask = new FutureTask<Boolean>(new GetRequest(1, 2));
		ExecutorService execure = Executors.newCachedThreadPool();
		execure.execute(futureTask);
		execure.shutdown();
		System.out.println("----------------------");
		Boolean boolean1 = futureTask.get();
		System.out.println(boolean1);
	}
}
