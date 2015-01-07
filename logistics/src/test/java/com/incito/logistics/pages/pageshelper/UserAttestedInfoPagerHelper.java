package com.incito.logistics.pages.pageshelper;

import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.incito.logistics.pages.UserAttestedInfoPage;
import com.incito.logistics.util.SeleniumUtil;

/**
 * @author xy-incito-wy
 * @description 完善用户信息页面帮助类
 * */
public class UserAttestedInfoPagerHelper {
	public static Logger logger = Logger.getLogger(UserAttestedInfoPagerHelper.class.getName());

	/** 等待完善信息页面元素加载出来 */
	public static void waitUserAttestedInfoPageToLoad(int timeOut, SeleniumUtil seleniumUtil) {
		logger.info("Start checking addUserInfo page elements");
		seleniumUtil.waitForElementToLoad(timeOut, UserAttestedInfoPage.UAIP_TEXT_TITLE);
		seleniumUtil.waitForElementToLoad(timeOut, UserAttestedInfoPage.UAIP_INPUT_ADDRESS);
		seleniumUtil.waitForElementToLoad(timeOut, UserAttestedInfoPage.UAIP_SELECT_CITY);
		seleniumUtil.waitForElementToLoad(timeOut, UserAttestedInfoPage.UAIP_INPUT_COMPANY);
		seleniumUtil.waitForElementToLoad(timeOut, UserAttestedInfoPage.UAIP_INPUT_IDCARD);
		seleniumUtil.waitForElementToLoad(timeOut, UserAttestedInfoPage.UAIP_INPUT_NAME);
		seleniumUtil.waitForElementToLoad(timeOut, UserAttestedInfoPage.UAIP_SELECT_REGION);
		seleniumUtil.waitForElementToLoad(timeOut, UserAttestedInfoPage.UAIP_INPUT_TEL);
		seleniumUtil.waitForElementToLoad(timeOut, UserAttestedInfoPage.UAIP_SELECT_PROVINCE);
		seleniumUtil.waitForElementToLoad(timeOut, UserAttestedInfoPage.UAIP_INPUT_UPLOAD);

		seleniumUtil.waitForElementToLoad(timeOut, UserAttestedInfoPage.UAIP_BUTTON_BACK);
		seleniumUtil.waitForElementToLoad(timeOut, UserAttestedInfoPage.UAIP_BUTTON_SUBMIT);
		logger.info("Check addUserInfo page elements completed");

	}

