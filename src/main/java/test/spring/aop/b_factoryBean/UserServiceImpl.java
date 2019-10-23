package test.spring.aop.b_factoryBean;

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
