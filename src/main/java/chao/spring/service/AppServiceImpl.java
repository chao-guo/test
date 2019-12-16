package chao.spring.service;

import chao.spring.dao.AppDao;

public class AppServiceImpl implements AppService {

	private AppDao appDao;
	
	
	
	public AppDao getAppDao() {
		return appDao;
	}



	public void setAppDao(AppDao appDao) {
		this.appDao = appDao;
	}



	@Override
	public void addApp() {
		
		System.out.println("appService app add");
		appDao.saveApp();
	}

}
