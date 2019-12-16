package chao.spring.aop.d_aspect.xml;

public class UserServiceImpl implements UserService {

	@Override
	public String addUser() {
		System.out.println("aop.d_aspect.xml addUser");
		return "addUser_return";
	}

	@Override
	public String deleteUser() {
		System.out.println("aop.d_aspect.xml deleteUser");
		return "deleteUser_return";
	}

	@Override
	public String updateUser() {
		System.out.println("aop.d_aspect.xml updateUser");
		int as = 1/0;
		return "updateUser_return";
		
	}

}
