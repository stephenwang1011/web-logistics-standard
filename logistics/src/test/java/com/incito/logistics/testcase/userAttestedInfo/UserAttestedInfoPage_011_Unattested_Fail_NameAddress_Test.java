package com.incito.logistics.testcase.userAttestedInfo;

import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.UserAttestedInfoPage;
import com.incito.logistics.pages.pageshelper.UserAttestedInfoPagerHelper;
import com.incito.logistics.plugins.father.UserAttestedInfoFather;

/**
 * @author xy-incito-wk
 * @Description 填写信息姓名和公司地址为空提交
 *
 * */
public class UserAttestedInfoPage_011_Unattested_Fail_NameAddress_Test extends UserAttestedInfoFather {
	@Test(dataProvider = "data")
	public void addUserInfoPageFailNameAddress(ITestContext context, Map<String, String> data) {
		UserAttestedInfoFather.userUnatestedInfoParpare(context, seleniumUtil);
		seleniumUtil.type(seleniumUtil.findElementBy(UserAttestedInfoPage.UAIP_INPUT_NAME), data.get("ADD_NAME"));
		seleniumUtil.address(UserAttestedInfoPage.UAIP_SELECT_PROVINCE, data.get("ADD_PROVINCE"), UserAttestedInfoPage.UAIP_SELECT_CITY, data.get("ADD_CITY"), UserAttestedInfoPage.UAIP_SELECT_REGION, data.get("ADD_REGION"), UserAttestedInfoPage.UAIP_INPUT_ADDRESS, data.get("ADD_ADDRESS"));
		UserAttestedInfoPagerHelper.enterPage(seleniumUtil, UserAttestedInfoPage.UAIP_BUTTON_SUBMIT);
		UserAttestedInfoPagerHelper.checkUserAuthenticationInfoPrompt(timeOut, seleniumUtil);
	}
}
