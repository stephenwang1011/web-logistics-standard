package com.incito.logistics.testcase.userAttestedInfo;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.UserAttestedInfoPage;
import com.incito.logistics.pages.pageshelper.UserAttestedInfoPagerHelper;
import com.incito.logistics.plugins.father.UserAttestedInfoFather;

/**
 * @author xy-incito-wk
 * @Description 填写信息全为空直接提交
 *
 * */
public class UserAttestedInfoPage_002_Unattested_Fail_All_Test extends UserAttestedInfoFather {
	@Test
	public void addUserInfoPageFailAllTest(ITestContext context) {
		UserAttestedInfoFather.userUnatestedInfoParpare(context, seleniumUtil);
		UserAttestedInfoPagerHelper.enterPage(seleniumUtil, UserAttestedInfoPage.UAIP_BUTTON_SUBMIT);
		UserAttestedInfoPagerHelper.checkUserAuthenticationInfoPrompt(timeOut, seleniumUtil);
	}
}
