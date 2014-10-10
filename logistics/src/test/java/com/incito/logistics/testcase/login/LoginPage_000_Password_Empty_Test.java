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
public class LoginPage_000_Password_Empty_Test extends BaseParpare {

	@Test(dataProvider = "data")
	public void loginFailTest_Password_Empty(ITestContext context, Map<String, String> data) {
		int timeOut = Integer.valueOf(context.getCurrentXmlTest().getParameter("timeOut"));
		int waitMillisecondsForAlert = Integer.valueOf(context.getCurrentXmlTest().getParameter("waitMillisecondsForAlert"));

		HomePageHelper.waitHomePageToLoad(timeOut, seleniumUtil);
		HomePageHelper.enterPage(seleniumUtil, HomePage.HP_BUTTON_LOGIN);
		LoginPageHelper.waitLoginPageToLoad(timeOut, seleniumUtil);

		seleniumUtil.findElementBy(LoginPage.LP_INPUT_USERNAME).sendKeys(data.get("USERNAME"));
		seleniumUtil.findElementBy(LoginPage.LP_INPUT_USERNAME).sendKeys(data.get("PASSWORD"));
		seleniumUtil.click(seleniumUtil.findElementBy(LoginPage.LP_BUTTON_LOGIN));
		seleniumUtil.isTextCorrect(seleniumUtil.switchToPromptedAlertAfterWait(waitMillisecondsForAlert).getText(), data.get("EXPECT"));
		seleniumUtil.switchToPromptedAlertAfterWait(waitMillisecondsForAlert).accept();
		seleniumUtil.findElementBy(LoginPage.LP_BUTTON_CLOSE).click();
		seleniumUtil.pause(2000);

	}

	@DataProvider(name = "data")
	public  Iterator<Object[]> dataFortestMethod() throws IOException {
		String moduleName = null; //模块的名字
		String caseNum = null;  //用例编号
		String className = this.getClass().getName();
		 int dotIndexNum = className.indexOf("."); //取得第一个.的index 
		 int underlineIndexNum = className.indexOf("_");  //取得第一个_的index 
		 
		 if (dotIndexNum > 0) {
			 moduleName = className.substring(30,className.lastIndexOf(".")); //取到模块的名称
		 }
		 
		 if (underlineIndexNum > 0) {
			 caseNum = className.substring(underlineIndexNum+1, underlineIndexNum+4); //取到用例编号
		 }
		//将模块名称和用例的编号传给 ExcelDataProvider ，然后进行读取excel数据
		return new ExcelDataProvider(moduleName, caseNum);
	}
	
}