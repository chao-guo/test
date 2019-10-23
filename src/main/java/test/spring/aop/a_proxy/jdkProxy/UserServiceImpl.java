package test.spring.aop.a_proxy.jdkProxy;

public class UserServiceImpl implements UserService {

	@Override
	public void addUser() {
		System.out.println("aop.proxy addUser");
	}

	@Override
	public void deleteUser() {
		System.out.println("aop.proxy deleteUser");
	}

	@Override
	public void updateUser() {
		System.out.println("aop.proxy updateUser");
	}

}
