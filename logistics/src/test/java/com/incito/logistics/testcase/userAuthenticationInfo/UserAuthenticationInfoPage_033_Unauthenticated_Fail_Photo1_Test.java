package com.incito.logistics.testcase.userAuthenticationInfo;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.UserAuthenticationInfoPage;
import com.incito.logistics.pages.pageshelper.UserAuthenticationInfoPagerHelper;
import com.incito.logistics.plugins.father.UserAttestedInfoFather;

/**
 * @author xy-incito-wk
 * @Description 填写信息全为空直接提交
 *
 * */
public class UserAuthenticationInfoPage_033_Unauthenticated_Fail_Photo1_Test extends UserAttestedInfoFather {
	@Test
	public void addUserInfoPageFailAllTest(ITestContext context) {
		UserAttestedInfoFather.userUnatestedInfoParpare(context, seleniumUtil);
		
		UserAuthenticationInfoPagerHelper.upLoadPhoto(seleniumUtil, UserAuthenticationInfoPage.AUIP_INPUT_UPLOAD, 1);
		seleniumUtil.pause(5000);
		UserAuthenticationInfoPagerHelper.enterPage(seleniumUtil, UserAuthenticationInfoPage.AUIP_BUTTON_SUBMIT);
		UserAuthenticationInfoPagerHelper.checkUserAuthenticationInfoPrompt(timeOut, seleniumUtil);
	}
}
