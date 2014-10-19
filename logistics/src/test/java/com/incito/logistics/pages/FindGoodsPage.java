package com.incito.logistics.pages;

import org.openqa.selenium.By;

/**
 * 找货源页面所有元素定位
 * */
public class FindGoodsPage {

	/** 公共货源按钮 */
	public static final By FGP_BUTTON_PUBLICDOODS = By.xpath("//*[@class='active']");
	/** 我的收藏按钮 */
	public static final By FGP_BUTTON_MYFAVORITES = By.xpath("//*[text()='我的收藏']");
	/** 发货地文本框 */
	public static final By FGP_INPUT_FROMCITY = By.id("carcity");
	/** 收货地地文本框 */
	public static final By FGP_INPUT_TARGETCITY = By.id("targetcity");
}
