package com.incito.logistics.testcase.adduserinfo;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.AddUserInfoPage;
import com.incito.logistics.pages.pageshelper.AddUserInfoPagerHelper;
import com.incito.logistics.plugins.father.AddUserInfoFather;

/**
 * @author xy-incito-wk
 * @Description 填写信息全为空直接提交
 *
 * */
public class AddUserInfoPage_002_Fail_All_Test extends AddUserInfoFather {
	@Test
	public void addUserInfoPageFailAllTest(ITestContext context) {
		AddUserInfoFather.AddUserInfoParpare(context, seleniumUtil);
		AddUserInfoPagerHelper.enterPage(seleniumUtil, AddUserInfoPage.AUIP_BUTTON_SUBMIT);
		AddUserInfoPagerHelper.checkAddUserInfoPrompt(timeOut, seleniumUtil);
	}
}
