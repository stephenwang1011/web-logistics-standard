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
import com.incito.logistics.util.PropertiesDataProvider;

/**
 * @author xy-incito-wk
 * @Description 已认证用户页面上的UI检查
 *
 * */
public class UserAttestedInfoPage_301_AttestReject_UI_Test extends BaseParpare {
	@Test
	public void userAttestedInfoPageAttestRejectUITest(ITestContext context) {
		String configFilePath = String.valueOf(context.getCurrentXmlTest().getParameter("userInfoPath"));
		int timeOut = Integer.valueOf(context.getCurrentXmlTest().getParameter("timeOut"));
		String attestedUserName3 = PropertiesDataProvider.getTestData(configFilePath, "attestedUserName3");
		String attestedPassWord3 = PropertiesDataProvider.getTestData(configFilePath, "attestedPassWord3");
		int sleepTime = Integer.valueOf(context.getCurrentXmlTest().getParameter("sleepTime"));

		HomePageHelper.waitHomePageToLoad(timeOut, seleniumUtil);
		HomePageHelper.enterPage(seleniumUtil, HomePage.HP_BUTTON_LOGIN);
		LoginPageHelper.login(seleniumUtil, attestedUserName3, attestedPassWord3);
		HomePageHelper.holdOn(seleniumUtil, sleepTime);
		HomePageHelper.enterPage(seleniumUtil, HomePage.HP_LINK_NOAUTH);
		UserAttestedInfoPagerHelper.enterPage(seleniumUtil, UserAttestedInfoPage.UAIP_USERINFO_TAB);

		String selected = seleniumUtil.findElementBy(UserAttestedInfoPage.UAIP_USERINFO_TAB).getAttribute("class");
		try {
			Assert.assertTrue(selected.equals("aForLink active"));// 判断认证信息标签是否已经被选中
		} catch (Exception e) {
			Assert.fail("在完成个人信息页面中‘认证信息’没有被选中。");
			e.printStackTrace();
			throw e;
		}

		UserAttestedInfoPagerHelper.checkUserAttestRejectInfoPageText(seleniumUtil);
		// 点击修改按钮进入修改界面检查界面
		UserAttestedInfoPagerHelper.enterPage(seleniumUtil, UserAttestedInfoPage.UAIP_BUTTON_MODIFY);
		selected = seleniumUtil.findElementBy(UserAttestedInfoPage.UAIP_USERINFO_TAB).getAttribute("class");
		try {
			Assert.assertTrue(selected.equals("aForLink active"));// 判断认证信息标签是否已经被选中
		} catch (Exception e) {
			Assert.fail("在完成个人信息页面中‘认证信息’没有被选中。");
			e.printStackTrace();
			throw e;
		}
		UserAttestedInfoPagerHelper.checkUserAttestRejectInfoPageTextModify(seleniumUtil);
		FooterPageHelper.checkFooterPageText(seleniumUtil);
	}
}
