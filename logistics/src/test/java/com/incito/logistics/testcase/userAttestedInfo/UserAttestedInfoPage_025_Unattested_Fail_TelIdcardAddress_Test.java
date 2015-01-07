package com.incito.logistics.testcase.userAttestedInfo;

import java.util.Map;

import org.openqa.selenium.By;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.UserAttestedInfoPage;
import com.incito.logistics.pages.pageshelper.UserAttestedInfoPagerHelper;
import com.incito.logistics.plugins.father.UserAttestedInfoFather;

/**
 * @author xy-incito-wk
 * @Description 填写联系方式，身份证号，公司地址点击提交
 *
 * */
public class UserAttestedInfoPage_025_Unattested_Fail_TelIdcardAddress_Test extends UserAttestedInfoFather {
	@Test(dataProvider = "data")
	public void addUserInfoPageFailTelIdcardAddress(ITestContext context, Map<String, String> data) {
		UserAttestedInfoFather.userUnatestedInfoParpare(context, seleniumUtil);

		By[] bys={UserAttestedInfoPage.UAIP_INPUT_TEL, UserAttestedInfoPage.UAIP_INPUT_PHOTO,
				UserAttestedInfoPage.UAIP_INPUT_CHIT, UserAttestedInfoPage.UAIP_BUTTON_CHIT };
		UserAttestedInfoPagerHelper.typeTelChit(seleniumUtil, bys, data.get("ADD_TEL"), 
				data.get("ADD_PHOTO"), data.get("ADD_CHIT"));
		seleniumUtil.type(seleniumUtil.findElementBy(UserAttestedInfoPage.UAIP_INPUT_IDCARD), data.get("ADD_IDCARD"));
		seleniumUtil.address(UserAttestedInfoPage.UAIP_SELECT_PROVINCE, data.get("ADD_PROVINCE"), UserAttestedInfoPage.UAIP_SELECT_CITY, data.get("ADD_CITY"), UserAttestedInfoPage.UAIP_SELECT_REGION, data.get("ADD_REGION"), UserAttestedInfoPage.UAIP_INPUT_ADDRESS, data.get("ADD_ADDRESS"));
		UserAttestedInfoPagerHelper.enterPage(seleniumUtil, UserAttestedInfoPage.UAIP_BUTTON_SUBMIT);
		UserAttestedInfoPagerHelper.checkUserAuthenticationInfoPrompt(timeOut, seleniumUtil);
	}
}
