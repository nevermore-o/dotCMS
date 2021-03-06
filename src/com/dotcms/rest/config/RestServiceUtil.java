package com.dotcms.rest.config;

import com.dotcms.rest.servlet.ReloadableServletContainer;
import com.dotmarketing.util.Logger;



public class RestServiceUtil {
	
	


	
	public synchronized static void addResource(Class clazz){
		
		new DotRestApplication().getClasses();
		if(DotRestApplication.REST_CLASSES.contains(clazz)){
			return;
		}
		
		DotRestApplication.REST_CLASSES.add(clazz);

		reloadRest();
		

		
	}
	
	public  synchronized static void removeResource(Class clazz){
		new DotRestApplication().getClasses();
		if(DotRestApplication.REST_CLASSES.contains(clazz)){
			DotRestApplication.REST_CLASSES.remove(clazz);
			reloadRest();
		}
	}
	
	public synchronized static void reloadRest(){

		Logger.error(RestServiceUtil.class, "RELOADING DOES NOT WORK YET");
		ReloadableServletContainer.reload(new DotRestApplication());
		
	}

}
