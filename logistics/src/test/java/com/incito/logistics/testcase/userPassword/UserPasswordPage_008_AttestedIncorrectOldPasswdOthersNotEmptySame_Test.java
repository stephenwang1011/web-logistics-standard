package com.incito.logistics.testcase.userPassword;

import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.UserPasswordPage;
import com.incito.logistics.pages.pageshelper.UserPasswordPageHelper;
import com.incito.logistics.plugins.father.UserPasswordFather;
/**
 * 
 * @author xy-incito-wy
 * @Decription 已经认证用户登录之后，进入修改密码页面，输入错误的当前密码，新密码和确认密码为空，点击提交按钮，不能修改提交成功
 * @note 等Bug #8704修复之后 更改
 */
public class UserPasswordPage_008_AttestedIncorrectOldPasswdOthersNotEmptySame_Test extends UserPasswordFather{
	
	@Test(dataProvider="data")
	public void incorrectOldPasswdOthersNotEmptySameForAttestedUser(ITestContext context,Map<String,String> data){
		UserPasswordFather.userPasswordParpare(context, seleniumUtil);
		UserPasswordPageHelper.typeChangePasswdInfo(seleniumUtil, data.get("OLD_PASSWORD"), data.get("NEW_PASSWORD"), data.get("CORFIRM_PASSWORD"));
		UserPasswordPageHelper.enterPage(seleniumUtil, UserPasswordPage.USP_BUTTON_OK);
		UserPasswordPageHelper.checkModifyPasswdFailed(seleniumUtil, modifyusername, modifypassword, timeOut,sleepTime);

	}
	
	
	

}
