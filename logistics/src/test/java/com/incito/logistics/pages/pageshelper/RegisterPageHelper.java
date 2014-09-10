package com.incito.logistics.pages.pageshelper;

import org.openqa.selenium.By;

import com.incito.logistics.pages.RegisterPage;
import com.incito.logistics.util.SeleniumUtil;

public class RegisterPageHelper {

	/**等待页面上某个重要元素显示出来*/
	public static void  waitRegisterPageToLoad(int timeOut,SeleniumUtil seleniumUtil){
		seleniumUtil.waitForElementToLoad(timeOut,RegisterPage.RP_INPUT_USERNAME);
		seleniumUtil.waitForElementToLoad(timeOut,RegisterPage.RP_INPUT_PASSWD);
		seleniumUtil.waitForElementToLoad(timeOut,RegisterPage.RP_INPUT_REPASSWD);
		seleniumUtil.waitForElementToLoad(timeOut,RegisterPage.RP_BUTTON_REGISTER);
		seleniumUtil.waitForElementToLoad(timeOut,RegisterPage.RP_BUTTON_BACK);

	}
	
	/**检查注册页面上的文本*/
	public static void checkRegisterPageText(SeleniumUtil seleniumUtil){
		seleniumUtil.isTextCorrect( seleniumUtil.getTitle(), "logistics - 物流管理");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(RegisterPage.RP_INPUT_USERNAME).getAttribute("placeholder"),"至少输入4个字符");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(RegisterPage.RP_INPUT_PASSWD).getAttribute("placeholder"),"至少输入6个字符");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(RegisterPage.RP_INPUT_REPASSWD).getAttribute("placeholder"),"请再次输入登录密码");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(RegisterPage.RP_BUTTON_REGISTER).getText(),"注册");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(RegisterPage.RP_BUTTON_BACK).getText(),"返回");
		FooterPageHelper.checkRegisterPageText(seleniumUtil);
	}
	
	/**向注册输入框注入信息*/
	public static void sendRegisterInfo(By by,String key,SeleniumUtil seleniumUtil){
		
		  seleniumUtil.type(seleniumUtil.findElementBy(by), key);
		
	}
	
	/**从注册进入指定的页面-根据元素定位来确定什么页面*/
	public static void enterPage(SeleniumUtil seleniumUtil,By elementLocator){
		seleniumUtil.click(seleniumUtil.findElementBy(elementLocator));
		
	}
}
