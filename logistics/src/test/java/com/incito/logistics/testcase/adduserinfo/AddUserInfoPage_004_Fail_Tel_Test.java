package com.incito.logistics.testcase.adduserinfo;

import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.AddUserInfoPage;
import com.incito.logistics.pages.pageshelper.AddUserInfoPagerHelper;
import com.incito.logistics.plugins.father.AddUserInfoFather;

/**
 * @author xy-incito-wk
 * @Description 填写信息联系方式提交
 *
 * */
public class AddUserInfoPage_004_Fail_Tel_Test extends AddUserInfoFather {
	@Test(dataProvider = "data")
	public void addUserInfoPageFailTel(ITestContext context, Map<String, String> data) {
		AddUserInfoFather.AddUserInfoParpare(context, seleniumUtil);
		seleniumUtil.type(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_TEL), data.get("ADD_TEL"));
		AddUserInfoPagerHelper.enterPage(seleniumUtil, AddUserInfoPage.AUIP_BUTTON_SUBMIT);
		AddUserInfoPagerHelper.checkAddUserInfoPrompt(timeOut, seleniumUtil);
	}
}
