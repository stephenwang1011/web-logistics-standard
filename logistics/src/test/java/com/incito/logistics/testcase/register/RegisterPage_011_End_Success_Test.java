package com.incito.logistics.testcase.register;

/**
 *@author  xy-incito-wy
 *@Description 测试用例：成功注册
 * */
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import org.openqa.selenium.By;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.incito.logistics.base.BaseParpare;
import com.incito.logistics.pages.HomePage;
import com.incito.logistics.pages.RegisterPage;
import com.incito.logistics.pages.pageshelper.HomePageHelper;
import com.incito.logistics.pages.pageshelper.RegisterPageHelper;
import com.incito.logistics.util.ExcelDataProvider;

public class RegisterPage_011_End_Success_Test extends BaseParpare {

	@Test(dataProvider="data")
	public void registerSuccessTest(ITestContext context,Map<String,String> data) {
		final String USERNAME = "USERNAME";
		final String PASSWORD = "PASSWORD";
		final String REPASSWORD = "REPASSWORD";
		By bys[] = { RegisterPage.RP_INPUT_USERNAME, RegisterPage.RP_INPUT_PASSWD, RegisterPage.RP_INPUT_REPASSWD };

		int timeOut = Integer.valueOf(context.getCurrentXmlTest().getParameter("timeOut"));
		int sleepTime = Integer.valueOf(context.getCurrentXmlTest().getParameter("sleepTime"));

		HomePageHelper.waitHomePageToLoad(timeOut, seleniumUtil);
		HomePageHelper.enterPage(seleniumUtil, HomePage.HP_BUTTON_REG);
		RegisterPageHelper.waitRegisterPageToLoad(timeOut, seleniumUtil);
		RegisterPageHelper.checkRegisterPageText(seleniumUtil);
		for (By by : bys) {
			RegisterPageHelper.clearText(seleniumUtil, by);
		}	
		RegisterPageHelper.typeRegisterUserInfo(seleniumUtil, RegisterPage.RP_INPUT_USERNAME, data, USERNAME);
		RegisterPageHelper.typeRegisterUserInfo(seleniumUtil, RegisterPage.RP_INPUT_PASSWD, data, PASSWORD);
		RegisterPageHelper.typeRegisterUserInfo(seleniumUtil, RegisterPage.RP_INPUT_REPASSWD, data, REPASSWORD);
		RegisterPageHelper.enterPage(seleniumUtil, RegisterPage.RP_BUTTON_REGISTER);
		RegisterPageHelper.checkUserInfo(timeOut, sleepTime, seleniumUtil, USERNAME, data);

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
