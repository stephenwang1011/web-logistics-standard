package com.incito.logistics.testcase.userBaseInfo;

import java.util.Map;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.AddUserInfoPage;
import com.incito.logistics.pages.UserBaseInfoPage;
import com.incito.logistics.pages.pageshelper.AddUserInfoPagerHelper;
import com.incito.logistics.pages.pageshelper.FooterPageHelper;
import com.incito.logistics.plugins.father.UserBaseInfoFather;

/**
 * @author xy-incito-wk
 * @Description 填写电话，身份证号，公司名称，公司地址点击提交
 *
 * */
public class UserBaseInfoPage_001_UICheck_Test extends UserBaseInfoFather {
	@Test
	public void addUserInfoPageFailTelIdcardCompanyAddress(ITestContext context) {
		UserBaseInfoFather.userBaseInfoParpare(context, seleniumUtil);

		String userName=seleniumUtil.findElementBy(UserBaseInfoPage.BUIP_TEXT_NAME).getText();
		System.out.println("-----------");
		System.out.println(userName);
		seleniumUtil.findElementBy(UserBaseInfoPage.BUIP_TEXT_NAME_R).getText();
/*		try {
			Assert.assertTrue(selected.equals("active"));//判断认证信息标签是否已经被选中
		} catch (Exception e) {
			Assert.fail("在完成个人信息页面中‘认证信息’没有被选中。");
			e.printStackTrace();
			throw e;
		}*/
		
		
//		seleniumUtil.type(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_TEL), data.get("ADD_TEL"));
//		seleniumUtil.type(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_IDCARD), data.get("ADD_IDCARD"));
//		seleniumUtil.type(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_COMPANY), data.get("ADD_COMPANY"));
//		seleniumUtil.address(AddUserInfoPage.AUIP_SELECT_PROVINCE, data.get("ADD_PROVINCE"), AddUserInfoPage.AUIP_SELECT_CITY, data.get("ADD_CITY"), AddUserInfoPage.AUIP_SELECT_REGION, data.get("ADD_REGION"), AddUserInfoPage.AUIP_INPUT_ADDRESS, data.get("ADD_ADDRESS"));
//		AddUserInfoPagerHelper.enterPage(seleniumUtil, AddUserInfoPage.AUIP_BUTTON_SUBMIT);
//		AddUserInfoPagerHelper.checkAddUserInfoPrompt(timeOut, seleniumUtil);
		
		
//		FooterPageHelper.checkFooterPageText(seleniumUtil);
	}
}