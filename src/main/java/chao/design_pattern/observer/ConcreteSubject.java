package chao.design_pattern.observer;

/*
 * 具体的被观察者对象
 */
public class ConcreteSubject extends Subject {

	private String state;

	public String getState() {
		return state;
	}

	public void change(String newState) {
		state = newState;
		System.out.println("SZH, concreteSubject state:" + newState);
		// 状态发生改变，通知观察者
		notifyEveryOne(newState);
	}
}
