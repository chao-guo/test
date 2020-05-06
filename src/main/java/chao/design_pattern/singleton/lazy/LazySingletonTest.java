package chao.design_pattern.singleton.lazy;

/**
 * @author g.c
 * @date 2020年4月25日下午2:25:13
 **/
public class LazySingletonTest {

	public static void main(String[] args) {
		// 单线程下
//		LazySingleton instance1 = LazySingleton.getInstance();
//		LazySingleton instance2 = LazySingleton.getInstance();
//		System.out.println(instance1 == instance2);
		// 多线程下
		new Thread(() -> {
			LazySingleton instance1 = LazySingleton.getInstance();
			System.out.println(instance1);
		}).start();
		new Thread(() -> {
			LazySingleton instance2 = LazySingleton.getInstance();
			System.out.println(instance2);
		}).start();
		//此时很大概率出现两个实例
	}
}

/**
 * 该单例模式的实现只有在单线程情况下不会有问题: 多线程情况下,可能出现前一个线程判断instance为空,还未实例化即未执行instance = new
 * LazySingleton()时,后一个线程刚好也执行到判断条件,此时instance仍然为空，那么第二个线程也实例化了一次;
 * 
 * @author chao.guo
 *
 */
class LazySingleton {
	private static LazySingleton instance;

	private LazySingleton() {
	}

	public static LazySingleton getInstance() {
		if (instance == null) {
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			instance = new LazySingleton();
		}
		return instance;
	}
}