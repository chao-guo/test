package chao.spring.aop.b_factoryBean;

public class UserServiceImpl implements UserService {

	@Override
	public void addUser() {
		System.out.println("aop.b_factoryBean addUser");
	}

	@Override
	public void deleteUser() {
		System.out.println("aop.b_factoryBean deleteUser");
	}

	@Override
	public void updateUser() {
		System.out.println("aop.b_factoryBean updateUser");
	}

}
