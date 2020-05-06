package chao.design_pattern.singleton.hungry;
/**
* @author g.c
* @date 2020年5月2日下午10:43:05
**/
public enum EnumSingleton {

	INSTANCE;
	
	public void print() {
		System.out.println(this.hashCode());
	}

	static class EnumTest {
		public static void main(String[] args) {
			EnumSingleton instance = EnumSingleton.INSTANCE;
			EnumSingleton instance2 = EnumSingleton.INSTANCE;
			System.out.println(instance == instance2);
		}
	}
}

