package com.incito.logistics.pages.pageshelper;

import org.openqa.selenium.By;

import com.incito.logistics.pages.HomePage;
import com.incito.logistics.pages.RegisterPage;
import com.incito.logistics.util.SeleniumUtil;

public class RegisterPageHelper {

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
		seleniumUtil.isTextEquals(seleniumUtil.getTitle(), "logistics - 物流管理");
		seleniumUtil.isTextEquals(seleniumUtil.findElementBy(RegisterPage.RP_INPUT_USERNAME).getAttribute("placeholder"), "至少输入4个字符");
		seleniumUtil.isTextEquals(seleniumUtil.findElementBy(RegisterPage.RP_INPUT_PASSWD).getAttribute("placeholder"), "至少输入6个字符");
		seleniumUtil.isTextEquals(seleniumUtil.findElementBy(RegisterPage.RP_INPUT_REPASSWD).getAttribute("placeholder"), "请再次输入登录密码");
		seleniumUtil.isTextEquals(seleniumUtil.findElementBy(RegisterPage.RP_BUTTON_REGISTER).getText(), "注册");
		seleniumUtil.isTextEquals(seleniumUtil.findElementBy(RegisterPage.RP_BUTTON_BACK).getText(), "返回");
		FooterPageHelper.checkRegisterPageText(seleniumUtil);
	}

	/** 注册页面上面输入用户名和密码 */
	public static void registerUserInfo(SeleniumUtil seleniumUtil, By by, String key) {
		seleniumUtil.sendKeys(seleniumUtil.findElementBy(by), key);
	}

	/** 检查注册成功后自动登录是否正确登录 */
	public static void checkUserInfo(int timeOut, int sleepTime, SeleniumUtil seleniumUtil, String username) {
		seleniumUtil.sleep(sleepTime);
		seleniumUtil.waitForElementToLoad(timeOut, HomePage.HP_TEXT_USERINFO);
		seleniumUtil.isTextEquals(seleniumUtil.findElementBy(HomePage.HP_TEXT_USERINFO).getText(), username);
	}

	/** 检查注册页面上的输入框全为空的提示语 */
	//能否使用数组来表示后面的是提示语，然后再数组中添加各种提示语；
	//但是存在一个问题就是该处不能使用一个方法来进行表示，比如说密码全为空只含有两个提示语，当“确认密码”填写了字符时，该处就会出现三个提示语；及检查关系能否为“与”的关系
	public static void checkRegisterPagePoint(int timeOut, SeleniumUtil seleniumUtil) {
		seleniumUtil.isTextEquals(seleniumUtil.findElementBy(RegisterPage.RP_INPUT_USERNAME_P).getText(), "用户名称不能全部为数字");
		seleniumUtil.isTextEquals(seleniumUtil.findElementBy(RegisterPage.RP_INPUT_PASSWD_P).getText(), "密码长度为6-20个字符");
		FooterPageHelper.checkRegisterPageText(seleniumUtil);
	}
	
	/** 检查注册页面上的输入框密码为空的提示语 */
	public static void checkRegisterPagePoint_passwd(int timeOut, SeleniumUtil seleniumUtil) {
		seleniumUtil.isTextEquals(seleniumUtil.findElementBy(RegisterPage.RP_INPUT_PASSWD_P).getText(), "密码长度为6-20个字符");
		FooterPageHelper.checkRegisterPageText(seleniumUtil);
	}
}
