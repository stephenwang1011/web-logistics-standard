package com.incito.logistics.testcase.userAttestedInfo;

import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.UserAttestedInfoPage;
import com.incito.logistics.pages.pageshelper.UserAttestedInfoPagerHelper;
import com.incito.logistics.plugins.father.UserAttestedInfoAttestedFather;

/**
 * @author xy-incito-wk
 * @Description 已认证用户页面上，填写修改地址
 *
 * */
public class UserAttestedInfoPage_204_Attested_Address_Test extends UserAttestedInfoAttestedFather {
	@Test(dataProvider = "data")
	public void UserAttestingInfoPageAttestedAddressTest(ITestContext context, Map<String, String> data) {
		UserAttestedInfoAttestedFather.userAtestedInfoParpare(context, seleniumUtil);

		UserAttestedInfoPagerHelper.enterPage(seleniumUtil, UserAttestedInfoPage.UAIP_BUTTON_MODIFY);
		//使其出现短信验证码
		seleniumUtil.clear(seleniumUtil.findElementBy(UserAttestedInfoPage.UAIP_INPUT_TEL));
		seleniumUtil.type(seleniumUtil.findElementBy(UserAttestedInfoPage.UAIP_INPUT_TEL), "15316225342");
		UserAttestedInfoPagerHelper.enterPage(seleniumUtil, UserAttestedInfoPage.UAIP_BUTTON_SAVE);
		seleniumUtil.clear(seleniumUtil.findElementBy(UserAttestedInfoPage.UAIP_INPUT_TEL));
		
		seleniumUtil.address(UserAttestedInfoPage.UAIP_SELECT_PROVINCE, data.get("ADD_PROVINCE"), UserAttestedInfoPage.UAIP_SELECT_CITY, data.get("ADD_CITY"), UserAttestedInfoPage.UAIP_SELECT_REGION, data.get("ADD_REGION"), UserAttestedInfoPage.UAIP_INPUT_ADDRESS, data.get("ADD_ADDRESS"));
		
		UserAttestedInfoPagerHelper.enterPage(seleniumUtil, UserAttestedInfoPage.UAIP_BUTTON_MODIFY);
		UserAttestedInfoPagerHelper.checkUserAttestedInfoPageModifyFail(seleniumUtil);
	}
}
