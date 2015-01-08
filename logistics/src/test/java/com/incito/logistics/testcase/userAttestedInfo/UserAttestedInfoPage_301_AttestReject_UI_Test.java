package com.incito.logistics.testcase.userAttestedInfo;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.UserAttestedInfoPage;
import com.incito.logistics.pages.pageshelper.FooterPageHelper;
import com.incito.logistics.pages.pageshelper.UserAttestedInfoPagerHelper;
import com.incito.logistics.plugins.father.UserAttestedInfoAttestRejectFather;

/**
 * @author xy-incito-wk
 * @Description 已认证用户页面上的UI检查
 *
 * */
public class UserAttestedInfoPage_301_AttestReject_UI_Test extends UserAttestedInfoAttestRejectFather {
	@Test
	public void UserAttestingInfoPageAttestedUITest(ITestContext context) {
		UserAttestedInfoAttestRejectFather.userAtestRejectInfoParpare(context, seleniumUtil);

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
