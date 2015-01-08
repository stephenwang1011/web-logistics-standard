package com.incito.logistics.pages.pageshelper;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

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
	public static void checkRegisterPageText(SeleniumUtil seleniumUtil) {
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(RegisterPage.RP_INPUT_USERNAME).getAttribute("placeholder"), "至少输入4个字符");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(RegisterPage.RP_INPUT_PASSWD).getAttribute("placeholder"), "至少输入6个字符");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(RegisterPage.RP_INPUT_REPASSWD).getAttribute("placeholder"), "请再次输入登录密码");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(RegisterPage.RP_BUTTON_REGISTER).getText(), "注册");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(RegisterPage.RP_BUTTON_BACK).getText(), "返回");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(RegisterPage.RP_TEXT_READAGREEMENT).getText(), "我已阅读并同意《智慧物流网站注册协议》");
		FooterPageHelper.checkFooterPageText(seleniumUtil);
	}

	/** 注册页面上面输入注册信息 */
	public static void typeRegisterUserInfo(SeleniumUtil seleniumUtil, By by,Map<String, String> data,String excelKey) {
		seleniumUtil.type(seleniumUtil.findElementBy(by), data.get(excelKey));
	}

	/** 检查注册成功后自动登录是否正确登录 */
	public static void checkUserInfo(int timeOut, int sleepTime, SeleniumUtil seleniumUtil, String username) {
		seleniumUtil.pause(sleepTime);
		seleniumUtil.waitForElementToLoad(timeOut, HomePage.HP_TEXT_USERINFO);
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(HomePage.HP_TEXT_USERINFO).getText(), username);
	}
	
	/** 检查注册成功后自动登录是否正确登录 */
	public static void checkUserInfo(int timeOut, int sleepTime, SeleniumUtil seleniumUtil, String userKey,Map<String,String> data) {
		seleniumUtil.pause(sleepTime);
		seleniumUtil.waitForElementToLoad(timeOut, HomePage.HP_TEXT_USERINFO);
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(HomePage.HP_TEXT_USERINFO).getText(), data.get(userKey));
	}

	/** 从注册进入指定的页面-根据元素定位来确定什么页面 */
	public static void enterPage(SeleniumUtil seleniumUtil, By elementLocator) {
		seleniumUtil.click(seleniumUtil.findElementBy(elementLocator));

	}
	
	/** 从注册进入指定的页面-根据元素定位来来清空指定文本输入框 */
	public static void clearText(SeleniumUtil seleniumUtil, By elementLocator) {
		seleniumUtil.clear(seleniumUtil.findElementBy(elementLocator));
	}
	

	/** 
	 * 检查注册页面上的输入框全为空的提示语<br>
	 *  */
	public static void checkRegisterPagePrompt_AllEmpty(int timeOut, SeleniumUtil seleniumUtil) {
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(RegisterPage.RP_INPUT_USERNAME_PROMPT).getText(),"用户名长度为4-20个字符");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(RegisterPage.RP_INPUT_PASSWD_PROMPT).getText(), "密码长度为6-20个字符");
		//seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(RegisterPage.RP_INPUT_REPASSWD_PROMPT).getText(), "密码长度为6-20个字符");
		FooterPageHelper.checkFooterPageText(seleniumUtil);
	}

	/** 检查注册页面上只输入“用户名称”的的提示语 */
	public static void checkRegisterPagePrompt_OnlyUsername(int timeOut, SeleniumUtil seleniumUtil) {
		seleniumUtil.click(seleniumUtil.findElementBy(RegisterPage.RP_INPUT_REPASSWD));
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(RegisterPage.RP_INPUT_PASSWD_PROMPT).getText(), "密码长度为6-20个字符");
		//seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(RegisterPage.RP_INPUT_REPASSWD_PROMPT).getText(), "密码长度为6-20个字符");
		FooterPageHelper.checkFooterPageText(seleniumUtil);
	}
	/** 检查注册页面上的只输入“密码”的提示语 */
	public static void checkRegisterPagePrompt_Passwd(int timeOut, SeleniumUtil seleniumUtil) {
		seleniumUtil.click(seleniumUtil.findElementBy(RegisterPage.RP_INPUT_REPASSWD));
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(RegisterPage.RP_INPUT_USERNAME_PROMPT).getText(), "用户名长度为4-20个字符");
		//seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(RegisterPage.RP_INPUT_REPASSWD_PROMPT).getText(), "密码长度为6-20个字符");
		FooterPageHelper.checkFooterPageText(seleniumUtil);
	}
	
	/** 检查注册页面上的只输入“确认密码”的提示语 */
	public static void checkRegisterPagePrompt_Repasswd(int timeOut, SeleniumUtil seleniumUtil) {
		
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(RegisterPage.RP_INPUT_USERNAME_PROMPT).getText(), "用户名长度为4-20个字符");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(RegisterPage.RP_INPUT_PASSWD_PROMPT).getText(), "密码长度为6-20个字符");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(RegisterPage.RP_INPUT_REPASSWD_PROMPT).getText(), "两次密码输入不一致，请重新输入");
		FooterPageHelper.checkFooterPageText(seleniumUtil);
	}

	/** 检查注册页面上的输入“用户名”和“密码”的提示语 */
	//有问题：注册成功
	public static void checkRegisterPagePrompt_UsernameAndPassword(int timeOut, SeleniumUtil seleniumUtil) {
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(RegisterPage.RP_INPUT_REPASSWD_PROMPT).getText(), "密码长度为6-20个字符");
		FooterPageHelper.checkFooterPageText(seleniumUtil);
	}
	
	/** 检查注册页面上的输入“用户名”和“确认密码”的提示语 */
	public static void checkRegisterPagePrompt_UsernameAndRepassword(int timeOut, SeleniumUtil seleniumUtil) {
		//seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(RegisterPage.RP_INPUT_PASSWD_PROMPT).getText(), "密码长度为6-20个字符");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(RegisterPage.RP_INPUT_REPASSWD_PROMPT).getText(), "密码长度为6-20个字符");
		FooterPageHelper.checkFooterPageText(seleniumUtil);
	}
	
	/** 检查注册页面上的输入相同的密码和确认密码的提示语 */
	public static void checkRegisterPagePrompt_PasswordAndRepassword(int timeOut, SeleniumUtil seleniumUtil) {
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(RegisterPage.RP_INPUT_USERNAME_PROMPT).getText(), "用户名长度为4-20个字符");
		FooterPageHelper.checkFooterPageText(seleniumUtil);
	}
	
	/** 检查注册页面上的输入不相同密码和确认密码的提示语 */
	public static void checkRegisterPagePrompt_PasswordDifRepassword(int timeOut, SeleniumUtil seleniumUtil) {
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(RegisterPage.RP_INPUT_USERNAME_PROMPT).getText(), "用户名长度为4-20个字符");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(RegisterPage.RP_INPUT_REPASSWD_PROMPT).getText(), "两次密码输入不一致，请重新输入");
		FooterPageHelper.checkFooterPageText(seleniumUtil);
	}
	
	/** 检查注册页面上的输入“用户名称”与不相同“密码1”和“密码2”的提示语 */
	public static void checkRegisterPagePrompt_UssernameAndPasswordDifRepassword(int timeOut, SeleniumUtil seleniumUtil) {
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(RegisterPage.RP_INPUT_REPASSWD_PROMPT).getText(), "两次密码输入不一致，请重新输入");
		FooterPageHelper.checkFooterPageText(seleniumUtil);
	}
	
	/**由于需求的没有把注册页面上的相关提示语设计出来，故不做提示语检测，如果注册页面上还有注册和返回按钮就认为注册不成功*/
	public static void checkRegistStatus(SeleniumUtil seleniumUtil){
		seleniumUtil.isDisplayed(seleniumUtil.findElementBy(RegisterPage.RP_BUTTON_BACK));
		seleniumUtil.isDisplayed(seleniumUtil.findElementBy(RegisterPage.RP_BUTTON_REGISTER));
	}
	
	/**请确认已阅读该协议 的提示语检测方法*/
	public static void checkAgreementPrompt(SeleniumUtil seleniumUtil,int timeOut){
		seleniumUtil.waitForElementToLoad(timeOut, RegisterPage.RP_TEXT_PROMPT);
		seleniumUtil.isTextCorrect(seleniumUtil.getText(RegisterPage.RP_TEXT_PROMPT), "请确认已阅读该协议");
	}
	/**勾选认证协议*/
	public static void checkAgreement(SeleniumUtil seleniumUtil,int timeOut){
		seleniumUtil.waitForElementToLoad(timeOut, RegisterPage.RP_CHECKBOX_READ);
		if(seleniumUtil.isSelected(seleniumUtil.findElementBy( RegisterPage.RP_CHECKBOX_READ))==false){
			
			seleniumUtil.click(seleniumUtil.findElementBy( RegisterPage.RP_CHECKBOX_READ));
			
		}
	}
	

	/**
	 * 取得弹窗，进入协议页面
	 * */
	public static void switchWindow(SeleniumUtil seleniumUtil, int sleepTime,int timeOut) {
		String currentWindows = seleniumUtil.driver.getWindowHandle();
		seleniumUtil.click(seleniumUtil.findElementBy(RegisterPage.RP_LINK_AGREEMENT));
		seleniumUtil.pause(sleepTime);
		Set<String> handles = seleniumUtil.driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		while (it.hasNext()) {

			if (currentWindows == it.next())
				continue;
			seleniumUtil.window = seleniumUtil.driver.switchTo().window(it.next());
			// 这里可以写做了什么操作，最后操作做完之后会关闭此弹窗
			AgreementPageHelper.waitAgreementPageToLoad(timeOut, seleniumUtil);
			AgreementPageHelper.checkAgreementPageText(seleniumUtil);
			AgreementPageHelper.click15TimesCloseButton(seleniumUtil);
			//seleniumUtil.window.close();

		}
		// 切回到原来的窗口
		seleniumUtil.driver.switchTo().window(currentWindows);

	}
}
