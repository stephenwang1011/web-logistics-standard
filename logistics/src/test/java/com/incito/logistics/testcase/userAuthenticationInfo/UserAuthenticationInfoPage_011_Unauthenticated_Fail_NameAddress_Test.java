package com.incito.logistics.testcase.userAuthenticationInfo;

import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.UserAuthenticationInfoPage;
import com.incito.logistics.pages.pageshelper.UserAuthenticationInfoPagerHelper;
import com.incito.logistics.plugins.father.UserAttestedInfoFather;

/**
 * @author xy-incito-wk
 * @Description 填写信息姓名和公司地址为空提交
 *
 * */
public class UserAuthenticationInfoPage_011_Unauthenticated_Fail_NameAddress_Test extends UserAttestedInfoFather {
	@Test(dataProvider = "data")
	public void addUserInfoPageFailNameAddress(ITestContext context, Map<String, String> data) {
		UserAttestedInfoFather.userUnatestedInfoParpare(context, seleniumUtil);
		seleniumUtil.type(seleniumUtil.findElementBy(UserAuthenticationInfoPage.AUIP_INPUT_NAME), data.get("ADD_NAME"));
		seleniumUtil.address(UserAuthenticationInfoPage.AUIP_SELECT_PROVINCE, data.get("ADD_PROVINCE"), UserAuthenticationInfoPage.AUIP_SELECT_CITY, data.get("ADD_CITY"), UserAuthenticationInfoPage.AUIP_SELECT_REGION, data.get("ADD_REGION"), UserAuthenticationInfoPage.AUIP_INPUT_ADDRESS, data.get("ADD_ADDRESS"));
		UserAuthenticationInfoPagerHelper.enterPage(seleniumUtil, UserAuthenticationInfoPage.AUIP_BUTTON_SUBMIT);
		UserAuthenticationInfoPagerHelper.checkUserAuthenticationInfoPrompt(timeOut, seleniumUtil);
	}
}
