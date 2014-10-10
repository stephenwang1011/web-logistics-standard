package com.incito.logistics.pages.pageshelper;

import java.util.Map;

import org.openqa.selenium.By;

import com.incito.logistics.pages.HomePage;
import com.incito.logistics.pages.RegisterPage;
import com.incito.logistics.util.SeleniumUtil;
/**
 * @author xy-incito-wangkai 
 * @description 注册页面上的方法
 * 
 * */
public class RegisterPageHelper {

	/** 等待注册上某个重要元素显示出来 */
	public static void waitRegisterPageToLoad(int timeOut, SeleniumUtil seleniumUtil) {
		seleniumUtil.waitForElementToLoad(timeOut, RegisterPage.RP_INPUT_USERNAME);
		seleniumUtil.waitForElementToLoad(timeOut, RegisterPage.RP_INPUT_PASSWD);
		seleniumUtil.waitForElementToLoad(timeOut, RegisterPage.RP_INPUT_REPASSWD);
		seleniumUtil.waitForElementToLoad(timeOut, RegisterPage.RP_BUTTON_REGISTER);
		seleniumUtil.waitForElementToLoad(timeOut, RegisterPage.RP_BUTTON_BACK);

	}

	/** 检查注册页面上的文本 */
	public static void checkRegisterPageText(SeleniumUtil seleniumUtil,Map<String, String> data) {

		seleniumUtil.isTextCorrect(seleniumUtil.getTitle(), data.get("TITLE"));
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(RegisterPage.RP_INPUT_USERNAME).getAttribute("placeholder"), data.get("RP_INPUT_USERNAME"));
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(RegisterPage.RP_INPUT_PASSWD).getAttribute("placeholder"), data.get("RP_INPUT_PASSWD"));
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(RegisterPage.RP_INPUT_REPASSWD).getAttribute("placeholder"), data.get("RP_INPUT_REPASSWD"));
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(RegisterPage.RP_BUTTON_REGISTER).getText(), data.get("RP_BUTTON_REGISTER"));
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(RegisterPage.RP_BUTTON_BACK).getText(), data.get("RP_BUTTON_BACK"));
		//此处不从excel中取数据
		FooterPageHelper.checkFooterPageText(seleniumUtil);
	}

	/** 注册页面上面输入用户名和密码 */
	public static void registerUserInfo(SeleniumUtil seleniumUtil, By by, String key) {
		seleniumUtil.type(seleniumUtil.findElementBy(by), key);
	}

	/** 检查注册成功后自动登录是否正确登录 */
	public static void checkUserInfo(int timeOut, int sleepTime, SeleniumUtil seleniumUtil, String username) {
		seleniumUtil.pause(sleepTime);
		seleniumUtil.waitForElementToLoad(timeOut, HomePage.HP_TEXT_USERINFO);
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(HomePage.HP_TEXT_USERINFO).getText(), username);
	}

	/** 从注册进入指定的页面-根据元素定位来确定什么页面 */
	public static void enterPage(SeleniumUtil seleniumUtil, By elementLocator) {
		seleniumUtil.click(seleniumUtil.findElementBy(elementLocator));

	}
	
	/** 从注册进入指定的页面-根据元素定位来来清空指定文本输入框 */
	public static void clearText(SeleniumUtil seleniumUtil, By elementLocator) {
		seleniumUtil.clear(seleniumUtil.findElementBy(elementLocator));
	}
	

	/** 检查注册页面上的输入框全为空的提示语 */
	// 能否使用数组来表示后面的是提示语，然后再数组中添加各种提示语；
	// 但是存在一个问题就是该处不能使用一个方法来进行表示，比如说密码全为空只含有两个提示语，当“确认密码”填写了字符时，该处就会出现三个提示语；及检查关系能否为“与”的关系
	public static void checkRegisterPagePrompt(int timeOut, SeleniumUtil seleniumUtil,Map<String,String> data) {
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(RegisterPage.RP_INPUT_USERNAME_P).getText(), data.get("RP_INPUT_USERNAME_P"));
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(RegisterPage.RP_INPUT_PASSWD_P).getText(), data.get("RP_INPUT_PASSWD_P"));
		FooterPageHelper.checkFooterPageText(seleniumUtil);
	}

	/** 检查注册页面上只输入“用户名称”的的提示语 */
	public static void checkRegisterPagePrompt_username(int timeOut, SeleniumUtil seleniumUtil) {
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(RegisterPage.RP_INPUT_PASSWD_P).getText(), "密码长度为6-20个字符");
		FooterPageHelper.checkFooterPageText(seleniumUtil);
	}
	/** 检查注册页面上的只输入“密码1”的提示语 */
	public static void checkRegisterPagePrompt_passwd(int timeOut, SeleniumUtil seleniumUtil) {
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(RegisterPage.RP_INPUT_USERNAME_P).getText(), "用户名称不能全部为数字");
		FooterPageHelper.checkFooterPageText(seleniumUtil);
	}
	
	/** 检查注册页面上的只输入“密码2”的提示语 */
	public static void checkRegisterPagePrompt_repasswd(int timeOut, SeleniumUtil seleniumUtil) {
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(RegisterPage.RP_INPUT_USERNAME_P).getText(), "用户名称不能全部为数字");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(RegisterPage.RP_INPUT_PASSWD_P).getText(), "密码长度为6-20个字符");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(RegisterPage.RP_INPUT_REPASSWD_P).getText(), "两次密码输入不一致，请重新输入");
		FooterPageHelper.checkFooterPageText(seleniumUtil);
	}

	/** 检查注册页面上的输入“用户名”和“密码1”的提示语 */
	//有问题：注册成功
	public static void checkRegisterPagePrompt_UsernameAndPassword(int timeOut, SeleniumUtil seleniumUtil) {
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(RegisterPage.RP_INPUT_USERNAME_P).getText(), "用户名称不能全部为数字");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(RegisterPage.RP_INPUT_PASSWD_P).getText(), "密码长度为6-20个字符");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(RegisterPage.RP_INPUT_REPASSWD_P).getText(), "两次密码输入不一致，请重新输入");
		FooterPageHelper.checkFooterPageText(seleniumUtil);
	}
	
	/** 检查注册页面上的输入“用户名”和“密码2”的提示语 */
	public static void checkRegisterPagePrompt_UsernameAndRepassword(int timeOut, SeleniumUtil seleniumUtil) {
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(RegisterPage.RP_INPUT_PASSWD_P).getText(), "密码长度为6-20个字符");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(RegisterPage.RP_INPUT_REPASSWD_P).getText(), "两次密码输入不一致，请重新输入");
		FooterPageHelper.checkFooterPageText(seleniumUtil);
	}
	
	/** 检查注册页面上的输入相同“密码1”和“密码2”的提示语 */
	public static void checkRegisterPagePrompt_PasswordAndRepassword(int timeOut, SeleniumUtil seleniumUtil) {
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(RegisterPage.RP_INPUT_USERNAME_P).getText(), "用户名称不能全部为数字");
		FooterPageHelper.checkFooterPageText(seleniumUtil);
	}
	
	/** 检查注册页面上的输入不相同“密码1”和“密码2”的提示语 */
	public static void checkRegisterPagePrompt_PasswordDifRepassword(int timeOut, SeleniumUtil seleniumUtil) {
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(RegisterPage.RP_INPUT_USERNAME_P).getText(), "用户名称不能全部为数字");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(RegisterPage.RP_INPUT_REPASSWD_P).getText(), "两次密码输入不一致，请重新输入");
		FooterPageHelper.checkFooterPageText(seleniumUtil);
	}
	
	/** 检查注册页面上的输入“用户名称”与不相同“密码1”和“密码2”的提示语 */
	public static void checkRegisterPagePrompt_UssernameAndPasswordDifRepassword(int timeOut, SeleniumUtil seleniumUtil) {
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(RegisterPage.RP_INPUT_REPASSWD_P).getText(), "两次密码输入不一致，请重新输入");
		FooterPageHelper.checkFooterPageText(seleniumUtil);
	}
}
