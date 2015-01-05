package com.incito.logistics.pages;

import org.openqa.selenium.By;

/**
 * 定义“基本信息”页面基本元素
 *
 */
public class UserBaseInfoPage {
	/** 基本信息tab栏 */
	public static final By UBIP_TAB_BASEINFO = By.xpath("//*[@class='myInfo-left']/li[1]");
	/** 用户的基本信息 */
	public static final By UBIP_TEXT_BASEINFO = By.xpath("//*[@class='myInfo-left']");
	/** 用户名 */
	public static final By BUIP_TEXT_NAME = By.xpath("//*[@class='myInfo-right-content myInfo-right-contentUpd']/div[1]");
	/** 右上角的用户名（已认证右边的用户名） */
	public static final By BUIP_TEXT_NAME_R = By.xpath("//*[@class='dropdown-toggle text-primary']");
	/** 修改按钮 */
	public static final By BUIP_BUTTON_REVISE = By.xpath("//*[@class='btn btn-major']");
}
