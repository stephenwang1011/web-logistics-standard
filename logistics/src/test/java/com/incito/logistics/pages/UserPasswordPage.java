package com.incito.logistics.pages;

import org.openqa.selenium.By;

/**
 * 定义“修改密码”页面基本元素
 *
 */
public class UserPasswordPage {
	/**修改密码 按钮*/
	public static final By USP_BUTTON_CHANGEPASSWD = By.xpath("//*[@class='myInfo-left']/li[3]");
	/**用户名*/
	public static final By USP_TEXT_USERNAME = By.xpath("//*[@class='form-group']/span");
	/**当前密码*/
	public static final By USP_INPUT_OLDPASSWD = By.id("opwd");
	/**新密码*/
	public static final By USP_INPUT_NEWPASSWD = By.id("npwd1");
	/**确认密码*/
	public static final By USP_INPUT_REPASSWD = By.id("npwd2");
	/**提交按钮*/
	public static final By USP_BUTTON_OK = By.xpath("//*[@type='submit']");


}
