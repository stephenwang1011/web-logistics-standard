package com.incito.logistics.testcase.userPassword;

import com.incito.logistics.pages.pageshelper.UserPasswordPageHelper;

import com.incito.logistics.plugins.father.UserPasswordAttestedFather;

import org.testng.ITestContext;
import org.testng.annotations.Test;
/**
 * 
 * @author xy-incito-wy
 * @Decription 已经认证用户登录之后，进入修改密码页面，检查用户名是不是登录的用户名
 *
 */
public class UserPasswordPage_002_AttestedNameCheck_Test extends UserPasswordAttestedFather{
	
	@Test
	public void changePasswdPageUsernameTestForAttestedUser(ITestContext context){
		UserPasswordAttestedFather.userPasswordParpare(context, seleniumUtil);
		UserPasswordPageHelper.checkUserName(UserPasswordAttestedFather.modifyusername, seleniumUtil);
	}
	
	
	

}
