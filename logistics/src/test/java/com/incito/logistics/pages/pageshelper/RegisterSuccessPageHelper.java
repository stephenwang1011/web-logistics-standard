package com.incito.logistics.pages.pageshelper;

import org.openqa.selenium.By;

import com.incito.logistics.pages.RegisterSuccessPage;
import com.incito.logistics.util.SeleniumUtil;

public class RegisterSuccessPageHelper {
	
	public static void enterPage(SeleniumUtil seleniumUtil,By by){
		seleniumUtil.click(seleniumUtil.findElementBy(by));

	}
	
	
	public static void waitForRegisterSuccessPageToLoad(SeleniumUtil seleniumUtil,int timeOut){
		
		seleniumUtil.waitForElementToLoad(timeOut, RegisterSuccessPage.RSP_BUTTON_ATTESTINFO);
		seleniumUtil.waitForElementToLoad(timeOut, RegisterSuccessPage.RSP_BUTTON_GOHOME);
		seleniumUtil.waitForElementToLoad(timeOut, RegisterSuccessPage.RSP_TEXT_PROMPT);
		seleniumUtil.waitForElementToLoad(timeOut, RegisterSuccessPage.RSP_TEXT_SUCCESSTITLE);
	}

	
	public static void checkRegisterSuccessPageText(SeleniumUtil seleniumUtil,int timeOut){
		
	seleniumUtil.isTextCorrect(seleniumUtil.getText(RegisterSuccessPage.RSP_BUTTON_ATTESTINFO), "认证个人信息");
	seleniumUtil.isTextCorrect(seleniumUtil.getText(RegisterSuccessPage.RSP_BUTTON_GOHOME), "去首页");
	seleniumUtil.isTextCorrect(seleniumUtil.getText(RegisterSuccessPage.RSP_TEXT_SUCCESSTITLE), "恭喜您注册成功！");
	seleniumUtil.isTextCorrect(seleniumUtil.getText(RegisterSuccessPage.RSP_TEXT_PROMPT).trim(), "您现在可以继续完善个人资料，进行信息认证，通过认证后，发布的货源更加真实可信，货源成交更及时。您也可以稍后再做个人信息认证，直接去首页查看公共车源和货源。");
	
	}
}
