package chao.design_pattern.singleton.hungry;

/**
 * @author g.c
 * @date 2020年5月1日下午9:58:26
 **/
public class HungrySingletonTest {

	public static void main(String[] args) {
		HungrySingleton instance = HungrySingleton.getInstance();
		HungrySingleton instance2 = HungrySingleton.getInstance();
		System.out.println(instance == instance2);
	}
}
/**
 * 类加载的初始化阶段完成了实例的初始化。本质上是借助于jvm类的加载机制，保证实例的唯一性。
 * 加载过程：
 * 1.加载二进制数据到内存中，生成对应的Class数据结构，
 * 2.连接：a：验证，b:准备（给类的静态成员变量赋初始值），c：解析
 * 3.初始化：给类的静态变量赋初值
 * 只有真正使用对应的类时，才会触发初始化。
 * @author chao.guo
 *
 */
class HungrySingleton {
	private static HungrySingleton instance = new HungrySingleton();

	private HungrySingleton() {
	}

	public static HungrySingleton getInstance() {
		return instance;
	}
}