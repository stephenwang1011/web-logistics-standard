package com.incito.logistics.testcase.userPassword;

import com.incito.logistics.plugins.father.UserPasswordFather;
import org.testng.ITestContext;
import org.testng.annotations.Test;
/**
 * 
 * @author xy-incito-wy
 * @Description 已经认证用户登录之后，进入修改密码页面，检查修改密码页面UI
 *
 */
public class UserPasswordPage_001_AuthenticatedUI_Test extends UserPasswordFather{
	
	@Test
	public void changePasswdPageUITestForAuthenticatedUser(ITestContext context){
		UserPasswordFather.userPasswordParpare(context, seleniumUtil);
	}
	
	
	

}
