package com.incito.logistics.testcase.userAttestedInfo;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.base.BaseParpare;
import com.incito.logistics.pages.HomePage;
import com.incito.logistics.pages.UserAttestedInfoPage;
import com.incito.logistics.pages.pageshelper.FooterPageHelper;
import com.incito.logistics.pages.pageshelper.HomePageHelper;
import com.incito.logistics.pages.pageshelper.LoginPageHelper;
import com.incito.logistics.pages.pageshelper.UserAttestedInfoPagerHelper;
import com.incito.logistics.pages.pageshelper.UserBaseInfoPagerHelper;
import com.incito.logistics.util.PropertiesDataProvider;

/**
 * @author xy-incito-wy
 * @Description 认证信息界面，认证审核用户，认证页面上的UI检查
 *
 * */
public class UserAttestingInfoPage_101_Attesting_UI_Test extends BaseParpare {
	@Test
	public void UserAttestingInfoPageAttestingUITest(ITestContext context) {
		String configFilePath = String.valueOf(context.getCurrentXmlTest().getParameter("userInfoPath"));
		int timeOut = Integer.valueOf(context.getCurrentXmlTest().getParameter("timeOut"));
		String attestingUserName = PropertiesDataProvider.getTestData(configFilePath, "attesting_username");
		String attestingPassword = PropertiesDataProvider.getTestData(configFilePath, "attesting_password");
		int sleepTime = Integer.valueOf(context.getCurrentXmlTest().getParameter("sleepTime"));

		HomePageHelper.waitHomePageToLoad(timeOut, seleniumUtil);
		HomePageHelper.enterPage(seleniumUtil, HomePage.HP_BUTTON_LOGIN);
		LoginPageHelper.login(seleniumUtil, attestingUserName, attestingPassword);
		HomePageHelper.holdOn(seleniumUtil, sleepTime);
		HomePageHelper.enterPage(seleniumUtil, HomePage.HP_LINK_NOAUTHOR);
		UserBaseInfoPagerHelper.enterPage(seleniumUtil, UserAttestedInfoPage.UAIP_USERINFO_TAB);
		String selected = seleniumUtil.findElementBy(UserAttestedInfoPage.UAIP_USERINFO_TAB).getAttribute("class");
		try {
			Assert.assertTrue(selected.equals("aForLink active"));// 判断认证信息标签是否已经被选中
		} catch (Exception e) {
			Assert.fail("在完成个人信息页面中‘认证信息’没有被选中。");
			e.printStackTrace();
			throw e;
		}
		
		UserAttestedInfoPagerHelper.checkUserAttestingInfoPageText(seleniumUtil);
		FooterPageHelper.checkFooterPageText(seleniumUtil);
	}
}
