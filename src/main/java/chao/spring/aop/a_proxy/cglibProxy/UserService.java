package chao.spring.aop.a_proxy.cglibProxy;

public class UserService {

	public void addUser() {
		System.out.println("myaop.proxy addUser");
	}

	public void deleteUser() {
		System.out.println("myaop.proxy deleteUser");
	}

	public void updateUser() {
		System.out.println("myaop.proxy updateUser");
	}

}
