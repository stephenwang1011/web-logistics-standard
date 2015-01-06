package com.incito.logistics.testcase.userAuthenticationInfo;

import java.util.Map;

import org.openqa.selenium.By;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.UserAuthenticationInfoPage;
import com.incito.logistics.pages.pageshelper.UserAuthenticationInfoPagerHelper;
import com.incito.logistics.plugins.father.UserAttestedInfoFather;

/**
 * @author xy-incito-wk
 * @Description 填写姓名，电话，身份证号，公司名称点击提交
 *
 * */
public class UserAuthenticationInfoPage_028_Unauthenticated_Fail_NameTelIdcardCompany_Test extends UserAttestedInfoFather {
	@Test(dataProvider = "data")
	public void addUserInfoPageFailNameTelIdcardCompany(ITestContext context, Map<String, String> data) {
		UserAttestedInfoFather.userUnatestedInfoParpare(context, seleniumUtil);
		
		seleniumUtil.type(seleniumUtil.findElementBy(UserAuthenticationInfoPage.AUIP_INPUT_NAME), data.get("ADD_NAME"));
		By[] bys={UserAuthenticationInfoPage.AUIP_INPUT_TEL, UserAuthenticationInfoPage.AUIP_INPUT_PHOTO,
				UserAuthenticationInfoPage.AUIP_INPUT_CHIT, UserAuthenticationInfoPage.AUIP_BUTTON_CHIT };
		UserAuthenticationInfoPagerHelper.typeTelChit(seleniumUtil, bys, data.get("ADD_TEL"), 
				data.get("ADD_PHOTO"), data.get("ADD_CHIT"));
		seleniumUtil.type(seleniumUtil.findElementBy(UserAuthenticationInfoPage.AUIP_INPUT_IDCARD), data.get("ADD_IDCARD"));
		seleniumUtil.type(seleniumUtil.findElementBy(UserAuthenticationInfoPage.AUIP_INPUT_COMPANY), data.get("ADD_COMPANY"));
		UserAuthenticationInfoPagerHelper.enterPage(seleniumUtil, UserAuthenticationInfoPage.AUIP_BUTTON_SUBMIT);
		UserAuthenticationInfoPagerHelper.checkUserAuthenticationInfoPrompt(timeOut, seleniumUtil);
	}
}