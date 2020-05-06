package chao.design_pattern.singleton.hungry;

/**
 * @author g.c
 * @date 2020年5月1日下午10:34:14
 **/
public class InnerClassSingletonTest {

	public static void main(String[] args) {

		InnerClassSingleton instance = InnerClassSingleton.getInstance();
		InnerClassSingleton instance2 = InnerClassSingleton.getInstance();
		System.out.println(instance == instance2);
	}
}
/**
 * 基于静态内部类的单例模式
 * 同样是利用了jvm类的加载机制保证单例
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
