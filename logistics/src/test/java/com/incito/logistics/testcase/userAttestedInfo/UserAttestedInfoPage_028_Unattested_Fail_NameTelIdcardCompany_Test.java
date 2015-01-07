package com.incito.logistics.testcase.userAttestedInfo;

import java.util.Map;

import org.openqa.selenium.By;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.UserAttestedInfoPage;
import com.incito.logistics.pages.pageshelper.UserAttestedInfoPagerHelper;
import com.incito.logistics.plugins.father.UserAttestedInfoUnattestedFather;

/**
 * @author xy-incito-wk
 * @Description 认证信息界面，未认证用户，填写姓名，电话，身份证号，公司名称点击提交
 *
 * */
public class UserAttestedInfoPage_028_Unattested_Fail_NameTelIdcardCompany_Test extends UserAttestedInfoUnattestedFather {
	@Test(dataProvider = "data")
	public void UserAttestedInfoPageUnattestedFailNameTelIdcardCompanyTest(ITestContext context, Map<String, String> data) {
		UserAttestedInfoUnattestedFather.userUnatestedInfoParpare(context, seleniumUtil);
		
		seleniumUtil.type(seleniumUtil.findElementBy(UserAttestedInfoPage.UAIP_INPUT_NAME), data.get("ADD_NAME"));
		By[] bys={UserAttestedInfoPage.UAIP_INPUT_TEL, UserAttestedInfoPage.UAIP_INPUT_PHOTO,
				UserAttestedInfoPage.UAIP_INPUT_CHIT, UserAttestedInfoPage.UAIP_BUTTON_CHIT };
		UserAttestedInfoPagerHelper.typeTelChit(seleniumUtil, bys, data.get("ADD_TEL"), 
				data.get("ADD_PHOTO"), data.get("ADD_CHIT"));
		seleniumUtil.type(seleniumUtil.findElementBy(UserAttestedInfoPage.UAIP_INPUT_IDCARD), data.get("ADD_IDCARD"));
		seleniumUtil.type(seleniumUtil.findElementBy(UserAttestedInfoPage.UAIP_INPUT_COMPANY), data.get("ADD_COMPANY"));
		UserAttestedInfoPagerHelper.enterPage(seleniumUtil, UserAttestedInfoPage.UAIP_BUTTON_SUBMIT);
		UserAttestedInfoPagerHelper.checkUserAuthenticationInfoPrompt(timeOut, seleniumUtil);
	}
}