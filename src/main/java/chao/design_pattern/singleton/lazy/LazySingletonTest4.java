package chao.design_pattern.singleton.lazy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author g.c
 * @date 2020年5月1日下午8:51:37
 **/
public class LazySingletonTest4 {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Constructor<LazySingleton4> constructor = LazySingleton4.class.getDeclaredConstructor();
		constructor.setAccessible(true);
		LazySingleton4 newInstance = constructor.newInstance();
		LazySingleton4 instance = LazySingleton4.getInstance();
		System.out.println(newInstance == instance);
	}
}

/**
 * 此种情况下，在实例化时【instance = new LazySingleton4()】在字节码层面上仍然会有问题 [可以先去了解下指令重排序原理]
 * instance = new LazySingleton4()的字节码操作分为下面三个步骤： (1)分配空间 (2)初始化 (3)引用赋值
 * 字节码指令在执行时，即时编译、jvm、cpu可能会对这三步操作做优化，在不影响的这一步操作的情况下指令重排序，比如这三步
 * 里面，第二步第三步就可以换顺序，其中如果2和3换顺序后多线程时，前一个线程先给引用赋值还未初始化，后一个线程第一次判
 * 空已经不为空，拿到的instance还未初始化，可能会出现空指针等错误，为了避免这种情况发生，在instance变量上加volatile，
 * 防止指令重排序
 * 
 * @author chao.guo
 *
 */
class LazySingleton4 {

	private volatile static LazySingleton4 instance;

	private LazySingleton4() {
	}

	public static LazySingleton4 getInstance() {
		if (instance == null) {
			synchronized (LazySingleton3.class) {
				if (instance == null) {
					instance = new LazySingleton4();
				}
			}
		}
		return instance;
	}
}