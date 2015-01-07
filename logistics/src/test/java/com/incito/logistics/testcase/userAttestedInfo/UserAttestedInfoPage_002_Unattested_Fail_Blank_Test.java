package com.incito.logistics.testcase.userAttestedInfo;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.UserAttestedInfoPage;
import com.incito.logistics.pages.pageshelper.UserAttestedInfoPagerHelper;
import com.incito.logistics.plugins.father.UserAttestedInfoUnattestedFather;

/**
 * @author xy-incito-wk
 * @Description 认证信息界面填写信息全为空直接提交
 *
 * */
public class UserAttestedInfoPage_002_Unattested_Fail_Blank_Test extends UserAttestedInfoUnattestedFather {
	@Test
	public void UserAttestedInfoPageUnattestedBlankTest(ITestContext context) {
		UserAttestedInfoUnattestedFather.userUnatestedInfoParpare(context, seleniumUtil);
		UserAttestedInfoPagerHelper.enterPage(seleniumUtil, UserAttestedInfoPage.UAIP_BUTTON_SUBMIT);
		UserAttestedInfoPagerHelper.checkUserAuthenticationInfoPrompt(timeOut, seleniumUtil);
	}
}