	/** 检查完善信息页面上的文本 */
	public static void checkUserAttestedInfoPageText(SeleniumUtil seleniumUtil) {
		logger.info("Start checking addUserInfo page text");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(UserAttestedInfoPage.UAIP_TEXT_TITLE).getText(), "认证信息");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(UserAttestedInfoPage.UAIP_TEXT_TITLE_DES).getText(), "请完善认证信息，通过认证后让更多的司机关注到您的货源信息，并提升订单成交率。" + "\n" + "您还可以查看更详细的车源与货源。");

		int size = seleniumUtil.findElementsBy(UserAttestedInfoPage.UAIP_TEXT_DES).size();
		String tabs[] = { "姓名", "联系电话", "输入验证码", "身份证号", "公司名称", "公司地址", " ", "证件照片" };
		for (int i = 0; i < size; i++) {
			if (i == 6)
				continue;
			String temp = seleniumUtil.findElementsBy(UserAttestedInfoPage.UAIP_TEXT_DES).get(i).getText().replaceAll(" ", "");
			temp = temp.substring(temp.indexOf("*") + 1, temp.lastIndexOf("："));
			seleniumUtil.isTextCorrect(temp, tabs[i]);
		}
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(UserAttestedInfoPage.UAIP_TEL_PROVING).getText().replaceAll(" ", ""), "发送验证码至手机");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(UserAttestedInfoPage.UAIP_BUTTON_SUBMIT).getText().replaceAll(" ", ""), "提交");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(UserAttestedInfoPage.UAIP_BUTTON_BACK).getText().replaceAll(" ", ""), "返回");
		logger.info("Check addUserInfo page text completed");
	}

	/** 完善信息页面上点击“提交”或者“返回”按钮 */
	public static void enterPage(SeleniumUtil seleniumUtil, By elementLocator) {
		seleniumUtil.click(seleniumUtil.findElementBy(elementLocator));
	}

	/** 认证用户信息界面完善信息页面上传照片 */
	public static void upLoadPhoto(SeleniumUtil seleniumUtil, By elementLocator, int num) {
		String[] photo = { "/res/img/userAuthenticationInfo/身份证正面.png", "/res/img/userAuthenticationInfo/身份证反面.png", "/res/img/userAuthenticationInfo/营业执照正面.png", "/res/img/userAuthenticationInfo/营业执照反面.png" };
//		for (int i = 0; i < num; i++)
//			seleniumUtil.findElementsBy(elementLocator).get(i).sendKeys(photo[i]);
			seleniumUtil.findElementsBy(elementLocator).get(0).sendKeys(photo[0]);
	}

	/** 认证用户信息界面完善用户信息中输入用户的手机号码和验证码的封装 */
	public static void typeTelChit(SeleniumUtil seleniumUtil, By[] bys, String... info) {
		seleniumUtil.type(seleniumUtil.findElementBy(bys[0]), info[0]);
		seleniumUtil.type(seleniumUtil.findElementBy(bys[1]), info[1]);
		seleniumUtil.click(seleniumUtil.findElementBy(bys[3]));
		seleniumUtil.pause(1500);
		seleniumUtil.type(seleniumUtil.findElementBy(bys[2]), info[2]);
	}

	/** 检查完善信息页面:全为空的提示语 */
	// 公司名称提示语没有，待修改之后在修复该自动化脚本，因为不知道该提示语为什么！
	public static void checkUserAuthenticationInfoPrompt(int timeOut, SeleniumUtil seleniumUtil) {
		logger.info("Start checking checkAddUserInfoPrompt page text");

		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(UserAttestedInfoPage.UAIP_TEXT_TITLE).getText(), "认证信息");
		// seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_NAME_PROMPT).getText(),
		// "请输入2-8个中文字符");
		// seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_TEL_PROMPT).getText(),
		// "请输入正确的电话号码");
		// seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_COMPANY_PROMPT).getText(),"");
		// seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_IDCARD_PROMPT).getText(),
		// "请输入正确的身份证号码");
		// seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_ADDRESS_PROMPT).getText(),
		// "省 不能为空");

		logger.info("Check checkAddUserInfoPrompt page text completed");
	}

	/** 检查完善信息页面：只填写姓名的提示语 */
	public static void checkUserAuthenticationInfoPrompt_Name(int timeOut, SeleniumUtil seleniumUtil, Map<String, String> data) {
		logger.info("Start checking checkAddUserInfoPrompt page text");

		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(UserAttestedInfoPage.UAIP_INPUT_TEL_PROMPT).getText(), "请输入正确的电话号码");
		// seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_COMPANY_PROMPT).getText(),
		// "");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(UserAttestedInfoPage.UAIP_INPUT_IDCARD_PROMPT).getText(), "请输入正确的身份证号码");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(UserAttestedInfoPage.UAIP_INPUT_ADDRESS_PROMPT).getText(), "省 不能为空");

		logger.info("Check checkAddUserInfoPrompt page text completed");
	}

	/** 检查完善信息页面：只填写联系方式的提示语 */
	public static void checkUserAuthenticationInfoPrompt_Tel(int timeOut, SeleniumUtil seleniumUtil) {
		logger.info("Start checking checkAddUserInfoPrompt page text");

		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(UserAttestedInfoPage.UAIP_INPUT_NAME_PROMPT).getText(), "请输入2-8个中文字符");
		// seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_COMPANY_PROMPT).getText(),"");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(UserAttestedInfoPage.UAIP_INPUT_IDCARD_PROMPT).getText(), "请输入正确的身份证号码");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(UserAttestedInfoPage.UAIP_INPUT_ADDRESS_PROMPT).getText(), "省 不能为空");

		logger.info("Check checkAddUserInfoPrompt page text completed");
	}

	/** 检查完善信息页面：只填写身份证号的提示语 */
	public static void checkUserAuthenticationInfoPrompt_Idcard(int timeOut, SeleniumUtil seleniumUtil) {
		logger.info("Start checking checkAddUserInfoPrompt page text");

		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(UserAttestedInfoPage.UAIP_INPUT_NAME_PROMPT).getText(), "请输入2-8个中文字符");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(UserAttestedInfoPage.UAIP_INPUT_TEL_PROMPT).getText(), "请输入正确的电话号码");
		// seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_COMPANY_PROMPT).getText(),"");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(UserAttestedInfoPage.UAIP_INPUT_ADDRESS_PROMPT).getText(), "省 不能为空");

		logger.info("Check checkAddUserInfoPrompt page text completed");
	}

	/** 检查完善信息页面：只填写公司名称的提示语 */
	// 是个bug现在还没有修复
	public static void checkUserAuthenticationPrompt_Company(int timeOut, SeleniumUtil seleniumUtil) {
		logger.info("Start checking checkAddUserInfoPrompt page text");

		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(UserAttestedInfoPage.UAIP_INPUT_NAME_PROMPT).getText(), "请输入2-8个中文字符");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(UserAttestedInfoPage.UAIP_INPUT_TEL_PROMPT).getText(), "请输入正确的电话号码");
		// seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_COMPANY_PROMPT).getText(),"");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(UserAttestedInfoPage.UAIP_INPUT_IDCARD_PROMPT).getText(), "请输入正确的身份证号码");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(UserAttestedInfoPage.UAIP_INPUT_ADDRESS_PROMPT).getText(), "省 不能为空");

		logger.info("Check checkAddUserInfoPrompt page text completed");
	}

	/** 检查完善信息页面：只填写公司地址的提示语 */
	public static void checkUserAuthenticationInfoPrompt_Address(int timeOut, SeleniumUtil seleniumUtil) {
		logger.info("Start checking checkAddUserInfoPrompt page text");

		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(UserAttestedInfoPage.UAIP_INPUT_NAME_PROMPT).getText(), "请输入2-8个中文字符");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(UserAttestedInfoPage.UAIP_INPUT_TEL_PROMPT).getText(), "请输入正确的电话号码");
		// seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_COMPANY_PROMPT).getText(),"");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(UserAttestedInfoPage.UAIP_INPUT_IDCARD_PROMPT).getText(), "请输入正确的身份证号码");

		logger.info("Check checkAddUserInfoPrompt page text completed");
	}

	/** 检查完善信息页面:填写了姓名和联系方式的提示语 */
	public static void checkUserAuthenticationInfoPrompt_NameTel(int timeOut, SeleniumUtil seleniumUtil) {
		logger.info("Start checking checkAddUserInfoPrompt page text");

		// seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_COMPANY_PROMPT).getText(),"");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(UserAttestedInfoPage.UAIP_INPUT_IDCARD_PROMPT).getText(), "请输入正确的身份证号码");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(UserAttestedInfoPage.UAIP_INPUT_ADDRESS_PROMPT).getText(), "省 不能为空");

		logger.info("Check checkAddUserInfoPrompt page text completed");
	}

	/** 检查完善信息页面:填写了姓名和身份证号的提示语 */
	public static void checkUserAuthenticationInfoPrompt_NameIdcard(int timeOut, SeleniumUtil seleniumUtil) {
		logger.info("Start checking checkAddUserInfoPrompt page text");

		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(UserAttestedInfoPage.UAIP_INPUT_TEL_PROMPT).getText(), "请输入正确的电话号码");
		// seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_COMPANY_PROMPT).getText(),"");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(UserAttestedInfoPage.UAIP_INPUT_ADDRESS_PROMPT).getText(), "省 不能为空");

		logger.info("Check checkAddUserInfoPrompt page text completed");
	}

	/** 检查完善信息页面:填写了姓名和公司名称的提示语 */
	public static void checkUserAuthenticationInfoPrompt_NameCompany(int timeOut, SeleniumUtil seleniumUtil) {
		logger.info("Start checking checkAddUserInfoPrompt page text");

		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(UserAttestedInfoPage.UAIP_INPUT_TEL_PROMPT).getText(), "请输入正确的电话号码");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(UserAttestedInfoPage.UAIP_INPUT_IDCARD_PROMPT).getText(), "请输入正确的身份证号码");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(UserAttestedInfoPage.UAIP_INPUT_ADDRESS_PROMPT).getText(), "省 不能为空");

		logger.info("Check checkAddUserInfoPrompt page text completed");
	}

	/** 检查完善信息页面:填写了姓名和公司地址的提示语 */
	public static void checkUserAuthenticationInfoPrompt_NameAdress(int timeOut, SeleniumUtil seleniumUtil) {
		logger.info("Start checking checkAddUserInfoPrompt page text");

		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(UserAttestedInfoPage.UAIP_INPUT_TEL_PROMPT).getText(), "请输入正确的电话号码");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(UserAttestedInfoPage.UAIP_INPUT_IDCARD_PROMPT).getText(), "请输入正确的身份证号码");
		// seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_COMPANY_PROMPT).getText(),"");

		logger.info("Check checkAddUserInfoPrompt page text completed");
	}

	/** 检查完善信息页面:填写了联系方式和身份证号的提示语 */
	public static void checkUserAuthenticationInfoPrompt_TelIdcard(int timeOut, SeleniumUtil seleniumUtil) {
		logger.info("Start checking checkAddUserInfoPrompt page text");

		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(UserAttestedInfoPage.UAIP_INPUT_NAME_PROMPT).getText(), "请输入2-8个中文字符");
		// seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_COMPANY_PROMPT).getText(),"");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(UserAttestedInfoPage.UAIP_INPUT_ADDRESS_PROMPT).getText(), "省 不能为空");

		logger.info("Check checkAddUserInfoPrompt page text completed");
	}

	/** 检查完善信息页面:填写了联系方式和公司名称的提示语 */
	public static void checkUserAuthenticationInfoPrompt_TelCompany(int timeOut, SeleniumUtil seleniumUtil) {
		logger.info("Start checking checkAddUserInfoPrompt page text");

		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(UserAttestedInfoPage.UAIP_INPUT_NAME_PROMPT).getText(), "请输入2-8个中文字符");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(UserAttestedInfoPage.UAIP_INPUT_IDCARD_PROMPT).getText(), "请输入正确的身份证号码");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(UserAttestedInfoPage.UAIP_INPUT_ADDRESS_PROMPT).getText(), "省 不能为空");

		logger.info("Check checkAddUserInfoPrompt page text completed");
	}

	/** 检查完善信息页面:填写了联系方式和公司地址的提示语 */
	public static void checkUserAuthenticationInfoPrompt_TelAdress(int timeOut, SeleniumUtil seleniumUtil) {
		logger.info("Start checking checkAddUserInfoPrompt page text");

		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(UserAttestedInfoPage.UAIP_INPUT_NAME_PROMPT).getText(), "请输入2-8个中文字符");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(UserAttestedInfoPage.UAIP_INPUT_IDCARD_PROMPT).getText(), "请输入正确的身份证号码");
		// seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_COMPANY_PROMPT).getText(),"");

		logger.info("Check checkAddUserInfoPrompt page text completed");
	}

	/** 检查完善信息页面:填写了身份证号和公司名称的提示语 */
	public static void checkUserAuthenticationInfoPrompt_IdcardCompany(int timeOut, SeleniumUtil seleniumUtil) {
		logger.info("Start checking checkAddUserInfoPrompt page text");

		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(UserAttestedInfoPage.UAIP_INPUT_NAME_PROMPT).getText(), "请输入2-8个中文字符");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(UserAttestedInfoPage.UAIP_INPUT_TEL_PROMPT).getText(), "请输入正确的电话号码");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(UserAttestedInfoPage.UAIP_INPUT_ADDRESS_PROMPT).getText(), "省 不能为空");

		logger.info("Check checkAddUserInfoPrompt page text completed");
	}

	/** 检查完善信息页面:填写了身份证号和公司地址的提示语 */
	public static void checkUserAuthenticationInfoPrompt_IdcardAdress(int timeOut, SeleniumUtil seleniumUtil) {
		logger.info("Start checking checkAddUserInfoPrompt page text");

		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(UserAttestedInfoPage.UAIP_INPUT_NAME_PROMPT).getText(), "请输入2-8个中文字符");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(UserAttestedInfoPage.UAIP_INPUT_TEL_PROMPT).getText(), "请输入正确的电话号码");
		// seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_COMPANY_PROMPT).getText(),"");

		logger.info("Check checkAddUserInfoPrompt page text completed");
	}

	/** 检查完善信息页面:填写了公司名称和公司地址的提示语 */
	public static void checkUserAuthenticationInfoPrompt_CompanyAdress(int timeOut, SeleniumUtil seleniumUtil) {
		logger.info("Start checking checkAddUserInfoPrompt page text");

		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(UserAttestedInfoPage.UAIP_INPUT_NAME_PROMPT).getText(), "请输入2-8个中文字符");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(UserAttestedInfoPage.UAIP_INPUT_TEL_PROMPT).getText(), "请输入正确的电话号码");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(UserAttestedInfoPage.UAIP_INPUT_IDCARD_PROMPT).getText(), "请输入正确的身份证号码");

		logger.info("Check checkAddUserInfoPrompt page text completed");
	}

	/** 检查完善信息页面:填写了姓名，联系方式，身份证号的提示语 */
	public static void checkUserAuthenticationInfoPrompt_NameTelIdcard(int timeOut, SeleniumUtil seleniumUtil) {
		logger.info("Start checking checkAddUserInfoPrompt page text");

		// seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_COMPANY_PROMPT).getText(),"");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(UserAttestedInfoPage.UAIP_INPUT_ADDRESS_PROMPT).getText(), "省 不能为空");

		logger.info("Check checkAddUserInfoPrompt page text completed");
	}

	/** 检查完善信息页面:填写了姓名，联系方式，公司名称的提示语 */
	public static void checkUserAuthenticationInfoPrompt_NameTelCompany(int timeOut, SeleniumUtil seleniumUtil) {
		logger.info("Start checking checkAddUserInfoPrompt page text");

		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(UserAttestedInfoPage.UAIP_INPUT_IDCARD_PROMPT).getText(), "请输入正确的身份证号码");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(UserAttestedInfoPage.UAIP_INPUT_ADDRESS_PROMPT).getText(), "省 不能为空");

		logger.info("Check checkAddUserInfoPrompt page text completed");
	}

	/** 检查完善信息页面:填写了姓名，联系方式，公司地址的提示语 */
	public static void checkUserAuthenticationInfoPrompt_NameTelAddress(int timeOut, SeleniumUtil seleniumUtil) {
		logger.info("Start checking checkAddUserInfoPrompt page text");

		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(UserAttestedInfoPage.UAIP_INPUT_IDCARD_PROMPT).getText(), "请输入正确的身份证号码");
		// seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_COMPANY_PROMPT).getText(),"");

		logger.info("Check checkAddUserInfoPrompt page text completed");
	}

	/** 检查完善信息页面:填写了姓名，身份证号，公司名称的提示语 */
	public static void checkUserAuthenticationInfoPrompt_NameIdcardCompany(int timeOut, SeleniumUtil seleniumUtil) {
		logger.info("Start checking checkAddUserInfoPrompt page text");

		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(UserAttestedInfoPage.UAIP_INPUT_TEL_PROMPT).getText(), "请输入正确的电话号码");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(UserAttestedInfoPage.UAIP_INPUT_ADDRESS_PROMPT).getText(), "省 不能为空");

		logger.info("Check checkAddUserInfoPrompt page text completed");
	}

	/** 检查完善信息页面:填写了姓名，身份证号，公司地址的提示语 */
	public static void checkUserAuthenticationInfoPrompt_NameIdcardAddress(int timeOut, SeleniumUtil seleniumUtil) {
		logger.info("Start checking checkAddUserInfoPrompt page text");

		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(UserAttestedInfoPage.UAIP_INPUT_TEL_PROMPT).getText(), "请输入正确的电话号码");
		// seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_COMPANY_PROMPT).getText(),"");

		logger.info("Check checkAddUserInfoPrompt page text completed");
	}

	/** 检查完善信息页面:填写了姓名，公司名称，公司地址的提示语 */
	public static void checkUserAuthenticationInfoPrompt_NameCompanyAddress(int timeOut, SeleniumUtil seleniumUtil) {
		logger.info("Start checking checkAddUserInfoPrompt page text");

		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(UserAttestedInfoPage.UAIP_INPUT_TEL_PROMPT).getText(), "请输入正确的电话号码");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(UserAttestedInfoPage.UAIP_INPUT_IDCARD_PROMPT).getText(), "请输入正确的身份证号码");

		logger.info("Check checkAddUserInfoPrompt page text completed");
	}

	/** 检查完善信息页面:填写了联系方式，身份证号，公司名称的提示语 */
	public static void checkUserAuthenticationInfoPrompt_TelIdcardCompany(int timeOut, SeleniumUtil seleniumUtil) {
		logger.info("Start checking checkAddUserInfoPrompt page text");

		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(UserAttestedInfoPage.UAIP_INPUT_NAME_PROMPT).getText(), "请输入2-8个中文字符");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(UserAttestedInfoPage.UAIP_INPUT_ADDRESS_PROMPT).getText(), "省 不能为空");

		logger.info("Check checkAddUserInfoPrompt page text completed");
	}

	/** 检查完善信息页面:填写了联系方式，身份证号，公司地址的提示语 */
	public static void checkUserAuthenticationInfoPrompt_TelIdcardAddress(int timeOut, SeleniumUtil seleniumUtil) {
		logger.info("Start checking checkAddUserInfoPrompt page text");

		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(UserAttestedInfoPage.UAIP_INPUT_NAME_PROMPT).getText(), "请输入2-8个中文字符");
		// seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_COMPANY_PROMPT).getText(),"");

		logger.info("Check checkAddUserInfoPrompt page text completed");
	}

	/** 检查完善信息页面:填写了联系方式，公司名称，公司地址的提示语 */
	public static void checkUserAuthenticationInfoPrompt_TelCompanyAddress(int timeOut, SeleniumUtil seleniumUtil) {
		logger.info("Start checking checkAddUserInfoPrompt page text");

		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(UserAttestedInfoPage.UAIP_INPUT_NAME_PROMPT).getText(), "请输入2-8个中文字符");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(UserAttestedInfoPage.UAIP_INPUT_IDCARD_PROMPT).getText(), "请输入正确的身份证号码");

		logger.info("Check checkAddUserInfoPrompt page text completed");
	}

	/** 检查完善信息页面:填写了身份证号，公司名称，公司地址的提示语 */
	public static void checkUserAuthenticationInfoPrompt_IdcardCompanyAddress(int timeOut, SeleniumUtil seleniumUtil) {
		logger.info("Start checking checkAddUserInfoPrompt page text");

		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(UserAttestedInfoPage.UAIP_INPUT_NAME_PROMPT).getText(), "请输入2-8个中文字符");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(UserAttestedInfoPage.UAIP_INPUT_TEL_PROMPT).getText(), "请输入正确的电话号码");

		logger.info("Check checkAddUserInfoPrompt page text completed");
	}

	/** 检查完善信息页面：填写姓名，电话，身份证号，公司名称的提示语 */
	public static void checkUserAuthenticationInfoPrompt_NameTelIdcardCompany(int timeOut, SeleniumUtil seleniumUtil) {
		logger.info("Start checking checkAddUserInfoPrompt page text");

		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(UserAttestedInfoPage.UAIP_INPUT_ADDRESS_PROMPT).getText(), "省 不能为空");

		logger.info("Check checkAddUserInfoPrompt page text completed");
	}

	/** 检查完善信息页面:填写姓名，电话，身份证号，公司地址提示语 */
	public static void checkUserAuthenticationInfoPrompt_NameTelIdcardAddress(int timeOut, SeleniumUtil seleniumUtil) {
		logger.info("Start checking checkAddUserInfoPrompt page text");

		// seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_COMPANY_PROMPT).getText(),"");

		logger.info("Check checkAddUserInfoPrompt page text completed");
	}

	/** 检查完善信息页面:填写姓名，电话，公司名称，公司地址提示语 */
	public static void checkUserAuthenticationInfoPrompt_NameTelCompanyAddress(int timeOut, SeleniumUtil seleniumUtil) {
		logger.info("Start checking checkAddUserInfoPrompt page text");

		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(UserAttestedInfoPage.UAIP_INPUT_NAME_PROMPT).getText(), "请输入2-8个中文字符");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(UserAttestedInfoPage.UAIP_INPUT_TEL_PROMPT).getText(), "请输入正确的电话号码");
		// seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_COMPANY_PROMPT).getText(),"");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(UserAttestedInfoPage.UAIP_INPUT_IDCARD_PROMPT).getText(), "请输入正确的身份证号码");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(UserAttestedInfoPage.UAIP_INPUT_ADDRESS_PROMPT).getText(), "省 不能为空");

		logger.info("Check checkAddUserInfoPrompt page text completed");
	}

	/** 检查完善信息页面:填写姓名，身份证号，公司名称，公司地址提示语 */
	public static void checkUserAuthenticationInfoPrompt_NameIdcardCompanyAddress(int timeOut, SeleniumUtil seleniumUtil) {
		logger.info("Start checking checkAddUserInfoPrompt page text");

		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(UserAttestedInfoPage.UAIP_INPUT_NAME_PROMPT).getText(), "请输入2-8个中文字符");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(UserAttestedInfoPage.UAIP_INPUT_TEL_PROMPT).getText(), "请输入正确的电话号码");
		// seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_COMPANY_PROMPT).getText(),"");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(UserAttestedInfoPage.UAIP_INPUT_IDCARD_PROMPT).getText(), "请输入正确的身份证号码");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(UserAttestedInfoPage.UAIP_INPUT_ADDRESS_PROMPT).getText(), "省 不能为空");

		logger.info("Check checkAddUserInfoPrompt page text completed");
	}

	/** 检查完善信息页面:填写电话，身份证号，公司名称，公司地址提示语 */
	public static void checkUserAuthenticationInfoPrompt_TelIdcardCompanyAddress(int timeOut, SeleniumUtil seleniumUtil) {
		logger.info("Start checking checkAddUserInfoPrompt page text");

		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(UserAttestedInfoPage.UAIP_INPUT_NAME_PROMPT).getText(), "请输入2-8个中文字符");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(UserAttestedInfoPage.UAIP_INPUT_TEL_PROMPT).getText(), "请输入正确的电话号码");
		// seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_COMPANY_PROMPT).getText(),"");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(UserAttestedInfoPage.UAIP_INPUT_IDCARD_PROMPT).getText(), "请输入正确的身份证号码");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(UserAttestedInfoPage.UAIP_INPUT_ADDRESS_PROMPT).getText(), "省 不能为空");

		logger.info("Check checkAddUserInfoPrompt page text completed");
	}

	/** 检查完善信息页面:必填项全部填写 */
	public static void checkUserAuthenticationInfoPrompt_All(int timeOut, SeleniumUtil seleniumUtil) {
		logger.info("Start checking checkAddUserInfoPrompt page text");

		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(UserAttestedInfoPage.UAIP_POPUP_TRUE).getText(), "您已成功提交个人信息，我们将在24小时内完成审核，您可以先发货了！如需优先认证，请致电");

		logger.info("Check checkAddUserInfoPrompt page text completed");
	}
}
