package com.incito.logistics.pages.pageshelper;
import org.apache.log4j.Logger;
import com.incito.logistics.pages.AddUserInfoPage;
import com.incito.logistics.util.SeleniumUtil;

/**
 * @author xy-incito-wy
 * @description 完善用户信息页面帮助类
 * */
public class AddUserInfoPagerHelper {
	public static Logger logger = Logger.getLogger(AddUserInfoPagerHelper.class.getName());

	/** 等待完善信息页面元素加载出来 */
	public static void waitAddUserInfoPageToLoad(int timeOut, SeleniumUtil seleniumUtil) {
		logger.info("Start checking addUserInfo page elements");
		seleniumUtil.waitForElementToLoad(timeOut, AddUserInfoPage.AUIP_TEXT_TITLE);
		seleniumUtil.waitForElementToLoad(timeOut, AddUserInfoPage.AUIP_INPUT_ADDRESS);
		seleniumUtil.waitForElementToLoad(timeOut, AddUserInfoPage.AUIP_INPUT_CITY);
		seleniumUtil.waitForElementToLoad(timeOut, AddUserInfoPage.AUIP_INPUT_COMPANY);
		seleniumUtil.waitForElementToLoad(timeOut, AddUserInfoPage.AUIP_INPUT_IDCARD);
		seleniumUtil.waitForElementToLoad(timeOut, AddUserInfoPage.AUIP_INPUT_NAME);
		seleniumUtil.waitForElementToLoad(timeOut, AddUserInfoPage.AUIP_INPUT_REGION);
		seleniumUtil.waitForElementToLoad(timeOut, AddUserInfoPage.AUIP_INPUT_TEL);
		seleniumUtil.waitForElementToLoad(timeOut, AddUserInfoPage.AUIP_SELECT_PROVINCE);
		seleniumUtil.waitForElementToLoad(timeOut, AddUserInfoPage.AUIP_INPUT_UPLOAD1);

		seleniumUtil.waitForElementToLoad(timeOut, AddUserInfoPage.AUIP_BUTTON_BACK);
		seleniumUtil.waitForElementToLoad(timeOut, AddUserInfoPage.AUIP_BUTTON_SUBMIT);
		logger.info("Check addUserInfo page elements completed");

	}

	/** 检查完善信息页面上的文本 */
	public static void checkAddUserInfoPageText(SeleniumUtil seleniumUtil) {
		logger.info("Start checking addUserInfo page text");
		
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_TEXT_TITLE).getText(), "请完善您的个人信息");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_TEXT_ADDRESS).getText(), "公司地址：");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_TEXT_COMPANY).getText(), "公司名称：");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_TEXT_IDCARD).getText(), "身份证号：");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_TEXT_NAME).getText(), "姓名：");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_TEXT_TEL).getText(), "联系电话：");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_TEXT_PHOTO).getText(), "证件照片：");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_BUTTON_SUBMIT).getText(), "提交");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_BUTTON_BACK).getText(), "返回");
	
		logger.info("Check addUserInfo page text completed");

	}

}
