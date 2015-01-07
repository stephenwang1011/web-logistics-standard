package com.incito.logistics.testcase.userAttestedInfo;

import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.UserAttestedInfoPage;
import com.incito.logistics.pages.pageshelper.UserAttestedInfoPagerHelper;
import com.incito.logistics.plugins.father.UserAttestedInfoUnattestedFather;

/**
 * @author xy-incito-wk
 * @Description 认证信息界面，未认证用户，填写信息身份证号提交
 *
 * */
public class UserAttestedInfoPage_005_Unattested_Fail_Idcard_Test extends UserAttestedInfoUnattestedFather {
	@Test(dataProvider = "data")
	public void UserAttestedInfoPageUnattestedFailIdcardTest(ITestContext context, Map<String, String> data) {
		UserAttestedInfoUnattestedFather.userUnatestedInfoParpare(context, seleniumUtil);
		seleniumUtil.type(seleniumUtil.findElementBy(UserAttestedInfoPage.UAIP_INPUT_IDCARD), data.get("ADD_IDCARD"));
		UserAttestedInfoPagerHelper.enterPage(seleniumUtil, UserAttestedInfoPage.UAIP_BUTTON_SUBMIT);
		UserAttestedInfoPagerHelper.checkUserAuthenticationInfoPrompt(timeOut, seleniumUtil);
	}
}
