package com.incito.logistics.testcase.adduserinfo;

import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.AddUserInfoPage;
import com.incito.logistics.pages.pageshelper.AddUserInfoPagerHelper;
import com.incito.logistics.plugins.father.AddUserInfoFather;

/**
 * @author xy-incito-wk
 * @Description 填写信息身份证号和公司地址提交
 *
 * */
public class AddUserInfoPage_015_Fail_IdcardCompany_Test extends AddUserInfoFather {
	@Test(dataProvider = "data")
	public void addUserInfoPageFailIdcardCompany(ITestContext context, Map<String, String> data) {
		AddUserInfoFather.AddUserInfoParpare(context, seleniumUtil);
		seleniumUtil.type(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_IDCARD), data.get("ADD_IDCARD"));
		seleniumUtil.type(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_COMPANY), data.get("ADD_COMPANY"));
		AddUserInfoPagerHelper.enterPage(seleniumUtil, AddUserInfoPage.AUIP_BUTTON_SUBMIT);
		AddUserInfoPagerHelper.checkAddUserInfoPrompt(timeOut, seleniumUtil);
	}
}