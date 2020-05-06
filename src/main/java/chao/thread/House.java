package chao.thread;

public class House implements Runnable {

	int water;
	
	public void setWater(int water) {
		this.water = water;
	}
	
	@Override
	public void run() {
		while(true) {
			String name = Thread.currentThread().getName();
			if(name.equals("狗")) {
				System.out.println(name + "喝水");
				water = water - 2;
			}else if(name.equals("猫")) {
				System.out.println(name + "喝水");
				water = water - 1;
			}
			System.out.println("剩" + water);
			try {
				Thread.sleep(2000);
			} catch (Exception e) {
				// TODO: handle exception
			}
			if(water <= 0) {
				return;
			}
		}
	}

}
