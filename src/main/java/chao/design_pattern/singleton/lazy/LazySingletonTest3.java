package chao.design_pattern.singleton.lazy;

/**
 * @author g.c
 * @date 2020年5月1日下午8:51:37
 **/
public class LazySingletonTest3 {

}

/**
 * 此种情况下，多线程时仍然有可能在判空条件时有多个线程进入加锁的那一步，所以还是会实例化处多个实例，所以加锁后需要再加一次判断
 * 见例子4
 * @author chao.guo
 *
 */
class LazySingleton3 {

	private static LazySingleton3 instance;

	private LazySingleton3() {
	}

	public static LazySingleton3 getInstance() {
		if (instance == null) {
			synchronized (LazySingleton3.class) {
				instance = new LazySingleton3();
			}
		}
		return instance;
	}
}