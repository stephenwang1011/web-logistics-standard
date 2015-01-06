package com.incito.logistics.testcase.userPassword;

import com.incito.logistics.pages.pageshelper.UserPasswordPageHelper;

import com.incito.logistics.plugins.father.UserPasswordFather;

import org.testng.ITestContext;
import org.testng.annotations.Test;
/**
 * 
 * @author xy-incito-wy
 * @Decription 已经认证用户登录之后，进入修改密码页面，检查用户名是不是登录的用户名
 *
 */
public class UserPasswordPage_002_AuthenticatedNameCheck_Test extends UserPasswordFather{
	
	@Test
	public void changePasswdPageUsernameTestForAuthenticatedUser(ITestContext context){
		UserPasswordFather.userPasswordParpare(context, seleniumUtil);
		UserPasswordPageHelper.checkUserName(UserPasswordFather.username, seleniumUtil);
	}
	
	
	

}
