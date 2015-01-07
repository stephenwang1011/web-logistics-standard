package com.incito.logistics.testcase.userPassword;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.pageshelper.UserPasswordPageHelper;
import com.incito.logistics.plugins.father.UserPasswordAttestingFather;
/**
 * 
 * @author xy-incito-wy
 * @Decription 认证审核中的用户登录之后，进入修改密码页面，检查用户名是不是登录的用户名
 *
 */
public class UserPasswordPage_202_AttestingNameCheck_Test extends UserPasswordAttestingFather{
	
	@Test
	public void changePasswdPageUsernameTestForAttestingUser(ITestContext context){
		UserPasswordAttestingFather.userPasswordParpare(context, seleniumUtil);
		UserPasswordPageHelper.checkUserName(UserPasswordAttestingFather.modifyusername2, seleniumUtil);
	}
	
	
	

}
