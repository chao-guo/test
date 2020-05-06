package chao.design_pattern.singleton.lazy;
/**
* @author g.c
* @date 2020年5月1日下午8:51:37
**/
public class LazySingletonTest2 {

}
/**
 * 多线程情况下，运用synchronized加锁实现
 * 此种加锁不管是否实例化都需要加锁，影响性能，可以改进，延迟上锁时机
 * @author chao.guo
 *
 */
class LazySingleton2 {
	private static LazySingleton2 instance;

	private LazySingleton2() {
	}

	public synchronized static LazySingleton2 getInstance() {
		if (instance == null) {
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			instance = new LazySingleton2();
		}
		return instance;
	}
}