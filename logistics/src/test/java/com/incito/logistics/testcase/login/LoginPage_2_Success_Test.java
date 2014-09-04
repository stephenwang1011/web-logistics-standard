package com.incito.logistics.testcase.login;
/**
 *@author  xy-incito
 *@Description 测试用例：成功登陆
 * */
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.base.BaseParpare;
import com.incito.logistics.pages.HomePage;
import com.incito.logistics.pages.pageshelper.HomePageHelper;
import com.incito.logistics.pages.pageshelper.LoginPageHelper;
import com.incito.logistics.util.GetTestData;

public class LoginPage_2_Success_Test extends BaseParpare{
	
  @Test
  public void loginSuccessTest(ITestContext context) {
	  String configFilePath = context.getCurrentXmlTest().getParameter("userInfoPath");
	  String username = GetTestData.getTestData(configFilePath, "username");
	  String passcode = GetTestData.getTestData(configFilePath, "passcode");
	  int timeOut =Integer.valueOf(context.getCurrentXmlTest().getParameter("timeOut"));
	  int sleepTime =Integer.valueOf(context.getCurrentXmlTest().getParameter("sleepTime"));
	  
	  HomePageHelper.waitHomePageToLoad(timeOut,seleniumUtil);
	  HomePageHelper.enterPage(seleniumUtil, HomePage.HP_BUTTON_LOGIN);
	  LoginPageHelper.waitLoginPageToLoad(timeOut, seleniumUtil);
	  LoginPageHelper.login(seleniumUtil, username, passcode);
	  LoginPageHelper.checkUserInfo(timeOut, sleepTime, seleniumUtil, username);
  }
  
}
