package chao.event;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*
 * 事件源
 */
public class EventSourceObject {

	private String name;
	
	//监听器容器
	private Set<CusEventListener> listener;
	
	public EventSourceObject() {
		this.listener = new HashSet<CusEventListener>();
		this.name = "defaultname";
	}
	
	//给事件源注册监听器
	public void addCusListtener(CusEventListener cel) {
		this.listener.add(cel);
	}
	
	//当事件发生时，通知注册在该事件源上的所有监听器作出相应的反应（回调）
	protected void notifies() {
		CusEventListener cel = null;
		Iterator<CusEventListener> iterator = this.listener.iterator();
		while(iterator.hasNext()) {
			cel = iterator.next();
			cel.fireCusEvent(new CusEvent(this));
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		notifies();
	}
	
}
