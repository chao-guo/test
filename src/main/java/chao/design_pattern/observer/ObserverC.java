package chao.design_pattern.observer;
/*
 * 具体观察者对象
 */
public class ObserverC implements Observer {

	private String observerState;
	
	@Override
	public void update(String newState) {
		 //更新观察者状态，让它与目标状态一致
        observerState = newState;
        System.out.println("SZH, 接收到消息：" + newState + "；我是C模块，快来抢吧！！");
	}
	
	

}