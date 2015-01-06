package com.incito.logistics.testcase.userAuthenticationInfo;

import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.AddUserInfoPage;
import com.incito.logistics.pages.pageshelper.UserAuthenticationInfoPagerHelper;
import com.incito.logistics.plugins.father.UserAuthenticationInfoFather;

/**
 * @author xy-incito-wk
 * @Description 填写联系方式，身份证号，公司地址点击提交
 *
 * */
public class UserAuthenticationInfoPage_025_Unauthenticated_Fail_TelIdcardAddress_Test extends UserAuthenticationInfoFather {
	@Test(dataProvider = "data")
	public void addUserInfoPageFailTelIdcardAddress(ITestContext context, Map<String, String> data) {
		UserAuthenticationInfoFather.userAuthenticationInfoParpare(context, seleniumUtil);

		seleniumUtil.type(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_TEL), data.get("ADD_TEL"));
		seleniumUtil.type(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_IDCARD), data.get("ADD_IDCARD"));
		seleniumUtil.address(AddUserInfoPage.AUIP_SELECT_PROVINCE, data.get("ADD_PROVINCE"), AddUserInfoPage.AUIP_SELECT_CITY, data.get("ADD_CITY"), AddUserInfoPage.AUIP_SELECT_REGION, data.get("ADD_REGION"), AddUserInfoPage.AUIP_INPUT_ADDRESS, data.get("ADD_ADDRESS"));
		UserAuthenticationInfoPagerHelper.enterPage(seleniumUtil, AddUserInfoPage.AUIP_BUTTON_SUBMIT);
		UserAuthenticationInfoPagerHelper.checkUserAuthenticationInfoPrompt(timeOut, seleniumUtil);
	}
}
