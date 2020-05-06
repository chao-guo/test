package chao.design_pattern.singleton.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author g.c
 * @date 2020年5月1日下午10:34:14
 **/
public class InnerClassSingletonTest2 {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException,
			ReflectiveOperationException, IllegalArgumentException, InvocationTargetException {

		Constructor<InnerClassSingleton2> declaredConstructor = InnerClassSingleton2.class.getDeclaredConstructor();
		declaredConstructor.setAccessible(true);
		InnerClassSingleton2 newInstance = declaredConstructor.newInstance();
		InnerClassSingleton2 instance = InnerClassSingleton2.getInstance();
		System.out.println(newInstance == instance);
	}
}

/**
 * @author chao.guo
 *
 */
class InnerClassSingleton2 {
	private static class InnerClassHolder2 {
		private static InnerClassSingleton2 instance = new InnerClassSingleton2();
	}

	private InnerClassSingleton2() {
		if (InnerClassHolder2.instance != null) {
			throw new RuntimeException("单例不允许多个实例");
		}
	}

	public static InnerClassSingleton2 getInstance() {
		return InnerClassHolder2.instance;
	}
}
