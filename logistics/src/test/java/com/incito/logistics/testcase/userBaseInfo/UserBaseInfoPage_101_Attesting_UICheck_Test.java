package com.incito.logistics.testcase.userBaseInfo;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.UserBaseInfoPage;
import com.incito.logistics.pages.pageshelper.FooterPageHelper;
import com.incito.logistics.pages.pageshelper.UserBaseInfoPagerHelper;
import com.incito.logistics.plugins.father.UserBaseInfoAttestingFather;

/**
 * @author xy-incito-wk
 * @Description 认证中的用户，进入我的资料-基本信息模块，检查UI信息（包括修改页面和未修改页面）
 *
 * */
public class UserBaseInfoPage_101_Attesting_UICheck_Test extends UserBaseInfoAttestingFather {
	@Test
	public void checkBasicInfoForAttestingUser(ITestContext context) {
		UserBaseInfoAttestingFather.userBaseInfoParpare(context, seleniumUtil, false);
	
		try {// 判断基本信息中用户名和右上角的用户名是否相等
			Assert.assertTrue(seleniumUtil.findElementBy(UserBaseInfoPage.BUIP_TEXT_NAME).getText().equals(seleniumUtil.findElementBy(UserBaseInfoPage.BUIP_TEXT_NAME_R).getText()));
		} catch (Exception e) {
			Assert.fail("在基本信息页面中两个用户名不相等");
			e.printStackTrace();
			throw e;
		}
		UserBaseInfoPagerHelper.checkUserInfoPageText(timeOut, seleniumUtil);
		FooterPageHelper.checkFooterPageText(seleniumUtil);
		UserBaseInfoPagerHelper.enterPage(seleniumUtil, UserBaseInfoPage.BUIP_BUTTON_REVISE);
		seleniumUtil.waitForElementToLoad(timeOut, UserBaseInfoPage.UBIP_TITLE_USERINFO);
		
		try {// 判断基本信息中用户名和右上角的用户名是否相等
			Assert.assertTrue(seleniumUtil.findElementBy(UserBaseInfoPage.BUIP_TEXT_NAME_REVISE).getText().trim().equals(seleniumUtil.findElementBy(UserBaseInfoPage.BUIP_TEXT_NAME_R).getText().trim()));
		} catch (Exception e) {
			Assert.fail("在基本信息的修改页面中两个用户名不相等");
			e.printStackTrace();
			throw e;
		}
		UserBaseInfoPagerHelper.checkUserInfoPageText(timeOut, seleniumUtil);
		FooterPageHelper.checkFooterPageText(seleniumUtil);

	}
}