package com.incito.logistics.testcase.adduserinfo;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.pageshelper.AddUserInfoPagerHelper;
import com.incito.logistics.base.BaseParpare;
import com.incito.logistics.pages.AddUserInfoPage;
import com.incito.logistics.pages.HomePage;
import com.incito.logistics.pages.pageshelper.HomePageHelper;
import com.incito.logistics.pages.pageshelper.LoginPageHelper;
import com.incito.logistics.util.PropertiesDataProvider;

/**
 * @author xy-incito-wk
 * @Description 填写姓名，联系方式，公司名称点击提交
 *
 * */
public class AddUserInfoPage_19_Fail_NameTelCompany_Text extends BaseParpare {
	@Test
	public void addUserInfoPageFailNameTelCompany(ITestContext context) {
		String configFilePath = String.valueOf(context.getCurrentXmlTest().getParameter("userInfoPath"));
		int timeOut = Integer.valueOf(context.getCurrentXmlTest().getParameter("timeOut"));
		String register_username = PropertiesDataProvider.getTestData(configFilePath, "register_username");
		String password = PropertiesDataProvider.getTestData(configFilePath, "password");

		HomePageHelper.waitHomePageToLoad(timeOut, seleniumUtil);
		HomePageHelper.enterPage(seleniumUtil, HomePage.HP_BUTTON_LOGIN);
		LoginPageHelper.login(seleniumUtil, register_username, password);
		seleniumUtil.waitForElementToLoad(timeOut, HomePage.HP_BUTTON_FREESEND);
		HomePageHelper.enterPage(seleniumUtil, HomePage.HP_BUTTON_FREESEND);
		AddUserInfoPagerHelper.waitAddUserInfoPageToLoad(timeOut, seleniumUtil);
		AddUserInfoPagerHelper.enterPage(seleniumUtil, AddUserInfoPage.AUIP_BUTTON_SUBMIT);
		AddUserInfoPagerHelper.checkAddUserInfoPrompt_NameTelCompany(timeOut, seleniumUtil);
	}

}
