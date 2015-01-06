package com.incito.logistics.pages.pageshelper;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.incito.logistics.pages.UserPasswordPage;
import com.incito.logistics.util.SeleniumUtil;

/**
 * @author xy-incito-wy
 * @description 修改密码帮助类
 * */
public class UserPasswordPageHelper {
	public static Logger logger = Logger.getLogger(UserPasswordPageHelper.class.getName());
	
	/**进入页面*/
	public static void enterPage(SeleniumUtil seleniumUtil,By byElement){
		seleniumUtil.click(seleniumUtil.findElementBy(byElement));
	}
	
	/**等待页面元素加载*/
	public static void waitUserPasswordPageToLoad(SeleniumUtil seleniumUtil,int timeOut){
		
		seleniumUtil.waitForElementToLoad(timeOut, UserPasswordPage.USP_BUTTON_CHANGEPASSWD);
		seleniumUtil.waitForElementToLoad(timeOut, UserPasswordPage.USP_BUTTON_OK);
		seleniumUtil.waitForElementToLoad(timeOut, UserPasswordPage.USP_INPUT_NEWPASSWD);
		seleniumUtil.waitForElementToLoad(timeOut, UserPasswordPage.USP_INPUT_OLDPASSWD);
		seleniumUtil.waitForElementToLoad(timeOut, UserPasswordPage.USP_INPUT_REPASSWD);
		seleniumUtil.waitForElementToLoad(timeOut, UserPasswordPage.USP_TEXT_USERNAME);
		
	}
	
	/**检查页面文本*/
	public static void checkUserPasswordPageText(SeleniumUtil seleniumUtil){
		
		seleniumUtil.isTextCorrect(seleniumUtil.getAttributeText(UserPasswordPage.USP_INPUT_OLDPASSWD, "placeholder"), "至少输入6个字符");
		seleniumUtil.isTextCorrect(seleniumUtil.getAttributeText(UserPasswordPage.USP_INPUT_NEWPASSWD, "placeholder"), "至少输入6个字符");
		seleniumUtil.isTextCorrect(seleniumUtil.getAttributeText(UserPasswordPage.USP_INPUT_REPASSWD, "placeholder"), "至少输入6个字符");
		seleniumUtil.isTextCorrect(seleniumUtil.getText(UserPasswordPage.USP_BUTTON_OK), "提交");

	}
	
	/**检查用户名*/
	public static void checkUserName(String username,SeleniumUtil seleniumUtil){
		
		seleniumUtil.isTextCorrect(seleniumUtil.getText(UserPasswordPage.USP_TEXT_USERNAME), username);
		
	}
	
	
	
	
	
	
	
	
	

}
