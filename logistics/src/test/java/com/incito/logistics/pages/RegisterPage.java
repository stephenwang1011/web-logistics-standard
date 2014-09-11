package com.incito.logistics.pages;

import org.openqa.selenium.By;

/**
 * 声明登陆界面页面元素
 * 
 * */
public class RegisterPage {
	/** 注册页面上的用户名 */
	public static final By RP_INPUT_USERNAME = By.id("username");
	/** 注册页面上的密码 */
	public static final By RP_INPUT_PASSWD = By.id("pwd1");
	/** 注册页面上的确认密码 */
	public static final By RP_INPUT_REPASSWD = By.id("pwd2");
	/** 注册页面上的注册按钮 */
	public static final By RP_BUTTON_REGISTER = By.xpath("//*[text()='注册']");
	/** 注册页面上的返回按钮 */
	public static final By RP_BUTTON_BACK = By.xpath("//*[text()='返回']");

}
