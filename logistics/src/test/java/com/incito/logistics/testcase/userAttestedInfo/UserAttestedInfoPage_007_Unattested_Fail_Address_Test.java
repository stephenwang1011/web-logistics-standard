package com.incito.logistics.testcase.userAttestedInfo;

import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.UserAttestedInfoPage;
import com.incito.logistics.pages.pageshelper.UserAttestedInfoPagerHelper;
import com.incito.logistics.plugins.father.UserAttestedInfoUnattestedFather;

/**
 * @author xy-incito-wk
 * @Description 认证信息界面，未认证用户，填写信息公司地址直接提交
 *
 * */
public class UserAttestedInfoPage_007_Unattested_Fail_Address_Test extends UserAttestedInfoUnattestedFather {
	@Test(dataProvider = "data")
	public void UserAttestedInfoPageUnattestedFailAddressTest(ITestContext context, Map<String, String> data) {
		UserAttestedInfoUnattestedFather.userUnatestedInfoParpare(context, seleniumUtil);
		seleniumUtil.address(UserAttestedInfoPage.UAIP_SELECT_PROVINCE, data.get("ADD_PROVINCE"), UserAttestedInfoPage.UAIP_SELECT_CITY, data.get("ADD_CITY"), UserAttestedInfoPage.UAIP_SELECT_REGION, data.get("ADD_REGION"), UserAttestedInfoPage.UAIP_INPUT_ADDRESS, data.get("ADD_ADDRESS"));
		UserAttestedInfoPagerHelper.enterPage(seleniumUtil, UserAttestedInfoPage.UAIP_BUTTON_SUBMIT);
		UserAttestedInfoPagerHelper.checkUserAuthenticationInfoPrompt(timeOut, seleniumUtil);
	}
}
