package com.incito.logistics.testcase.userPassword;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.pageshelper.UserPasswordPageHelper;
import com.incito.logistics.plugins.father.UserPasswordAttestRejectFather;
/**
 * 
 * @author xy-incito-wy
 * @Description 认证未通过的用户登录之后，进入修改密码页面，检查修改密码页面UI
 *
 */
public class UserPasswordPage_301_AttestRejectUI_Test extends UserPasswordAttestRejectFather{
	
	@Test
	public void changePasswdPageUITestForAttestRejectUser(ITestContext context){
		UserPasswordAttestRejectFather.userPasswordParpare(context, seleniumUtil);
		UserPasswordPageHelper.checkUserAttestStatus(seleniumUtil, "attest reject");
	}
	
	
	

}
