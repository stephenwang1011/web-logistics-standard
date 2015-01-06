package com.incito.logistics.testcase.userAuthenticationInfo;

import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.AddUserInfoPage;
import com.incito.logistics.pages.pageshelper.UserAuthenticationInfoPagerHelper;
import com.incito.logistics.plugins.father.UserAuthenticationInfoFather;

/**
 * @author xy-incito-wk
 * @Description 填写姓名，身份证号，公司名称点击提交
 *
 * */
public class UserAuthenticationInfoPage_021_Unauthenticated_Fail_NameIdcardCompany_Test extends UserAuthenticationInfoFather {
	@Test(dataProvider = "data")
	public void addUserInfoPageFailNameIdcardCompany(ITestContext context, Map<String, String> data) {
		UserAuthenticationInfoFather.userAuthenticationInfoParpare(context, seleniumUtil);
		
		seleniumUtil.type(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_NAME), data.get("ADD_NAME"));
		seleniumUtil.type(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_IDCARD), data.get("ADD_IDCARD"));
		seleniumUtil.type(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_COMPANY), data.get("ADD_COMPANY"));
		UserAuthenticationInfoPagerHelper.enterPage(seleniumUtil, AddUserInfoPage.AUIP_BUTTON_SUBMIT);
		UserAuthenticationInfoPagerHelper.checkUserAuthenticationInfoPrompt(timeOut, seleniumUtil);
	}
}