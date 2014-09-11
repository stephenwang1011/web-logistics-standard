package com.incito.logistics.pages.pageshelper;

import com.incito.logistics.pages.RegisterPage;
import com.incito.logistics.util.SeleniumUtil;

public class SendGoodsPageHelper {

	/** 等待页面上某个重要元素显示出来 */
	public static void waitRegisterPageToLoad(int timeOut, SeleniumUtil seleniumUtil) {
		seleniumUtil.waitForElementToLoad(timeOut, RegisterPage.RP_INPUT_USERNAME);
		seleniumUtil.waitForElementToLoad(timeOut, RegisterPage.RP_INPUT_PASSWD);
		seleniumUtil.waitForElementToLoad(timeOut, RegisterPage.RP_INPUT_REPASSWD);
		seleniumUtil.waitForElementToLoad(timeOut, RegisterPage.RP_BUTTON_REGISTER);
		seleniumUtil.waitForElementToLoad(timeOut, RegisterPage.RP_BUTTON_BACK);

	}

	/** 检查注册页面上的文本 */
	public static void checkRegisterPageText(SeleniumUtil seleniumUtil) {
		seleniumUtil.isTextCorrect(seleniumUtil.getTitle(), "logistics - 物流管理");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(RegisterPage.RP_INPUT_USERNAME).getAttribute("placeholder"), "至少输入4个字符");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(RegisterPage.RP_INPUT_PASSWD).getAttribute("placeholder"), "至少输入6个字符");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(RegisterPage.RP_INPUT_REPASSWD).getAttribute("placeholder"), "请再次输入登录密码");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(RegisterPage.RP_BUTTON_REGISTER).getText(), "注册");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(RegisterPage.RP_BUTTON_BACK).getText(), "返回");
		FooterPageHelper.checkRegisterPageText(seleniumUtil);
	}

}
