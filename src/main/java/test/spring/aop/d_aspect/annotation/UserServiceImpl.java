package test.spring.aop.d_aspect.annotation;

import org.springframework.stereotype.Service;

@Service("userServiceId")
public class UserServiceImpl implements UserService {

	@Override
	public String addUser() {
		System.out.println("aop.d_aspect.annotation addUser");
		return "addUser_return";
	}

	@Override
	public String deleteUser() {
		System.out.println("aop.d_aspect.annotation deleteUser");
		int a = 1/0;
		return "deleteUser_return";
	}

	@Override
	public String updateUser() {
		System.out.println("aop.d_aspect.annotation updateUser");
		return "updateUser_return";
		
	}

}
