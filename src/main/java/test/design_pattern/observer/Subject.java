package test.design_pattern.observer;

import java.util.ArrayList;
import java.util.List;

/*
 * 被观察者，它将所有观察者对象的引用保存在一个集合中
 */
public class Subject {

	// 保存注册的观察者对象
	private List<Observer> mobservers = new ArrayList<>();

	// 注册观察者对象
	public void attach(Observer observer) {
		mobservers.add(observer);
		System.out.println("SZH, attach an observer");
	}

	// 注销观察者对象
	public void detach(Observer observer) {
		mobservers.remove(observer);
		System.out.println("SZH, detach an observer");
	}

	// 通知所有注册的观察者对象
	public void notifyEveryOne(String newState) {
		for (Observer observer : mobservers) {
			observer.update(newState);
		}
	}
	
	
}
