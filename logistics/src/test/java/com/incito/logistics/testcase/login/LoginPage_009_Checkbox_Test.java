package com.incito.logistics.testcase.login;

/**
 *@author  xy-incito-wy
 *@Description 测试用例：登陆界面复选框是不是可以勾选
 *
 * */
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.pageshelper.LoginPageHelper;
import com.incito.logistics.plugins.father.LoginFather;

public class LoginPage_009_Checkbox_Test extends LoginFather{
	@Test
	public void uiTest(ITestContext context) {
		LoginFather.loginParpare(context, seleniumUtil);
		LoginPageHelper.doesCheckBoxSelect(seleniumUtil);
		
	}

}
