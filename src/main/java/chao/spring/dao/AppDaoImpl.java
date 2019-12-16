package chao.spring.dao;

public class AppDaoImpl implements AppDao {

	@Override
	public void saveApp() {
		
			System.out.println("appDap app save");
	}
	
	public void appInit() {
		System.out.println("App Init");
	}
	
	public void appDestroy() {
		System.out.println("App Destroy");
	}

}
