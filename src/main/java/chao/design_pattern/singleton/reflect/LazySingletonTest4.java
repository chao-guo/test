package chao.design_pattern.singleton.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author g.c
 * @date 2020年5月1日下午8:51:37
 **/
public class LazySingletonTest4 {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Constructor<LazySingleton4> constructor = LazySingleton4.class.getDeclaredConstructor();
		constructor.setAccessible(true);
		LazySingleton4 newInstance = constructor.newInstance();
		LazySingleton4 instance = LazySingleton4.getInstance();
		System.out.println(newInstance == instance);
	}
}

/**
 * 
 * @author chao.guo
 *
 */
class LazySingleton4 {

	private volatile static LazySingleton4 instance;

	private LazySingleton4() {
		if (LazySingleton4.instance != null) {
			throw new RuntimeException("单例不允许多个实例");
		}
	}

	public static LazySingleton4 getInstance() {
		if (instance == null) {
			synchronized (LazySingleton4.class) {
				if (instance == null) {
					instance = new LazySingleton4();
				}
			}
		}
		return instance;
	}
}