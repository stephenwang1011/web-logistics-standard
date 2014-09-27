package com.incito.logistics.testcase.adduserinfo;

import org.openqa.selenium.By;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.base.BaseParpare;
import com.incito.logistics.pages.AddUserInfoPage;
import com.incito.logistics.pages.HomePage;
import com.incito.logistics.pages.pageshelper.AddUserInfoPagerHelper;
import com.incito.logistics.pages.pageshelper.HomePageHelper;
import com.incito.logistics.pages.pageshelper.LoginPageHelper;
import com.incito.logistics.util.PropertiesDataProvider;

/**
 * @author xy-incito-wk
 * @Description 填写一个文本框点击提交
 *
 * */
public class AddUserInfoPage_33_Fail_OneInput_Test extends BaseParpare {
	@Test
	public void addUserInfoPageFailTelIdcardCompanyAddress(ITestContext context) {
		String configFilePath = String.valueOf(context.getCurrentXmlTest().getParameter("userInfoPath"));
		int timeOut = Integer.valueOf(context.getCurrentXmlTest().getParameter("timeOut"));
		String register_username = PropertiesDataProvider.getTestData(configFilePath, "register_username");
		String password = PropertiesDataProvider.getTestData(configFilePath, "password");
		// 输入框数组
		By[] bys = { AddUserInfoPage.AUIP_INPUT_NAME, AddUserInfoPage.AUIP_INPUT_TEL, AddUserInfoPage.AUIP_INPUT_IDCARD, AddUserInfoPage.AUIP_INPUT_COMPANY, AddUserInfoPage.AUIP_INPUT_ADDRESS };
		// 下拉列表：省、市、区
		By[] add_select = { AddUserInfoPage.AUIP_SELECT_PROVINCE, AddUserInfoPage.AUIP_SELECT_CITY, AddUserInfoPage.AUIP_SELECT_REGION };
		// 循环输入的文本框,最终使用数据使用
		String add_name = PropertiesDataProvider.getTestData(configFilePath, "add_name");
		String add_tel = PropertiesDataProvider.getTestData(configFilePath, "add_tel");
		String add_idcard = PropertiesDataProvider.getTestData(configFilePath, "add_idcard");
		String add_company = PropertiesDataProvider.getTestData(configFilePath, "add_company");
		String add_address = PropertiesDataProvider.getTestData(configFilePath, "add_address");
		String[] add_text = { add_name, add_tel, add_idcard, add_company, add_address };
		// 输入的省市区的值
		String[] add_pcr = { "1800", "1806", "180602" };
		// String[] add_pcr= PropertiesDataProvider.getTestData(configFilePath,
		// "add_pcr");
		// 提示语检测
		By[] add_text_p = { AddUserInfoPage.AUIP_INPUT_NAME_P, AddUserInfoPage.AUIP_INPUT_TEL_P, AddUserInfoPage.AUIP_INPUT_IDCARD_P, AddUserInfoPage.AUIP_INPUT_COMPANY_P, AddUserInfoPage.AUIP_INPUT_ADDRESS_P };
		String[] add_text_q = { "请输入2-8个中文字符", "请输入正确的电话号码", "请输入正确的身份证号码", "", "省 不能为空" };

		HomePageHelper.waitHomePageToLoad(timeOut, seleniumUtil);
		HomePageHelper.enterPage(seleniumUtil, HomePage.HP_BUTTON_LOGIN);
		LoginPageHelper.login(seleniumUtil, register_username, password);
		seleniumUtil.waitForElementToLoad(timeOut, HomePage.HP_BUTTON_FREESEND);
		HomePageHelper.enterPage(seleniumUtil, HomePage.HP_BUTTON_FREESEND);
		AddUserInfoPagerHelper.waitAddUserInfoPageToLoad(timeOut, seleniumUtil);
		// 清空文本框和下拉列表:省
		for (By by : bys) {
			seleniumUtil.clear(seleniumUtil.findElementBy(by));
		}
		seleniumUtil.selectByIndex(AddUserInfoPage.AUIP_SELECT_PROVINCE, 0);

		// 循环填写一个文本框并检测提示语
		for (int i = 0; i < 5; i++) {// 可以定义i,j,k,l进行几层循环
			if (i == 4) {
				for (int x = 0; x < 3; x++) {
					seleniumUtil.selectByValue(add_select[x], add_pcr[x]);
				}
			}
			seleniumUtil.type(seleniumUtil.findElementBy(bys[i]), add_text[i]);
			AddUserInfoPagerHelper.enterPage(seleniumUtil, AddUserInfoPage.AUIP_BUTTON_SUBMIT);
			// 循环检测提示语
			for (int j = 0; j < 5; j++) {
				if (j != i && j != 3) {
					seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(add_text_p[j]).getText(), add_text_q[j]);
				}
			}
			AddUserInfoPagerHelper.enterPage(seleniumUtil, AddUserInfoPage.AUIP_BUTTON_BACK);
			seleniumUtil.waitForElementToLoad(timeOut, HomePage.HP_BUTTON_FREESEND);
			HomePageHelper.enterPage(seleniumUtil, HomePage.HP_BUTTON_FREESEND);
		}
	}
}
