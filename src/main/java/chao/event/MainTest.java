package chao.event;

public class MainTest {

	public static void main(String[] args) {
		EventSourceObject object = new EventSourceObject();
		//注册监听器
		object.addCusListtener(new CusEventListener() {
			public void fireCusEvent(CusEvent e) {
				super.fireCusEvent(e);
			}
		});
		//触发事件
		object.setName("aaa");
	}
}
