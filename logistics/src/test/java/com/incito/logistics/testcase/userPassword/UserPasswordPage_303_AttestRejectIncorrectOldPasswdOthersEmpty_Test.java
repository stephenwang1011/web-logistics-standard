package com.incito.logistics.testcase.userPassword;

import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.UserPasswordPage;
import com.incito.logistics.pages.pageshelper.UserPasswordPageHelper;
import com.incito.logistics.plugins.father.UserPasswordAttestRejectFather;
/**
 * 
 * @author xy-incito-wy
 * @Decription 认证驳回的用户登录之后，进入修改密码页面，输入错误的当前密码，新密码和确认密码为空，点击提交按钮，不能修改提交成功
 */
public class UserPasswordPage_303_AttestRejectIncorrectOldPasswdOthersEmpty_Test extends UserPasswordAttestRejectFather{
	
	@Test(dataProvider="data")
	public void incorrectOldPasswdOthersEmptyForAttestRejectUser(ITestContext context,Map<String,String> data){
		UserPasswordAttestRejectFather.userPasswordParpare(context, seleniumUtil);
		UserPasswordPageHelper.typeChangePasswdInfo(seleniumUtil, data.get("OLD_PASSWORD"), data.get("NEW_PASSWORD"), data.get("CORFIRM_PASSWORD"));
		UserPasswordPageHelper.enterPage(seleniumUtil, UserPasswordPage.USP_BUTTON_OK);
		UserPasswordPageHelper.checkModifyPasswdFailed(seleniumUtil, modifyusername3, modifypassword3, timeOut,sleepTime);

	}
	
	
	

}
