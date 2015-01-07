package com.incito.logistics.testcase.userPassword;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.pageshelper.UserPasswordPageHelper;
import com.incito.logistics.plugins.father.UserPasswordAttestingFather;
/**
 * 
 * @author xy-incito-wy
 * @Description 认证审核中的用户登录之后，进入修改密码页面，检查修改密码页面UI
 *
 */
public class UserPasswordPage_201_AttestingUI_Test extends UserPasswordAttestingFather{
	
	@Test
	public void changePasswdPageUITestForUnattestedUser(ITestContext context){
		UserPasswordAttestingFather.userPasswordParpare(context, seleniumUtil);
		UserPasswordPageHelper.checkUserAttestStatus(seleniumUtil, "attesting");
	}
	
	
	

}
