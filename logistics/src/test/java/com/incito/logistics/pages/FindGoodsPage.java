package com.incito.logistics.pages;

import org.openqa.selenium.By;

/**
 * 找货源页面所有元素定位
 * */
public class FindGoodsPage {

	/** 公共货源按钮 */
	public static final By FGP_BUTTON_PUBLICDOODS = By.linkText("公共货源");
	/** 我的收藏按钮 */
	public static final By FGP_BUTTON_MYFAVORITES = By.linkText("我的收藏");
	/** 发货地文本框 */
	public static final By FGP_INPUT_FROMCITY = By.id("carcity");
	/** 收货地地文本框 */
	public static final By FGP_INPUT_TARGETCITY = By.id("targetcity");
	/** 车长开始输入文本框 */
	public static final By FGP_INPUT_STARTCARLONG = By.name("startcarlong");
	/** 车长结束输入文本框 */
	public static final By FGP_INPUT_ENDTCARLONG = By.name("endcarlong");
	/** 搜索按钮 */
	public static final By FGP_BUTTON_SEARCH = By.className("btn btn-major");
	/** 高级搜索按钮 */
	public static final By FGP_BUTTON_ADVANCESEARCH = By.id("btn btn-major");
}
