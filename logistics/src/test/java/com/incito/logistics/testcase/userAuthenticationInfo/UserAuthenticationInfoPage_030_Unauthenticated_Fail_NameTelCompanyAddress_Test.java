package com.incito.logistics.testcase.userAuthenticationInfo;

import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.AddUserInfoPage;
import com.incito.logistics.pages.pageshelper.UserAuthenticationInfoPagerHelper;
import com.incito.logistics.plugins.father.UserAuthenticationInfoFather;

/**
 * @author xy-incito-wk
 * @Description 填写姓名，电话，公司名称，公司地址点击提交
 *
 * */
public class UserAuthenticationInfoPage_030_Unauthenticated_Fail_NameTelCompanyAddress_Test extends UserAuthenticationInfoFather {
	@Test(dataProvider = "data")
	public void addUserInfoPageFailNameTelCompanyAddress(ITestContext context, Map<String, String> data) {
		UserAuthenticationInfoFather.userAuthenticationInfoParpare(context, seleniumUtil);

		seleniumUtil.type(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_NAME), data.get("ADD_NAME"));
		seleniumUtil.type(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_TEL), data.get("ADD_TEL"));
		seleniumUtil.type(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_COMPANY), data.get("ADD_COMPANY"));
		seleniumUtil.address(AddUserInfoPage.AUIP_SELECT_PROVINCE, data.get("ADD_PROVINCE"), AddUserInfoPage.AUIP_SELECT_CITY, data.get("ADD_CITY"), AddUserInfoPage.AUIP_SELECT_REGION, data.get("ADD_REGION"), AddUserInfoPage.AUIP_INPUT_ADDRESS, data.get("ADD_ADDRESS"));
		UserAuthenticationInfoPagerHelper.enterPage(seleniumUtil, AddUserInfoPage.AUIP_BUTTON_SUBMIT);
		UserAuthenticationInfoPagerHelper.checkUserAuthenticationInfoPrompt(timeOut, seleniumUtil);
	}
}
