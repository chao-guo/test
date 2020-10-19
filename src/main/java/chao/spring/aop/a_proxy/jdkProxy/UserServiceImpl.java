package chao.spring.aop.a_proxy.jdkProxy;

public class UserServiceImpl implements UserService {

	@Override
	public void addUser() {
		System.out.println("myaop.proxy addUser");
	}

	@Override
	public void deleteUser() {
		System.out.println("myaop.proxy deleteUser");
	}

	@Override
	public void updateUser() {
		System.out.println("myaop.proxy updateUser");
	}

}
