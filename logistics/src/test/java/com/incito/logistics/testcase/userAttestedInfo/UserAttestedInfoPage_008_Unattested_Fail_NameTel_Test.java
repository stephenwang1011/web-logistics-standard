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
 * @Description 填写信息姓名提交
 *
 * */
public class UserAttestedInfoPage_008_Unattested_Fail_NameTel_Test extends UserAttestedInfoFather {
	@Test(dataProvider = "data")
	public void addUserInfoPageFailNameTel(ITestContext context, Map<String, String> data) {
		UserAttestedInfoFather.userUnatestedInfoParpare(context, seleniumUtil);

		By[] bys={UserAttestedInfoPage.UAIP_INPUT_TEL, UserAttestedInfoPage.UAIP_INPUT_PHOTO,
				UserAttestedInfoPage.UAIP_INPUT_CHIT, UserAttestedInfoPage.UAIP_BUTTON_CHIT };
		UserAttestedInfoPagerHelper.typeTelChit(seleniumUtil, bys, data.get("ADD_TEL"), 
				data.get("ADD_PHOTO"), data.get("ADD_CHIT"));
		seleniumUtil.type(seleniumUtil.findElementBy(UserAttestedInfoPage.UAIP_INPUT_NAME), data.get("ADD_NAME"));

		UserAttestedInfoPagerHelper.enterPage(seleniumUtil, UserAttestedInfoPage.UAIP_BUTTON_SUBMIT);
		UserAttestedInfoPagerHelper.checkUserAuthenticationInfoPrompt(timeOut, seleniumUtil);
	}
}
