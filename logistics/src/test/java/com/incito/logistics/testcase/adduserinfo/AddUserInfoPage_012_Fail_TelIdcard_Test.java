package com.incito.logistics.testcase.adduserinfo;

import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.AddUserInfoPage;
import com.incito.logistics.pages.pageshelper.AddUserInfoPagerHelper;
import com.incito.logistics.plugins.father.AddUserInfoFather;

/**
 * @author xy-incito-wk
 * @Description 填写信息联系方式和公司名称提交
 *
 * */
public class AddUserInfoPage_012_Fail_TelIdcard_Test extends AddUserInfoFather {
	@Test(dataProvider = "data")
	public void addUserInfoPageFailTelIdcard(ITestContext context, Map<String, String> data) {
		AddUserInfoFather.AddUserInfoParpare(context, seleniumUtil);

		seleniumUtil.type(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_TEL), data.get("ADD_TEL"));		
		seleniumUtil.type(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_IDCARD), data.get("ADD_IDCARD"));
		AddUserInfoPagerHelper.enterPage(seleniumUtil, AddUserInfoPage.AUIP_BUTTON_SUBMIT);
		AddUserInfoPagerHelper.checkAddUserInfoPrompt(timeOut, seleniumUtil);
	}
}
