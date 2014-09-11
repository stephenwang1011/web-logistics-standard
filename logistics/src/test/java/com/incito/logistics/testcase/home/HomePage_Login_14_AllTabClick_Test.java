package com.incito.logistics.testcase.home;

/**
 *@author  xy-incito
 *@Description 测试用例：成功登陆之后点击每个tab 是不是能正常进入
 * */
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.base.BaseParpare;
import com.incito.logistics.pages.FindCarsPage;
import com.incito.logistics.pages.HomePage;
import com.incito.logistics.pages.LoginPage;
import com.incito.logistics.pages.pageshelper.FindCarsPagerHelper;
import com.incito.logistics.pages.pageshelper.HomePageHelper;
import com.incito.logistics.pages.pageshelper.LoginPageHelper;

public class HomePage_Login_14_AllTabClick_Test extends BaseParpare {

	@Test
	public void loginSuccessTest(ITestContext context) {
		String username = context.getCurrentXmlTest().getParameter("username");
		String passcode = context.getCurrentXmlTest().getParameter("passcode");
		int timeOut = Integer.valueOf(context.getCurrentXmlTest().getParameter("timeOut"));
		int sleepTime = Integer.valueOf(context.getCurrentXmlTest().getParameter("sleepTime"));
		HomePageHelper.waitHomePageToLoad(timeOut, seleniumUtil);
		seleniumUtil.click(seleniumUtil.findElementBy(HomePage.HP_BUTTON_LOGIN));
		isDisplay(timeOut);
		LoginPageHelper.login(seleniumUtil, username, passcode);
		verifyUserInfo(timeOut, sleepTime);
		verifyAllTab(timeOut);
	}

	// 检查页面元素是不是显示出来
	public void isDisplay(int timeOut) {
		seleniumUtil.waitForElementToLoad(timeOut, LoginPage.LP_CHECKBOX_AUTO);
		seleniumUtil.waitForElementToLoad(timeOut, LoginPage.LP_INPUT_USERNAME);
		seleniumUtil.waitForElementToLoad(timeOut, LoginPage.LP_INPUT_PASSCODE);
		seleniumUtil.waitForElementToLoad(timeOut, LoginPage.LP_BUTTON_LOGIN);
		seleniumUtil.waitForElementToLoad(timeOut, LoginPage.LP_LABEL_AUTO);

	}

	// 检查用户名确认登录成功
	public void verifyUserInfo(int timeOut, int sleepTime) {
		seleniumUtil.pause(sleepTime);
		seleniumUtil.waitForElementToLoad(timeOut, HomePage.HP_TEXT_USERINFO);
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(HomePage.HP_TEXT_USERINFO).getText(), "incito | 退出");
	}

	// 验证 每个tab 是否能点击进入
	public void verifyAllTab(int timeOut) {
		// 首页
		seleniumUtil.waitForElementToLoad(timeOut, HomePage.HP_LINK_HOME);
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(HomePage.HP_LINK_HOME).getText(), "首页");
		seleniumUtil.waitForElementToLoad(timeOut, HomePage.HP_TITLE_PUBLICCARS);
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(HomePage.HP_TITLE_PUBLICCARS).getText(), "公共车源" + "\n" + "更多>>");
		seleniumUtil.waitForElementToLoad(timeOut, HomePage.HP_TITLE_PUBLICGOODS);
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(HomePage.HP_TITLE_PUBLICGOODS).getText(), "公共货源" + "\n" + "更多>>");

		// 个人中心
		// seleniumUtil.waitForElementToLoad(timeOut,
		// HomePage.HP_LINK_PERSONCEN);
		// seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(HomePage.HP_LINK_PERSONCEN).getText(),
		// "个人中心");
		// seleniumUtil.click(seleniumUtil.findElementBy(HomePage.HP_LINK_PERSONCEN));
		// PersonCenterPageHelper.waitPCPageToLoad(timeOut,seleniumUtil);
		// seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(PersonCenterPage.PCP_TEXT_BODY).getText(),
		// "建设中...");

		// 找车源
		seleniumUtil.click(seleniumUtil.findElementBy(HomePage.HP_TAB_FINDCARS));
		FindCarsPagerHelper.waitFCPageToLoad(timeOut, seleniumUtil);
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(FindCarsPage.FCP_BUTTON_SEARCH).getText(), " 搜索");

		// 找货源

	}

}
