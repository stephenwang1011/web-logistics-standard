package com.incito.logistics.pages;

import org.openqa.selenium.By;

/**
 * 注册成功页面元素声明
 * 
 * */
public class RegisterSuccessPage {
	/** 恭喜注册成功 title */
	public static final By RSP_TEXT_SUCCESSTITLE = By.xpath("//*[text()='恭喜您注册成功！']");
	/**注册成功相关提示信息*/
	public static final By RSP_TEXT_PROMPT = By.className("register-prompt");
	/**认证个人信息button*/
	public static final By RSP_BUTTON_ATTESTINFO = By.xpath("//*[text()='认证个人信息']");
	/**去首页button*/		
	public static final By RSP_BUTTON_GOHOME = By.xpath("//*[text()='去首页']");

}
