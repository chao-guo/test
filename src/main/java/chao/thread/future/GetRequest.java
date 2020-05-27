package chao.thread.future;

import java.util.concurrent.Callable;

/**
 * @author g.c
 * @date 2020年5月13日上午9:49:09
 **/
public class GetRequest implements Callable<Boolean> {

	private int a;
	
	private int b;
	
	public GetRequest(int a, int b) {
		super();
		this.a = a;
		this.b = b;
	}



	@Override
	public Boolean call() throws Exception {
		for (int i = 0; i < 100; i++) {
			System.out.println(a + b + i);
		}
		return true;
	}

}
