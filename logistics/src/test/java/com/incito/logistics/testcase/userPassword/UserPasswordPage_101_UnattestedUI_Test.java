package com.incito.logistics.testcase.userPassword;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.pageshelper.UserPasswordPageHelper;
import com.incito.logistics.plugins.father.UserPasswordUnattestedFather;
/**
 * 
 * @author xy-incito-wy
 * @Description 未认证用户登录之后，进入修改密码页面，检查修改密码页面UI
 *
 */
public class UserPasswordPage_101_UnattestedUI_Test extends UserPasswordUnattestedFather{
	
	@Test
	public void changePasswdPageUITestForUnattestedUser(ITestContext context){
		UserPasswordUnattestedFather.userPasswordParpare(context, seleniumUtil);
		UserPasswordPageHelper.checkUserAttestStatus(seleniumUtil, "unattested");
	}
	
	
	

}
