package chao.thread.thread;

public class testThread {
	public static void main(String[] args) {
		House house = new House();
		house.setWater(10000);
		Thread dog = new Thread(house);
		Thread cat = new Thread(house);
		dog.setName("狗");
		cat.setName("猫");
		dog.start();
		cat.start();
	}
}
