package com.incito.logistics.testcase.userPassword;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.pageshelper.UserPasswordPageHelper;
import com.incito.logistics.plugins.father.UserPasswordAttestRejectFather;
/**
 * 
 * @author xy-incito-wy
 * @Decription 认证未通过中的用户登录之后，进入修改密码页面，检查用户名是不是登录的用户名
 *
 */
public class UserPasswordPage_302_AttestRejectNameCheck_Test extends UserPasswordAttestRejectFather{
	
	@Test
	public void changePasswdPageUsernameTestForAttestRejectUser(ITestContext context){
		UserPasswordAttestRejectFather.userPasswordParpare(context, seleniumUtil);
		UserPasswordPageHelper.checkUserName(UserPasswordAttestRejectFather.modifyusername3, seleniumUtil);
	}
	
	
	

}
