package com.incito.logistics.testcase.adduserinfo;

import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.AddUserInfoPage;
import com.incito.logistics.pages.pageshelper.AddUserInfoPagerHelper;
import com.incito.logistics.plugins.father.AddUserInfoFather;

/**
 * @author xy-incito-wk
 * @Description 填写信息联系方式和公司地址提交
 *
 * */
public class AddUserInfoPage_017_Fail_CompanyAddress_Test extends AddUserInfoFather {
	@Test(dataProvider = "data")
	public void addUserInfoPageFailCompanyAddress(ITestContext context, Map<String, String> data) {
		AddUserInfoFather.AddUserInfoParpare(context, seleniumUtil);
		seleniumUtil.type(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_TEL), data.get("ADD_COMPANY"));
		seleniumUtil.address(AddUserInfoPage.AUIP_SELECT_PROVINCE, data.get("ADD_PROVINCE"), AddUserInfoPage.AUIP_SELECT_CITY, data.get("ADD_CITY"), AddUserInfoPage.AUIP_SELECT_REGION, data.get("ADD_REGION"), AddUserInfoPage.AUIP_INPUT_ADDRESS, data.get("ADD_ADDRESS"));
		AddUserInfoPagerHelper.enterPage(seleniumUtil, AddUserInfoPage.AUIP_BUTTON_SUBMIT);
		AddUserInfoPagerHelper.checkAddUserInfoPrompt(timeOut, seleniumUtil);
	}
}