package com.incito.logistics.testcase.userPassword;

import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.UserPasswordPage;
import com.incito.logistics.pages.pageshelper.UserPasswordPageHelper;
import com.incito.logistics.plugins.father.UserPasswordAttestingFather;
/**
 * 
 * @author xy-incito-wy
 * @Decription 认证审核中用户登录之后，进入修改密码页面，输入正确的前密码，新密码和确认密码不为空，但是不相同，点击提交按钮，不能修改提交成功
 */
public class UserPasswordPage_211_AttestingCorrectOldPasswdOthersNotEmptyDiff_Test extends UserPasswordAttestingFather{
	
	@Test(dataProvider="data")
	public void correctOldPasswdOthersNotEmptyDiffForAttestingUser(ITestContext context,Map<String,String> data){
		UserPasswordAttestingFather.userPasswordParpare(context, seleniumUtil);
		UserPasswordPageHelper.typeChangePasswdInfo(seleniumUtil, data.get("OLD_PASSWORD"), data.get("NEW_PASSWORD"), data.get("CORFIRM_PASSWORD"));
		UserPasswordPageHelper.enterPage(seleniumUtil, UserPasswordPage.USP_BUTTON_OK);
		UserPasswordPageHelper.checkModifyPasswdFailed(seleniumUtil, modifyusername2, modifypassword2, timeOut,sleepTime);

	}
	
	
	

}
