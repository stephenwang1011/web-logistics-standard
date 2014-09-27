package com.incito.logistics.testcase.login;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.incito.logistics.base.BaseParpare;
import com.incito.logistics.pages.HomePage;
import com.incito.logistics.pages.LoginPage;
import com.incito.logistics.pages.pageshelper.HomePageHelper;
import com.incito.logistics.pages.pageshelper.LoginPageHelper;
import com.incito.logistics.util.ExcelDataProvider;

/**
 * @author xy-incito
 * @Description 登陆失败：用户名和密码都不填写
 * */
public class Fail_Password_Empty_Test extends BaseParpare {

	@Test(dataProvider = "data" )
	public void loginFailTest_Password_Empty(ITestContext context,Map<String,String> data) {
		int timeOut = Integer.valueOf(context.getCurrentXmlTest().getParameter("timeOut"));
		int waitMillisecondsForAlert = Integer.valueOf(context.getCurrentXmlTest().getParameter("waitMillisecondsForAlert"));

		HomePageHelper.waitHomePageToLoad(timeOut, seleniumUtil);
		HomePageHelper.enterPage(seleniumUtil, HomePage.HP_BUTTON_LOGIN);
		LoginPageHelper.waitLoginPageToLoad(timeOut, seleniumUtil);
		
		seleniumUtil.findElementBy(LoginPage.LP_INPUT_USERNAME).sendKeys(data.get("USERNAME"));
		seleniumUtil.findElementBy(LoginPage.LP_INPUT_USERNAME).sendKeys(data.get("PASSWORD"));
		seleniumUtil.click(seleniumUtil.findElementBy(LoginPage.LP_BUTTON_LOGIN));
		seleniumUtil.isTextCorrect(seleniumUtil.switchToPromptedAlertAfterWait(waitMillisecondsForAlert).getText(), data.get("EXPECT"));

	}
	
	
    @DataProvider(name = "data")
    public Iterator<Object[]> dataFortestMethod() throws IOException {
        return new ExcelDataProvider(this.getClass().getName(),"login");
    }
   
}