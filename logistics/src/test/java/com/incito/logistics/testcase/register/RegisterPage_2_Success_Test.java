package com.incito.logistics.testcase.register;

/**
 *@author  xy-incito
 *@Description 此用例会产生依赖，故一个用例中会有几个Test
 *1、注册
 *2、检查注册成功后提示信息是不是显示出来
 *3、前两步完成以后检查用户名是不是和注册时一样
 *4、注册完成以后点击发布货源完善信息页面是不是弹出来
 *
 * */
import org.openqa.selenium.By;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.base.BaseParpare;
import com.incito.logistics.pages.HomePage;
import com.incito.logistics.pages.RegisterPage;
import com.incito.logistics.pages.pageshelper.HomePageHelper;
import com.incito.logistics.pages.pageshelper.RegisterPageHelper;
import com.incito.logistics.util.GetTestData;

public class RegisterPage_2_Success_Test extends BaseParpare {
	@Test
	public void registSuccessTest(ITestContext context) {
		String userInfoPath = context.getCurrentXmlTest().getParameter("userInfoPath");
		String register_username = GetTestData.getTestData(userInfoPath, "register_username");
		String register_password = GetTestData.getTestData(userInfoPath, "register_password");
		String register_repassword = GetTestData.getTestData(userInfoPath, "register_repassword");
		String keys[] = new String[] { register_username, register_password, register_repassword };
		By bys[] = { RegisterPage.RP_INPUT_USERNAME, RegisterPage.RP_INPUT_PASSWD, RegisterPage.RP_INPUT_REPASSWD };
		int timeOut = Integer.valueOf(context.getCurrentXmlTest().getParameter("timeOut"));

		HomePageHelper.waitHomePageToLoad(timeOut, seleniumUtil);
		HomePageHelper.enterPage(seleniumUtil, HomePage.HP_BUTTON_REG);
		RegisterPageHelper.waitRegisterPageToLoad(timeOut, seleniumUtil);
		RegisterPageHelper.checkRegisterPageText(seleniumUtil);
		// 一个循环输入所有注册信息
		for (int i = 0; i < keys.length; i++) {
			RegisterPageHelper.sendRegisterInfo(bys[i], keys[i], seleniumUtil);
		}
		RegisterPageHelper.enterPage(seleniumUtil, RegisterPage.RP_BUTTON_REGISTER);

	}

}
