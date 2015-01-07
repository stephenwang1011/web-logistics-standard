package com.incito.logistics.testcase.userPassword;

import com.incito.logistics.pages.pageshelper.UserPasswordPageHelper;
import com.incito.logistics.plugins.father.UserPasswordAttestedFather;

import org.testng.ITestContext;
import org.testng.annotations.Test;
/**
 * 
 * @author xy-incito-wy
 * @Description 已经认证用户登录之后，进入修改密码页面，检查修改密码页面UI
 *
 */
public class UserPasswordPage_001_AttestedUI_Test extends UserPasswordAttestedFather{
	
	@Test
	public void changePasswdPageUITestForAttestedUser(ITestContext context){
		UserPasswordAttestedFather.userPasswordParpare(context, seleniumUtil);
		UserPasswordPageHelper.checkUserAttestStatus(seleniumUtil, "attested");
	}
	
	
	

}
