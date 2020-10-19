package chao.spring.aop.c_spring_aop;

public class UserServiceImpl implements UserService {

	@Override
	public void addUser() {
		System.out.println("myaop.spring_aop addUser");
	}

	@Override
	public void deleteUser() {
		System.out.println("myaop.spring_aop deleteUser");
	}

	@Override
	public void updateUser() {
		System.out.println("myaop.spring_aop updateUser");
	}

}
