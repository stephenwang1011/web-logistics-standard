package com.incito.logistics.testcase.userPassword;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.pageshelper.UserPasswordPageHelper;
import com.incito.logistics.plugins.father.UserPasswordUnattestedFather;
/**
 * 
 * @author xy-incito-wy
 * @Decription 未认证用户登录之后，进入修改密码页面，检查用户名是不是登录的用户名
 *
 */
public class UserPasswordPage_102_UnattestedNameCheck_Test extends UserPasswordUnattestedFather{
	
	@Test
	public void changePasswdPageUsernameTestForAttestedUser(ITestContext context){
		UserPasswordUnattestedFather.userPasswordParpare(context, seleniumUtil);
		UserPasswordPageHelper.checkUserName(UserPasswordUnattestedFather.modifyusername1, seleniumUtil);
	}
	
	
	

}
