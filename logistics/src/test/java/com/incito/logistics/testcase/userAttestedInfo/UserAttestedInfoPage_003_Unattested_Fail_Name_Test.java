package com.incito.logistics.testcase.userAttestedInfo;

import java.util.Map;

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
public class UserAttestedInfoPage_003_Unattested_Fail_Name_Test extends UserAttestedInfoFather {
	@Test(dataProvider = "data")
	public void addUserInfoPageFailName(ITestContext context, Map<String, String> data) {
		UserAttestedInfoFather.userUnatestedInfoParpare(context, seleniumUtil);
		
		seleniumUtil.type(seleniumUtil.findElementBy(UserAttestedInfoPage.UAIP_INPUT_NAME), data.get("ADD_NAME"));
		UserAttestedInfoPagerHelper.enterPage(seleniumUtil, UserAttestedInfoPage.UAIP_BUTTON_SUBMIT);
		UserAttestedInfoPagerHelper.checkUserAuthenticationInfoPrompt(timeOut, seleniumUtil);
	}
}
