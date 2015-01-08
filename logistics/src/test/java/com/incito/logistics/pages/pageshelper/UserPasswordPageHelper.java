package com.incito.logistics.pages.pageshelper;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.incito.logistics.pages.HomePage;
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
	
	/**修改密码页面输入相关信息的方法*/
	public static void typeChangePasswdInfo(SeleniumUtil seleniumUtil,String ...infos){
		
		if(infos[0]!=""){
			seleniumUtil.type(seleniumUtil.findElementBy(UserPasswordPage.USP_INPUT_OLDPASSWD), infos[0]);
		}
		if(infos[1]!=""){
			seleniumUtil.type(seleniumUtil.findElementBy(UserPasswordPage.USP_INPUT_NEWPASSWD), infos[1]);
		}
		if(infos[2]!=""){
			seleniumUtil.type(seleniumUtil.findElementBy(UserPasswordPage.USP_INPUT_REPASSWD), infos[2]);
		}

	}
	
	/**验证修改密码失败的方法*/
	public static void checkModifyPasswdFailed(SeleniumUtil seleniumUtil,String username,String password,int timeOut,int sleepTime){
		seleniumUtil.pause(1000);
		seleniumUtil.isDisplayed(seleniumUtil.findElementBy(UserPasswordPage.USP_BUTTON_OK));
		HomePageHelper.enterPage(seleniumUtil, HomePage.HP_TEXT_USERINFO);
		HomePageHelper.enterPage(seleniumUtil, HomePage.HP_LINK_EXIT);
		HomePageHelper.waitHomePageToLoad(timeOut, seleniumUtil);
		HomePageHelper.enterPage(seleniumUtil, HomePage.HP_BUTTON_LOGIN);
		LoginPageHelper.login(seleniumUtil, username,password);
		LoginPageHelper.checkUserInfo(timeOut, sleepTime, seleniumUtil, username);
	}
	
	/**修改密码成功的方法*/
	public static void checkModifyPasswdSuccessed(SeleniumUtil seleniumUtil,int sleepTime,int timeOut,String username,String modifyPassword){
		seleniumUtil.switchToPromptedAlertAfterWait(2000).accept();
		HomePageHelper.enterPage(seleniumUtil, HomePage.HP_TEXT_USERINFO);
		HomePageHelper.enterPage(seleniumUtil, HomePage.HP_LINK_EXIT);
		HomePageHelper.waitHomePageToLoad(timeOut, seleniumUtil);
		HomePageHelper.enterPage(seleniumUtil, HomePage.HP_BUTTON_LOGIN);
		LoginPageHelper.login(seleniumUtil, username,modifyPassword);
		LoginPageHelper.checkUserInfo(timeOut, sleepTime, seleniumUtil, username);
		
		
		
	}
	
	/**检查用户的认证状态*/
	public static void checkUserAttestStatus(SeleniumUtil seleniumUtil,String attestStatus){
		switch(attestStatus.toLowerCase()){
		
		case "attested":
			seleniumUtil.isTextCorrect(seleniumUtil.getText(HomePage.HP_LINK_STATUS), "已认证 |");
				break;
				
		case "attesting":
			seleniumUtil.isTextCorrect(seleniumUtil.getText(HomePage.HP_LINK_STATUS), "认证审核中 |");
				break;
			
		case "unattested":
				seleniumUtil.isTextCorrect(seleniumUtil.getText(HomePage.HP_LINK_STATUS), "未认证 |");
				break;
		case "attest reject":
			seleniumUtil.isTextCorrect(seleniumUtil.getText(HomePage.HP_LINK_STATUS), "认证未通过 |");
			break;
		
		
		
		
		}
		
		
	}
	

}
