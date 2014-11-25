package com.incito.logistics.testcase.login;

/**
 *@author  xy-incito-wy
 *@Description 测试用例：登陆界面复选框是不是可以勾选
 *
 * */
import org.testng.ITestContext;
import org.testng.annotations.Test;
import com.incito.logistics.base.BaseParpare;
import com.incito.logistics.pages.HomePage;
import com.incito.logistics.pages.pageshelper.HomePageHelper;
import com.incito.logistics.pages.pageshelper.LoginPageHelper;

public class LoginPage_009_Checkbox_Test extends BaseParpare {
	@Test
	public void uiTest(ITestContext context) {
		
		int timeOut = Integer.valueOf(context.getCurrentXmlTest().getParameter("timeOut"));

		HomePageHelper.waitHomePageToLoad(timeOut, seleniumUtil); 
		HomePageHelper.enterPage(seleniumUtil, HomePage.HP_BUTTON_LOGIN); 
		LoginPageHelper.waitLoginPageToLoad(timeOut, seleniumUtil); 
		LoginPageHelper.checkLoginPageText(seleniumUtil); 
		LoginPageHelper.checkInputData(seleniumUtil); 
		LoginPageHelper.doesCheckBoxSelect(seleniumUtil);
		
	}

}
