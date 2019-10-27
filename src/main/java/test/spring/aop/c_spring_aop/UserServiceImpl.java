package test.spring.aop.c_spring_aop;

public class UserServiceImpl implements UserService {

	@Override
	public void addUser() {
		System.out.println("aop.spring_aop addUser");
	}

	@Override
	public void deleteUser() {
		System.out.println("aop.spring_aop deleteUser");
	}

	@Override
	public void updateUser() {
		System.out.println("aop.spring_aop updateUser");
	}

}
