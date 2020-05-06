package chao.design_pattern.singleton.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author g.c
 * @date 2020年5月1日下午10:34:14
 **/
public class InnerClassSingletonTest {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException, ReflectiveOperationException, IllegalArgumentException, InvocationTargetException {

		Constructor<InnerClassSingleton> declaredConstructor = InnerClassSingleton.class.getDeclaredConstructor();
		declaredConstructor.setAccessible(true);
		InnerClassSingleton newInstance = declaredConstructor.newInstance();
		InnerClassSingleton instance = InnerClassSingleton.getInstance();
		System.out.println(newInstance == instance);
	}
}

/**
 * @author chao.guo
 *
 */
class InnerClassSingleton {
	private static class InnerClassHolder {
		private static InnerClassSingleton instance = new InnerClassSingleton();
	}

	private InnerClassSingleton() {
	}

	public static InnerClassSingleton getInstance() {
		return InnerClassHolder.instance;
	}
}
