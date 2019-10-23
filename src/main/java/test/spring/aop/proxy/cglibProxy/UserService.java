package test.spring.aop.proxy.cglibProxy;

public class UserService {

	public void addUser() {
		System.out.println("aop.proxy addUser");
	}

	public void deleteUser() {
		System.out.println("aop.proxy deleteUser");
	}

	public void updateUser() {
		System.out.println("aop.proxy updateUser");
	}

}
