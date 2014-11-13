package com.incito.logistics.pages;

import org.openqa.selenium.By;

/**
 * 找货源页面所有元素定位
 * */
public class FindGoodsPage {
	//********以下元素是“公共货源”和“我的收藏”的tab*************************************
	/** 公共货源按钮 */
	public static final By FGP_BUTTON_PUBLICDOODS = By.linkText("公共货源");
	/** 我的收藏按钮 */
	public static final By FGP_BUTTON_MYFAVORITES = By.linkText("我的收藏");
	
	//********以下元素是“搜索”选项的查找元素*************************************
	/** 发货地文本框 */
	public static final By FGP_INPUT_FROMCITY = By.id("carcity");
	/** 收货地地文本框 */
	public static final By FGP_INPUT_TARGETCITY = By.id("targetcity");
	/** 车长开始输入文本框 */
	public static final By FGP_INPUT_STARTCARLONG = By.name("startcarlong");
	/** 车长结束输入文本框 */
	public static final By FGP_INPUT_ENDTCARLONG = By.name("endcarlong");
	/** 搜索按钮 */
	public static final By FGP_BUTTON_SEARCH = By.xpath("//*[@id='goodsform']/div[2]/div[5]/button[1]");
	/** 高级搜索按钮 */
	public static final By FGP_BUTTON_ADVANCESEARCH = By.id("advancedBtn");
	/** 车型要求文本框 */
	public static final By FGP_INPUT_CARTYPE = By.name("fitcartypes");
	/** 货物名称文本框 */
	public static final By FGP_INPUT_GOODSNAME = By.name("goodsnames");
	/**单位-体积还是重量*/
	public static final By FGP_SELECT_GOODSUNIT = By.id("wvSwitch");
	/**开始吨位文本框*/
	public static final By FGP_INPUT_STARTWEIGHT = By.name("startweight");
	/**结束吨位文本框*/
	public static final By FGP_INPUT_ENDWEIGHT = By.name("endweight");
	/**开始体积文本框*/
	public static final By FGP_INPUT_STARTVOLUME = By.name("startvolume");
	/**结束体积文本框*/
	public static final By FGP_INPUT_ENDVOLUME = By.name("endvolume");
	
	//********以下元素是搜索之后的结果*******************************************
	/** 搜索之后的第一排信息（起始地到目的地） */
	public static final By FGP_DISPLAY_SEARCH = By.className("goods-infobox");
	/** 搜索之后,地址下方的第二排信息*/
	public static final By FGP_SECOND_INFO = By.xpath("//*[@class='goods-infobox']");
	/** 搜索之后,地址下方的第二排车辆长度信息*/
	public static final By FGP_SECOND_INFO_CAR_LENGTH = By.cssSelector("div.goods-info-row2");
	/** 搜索无结果提示语 */
	public static final By FGP_NODIAPALY_SEARCH = By.xpath("//label[text()='没有搜索到相应的数据']");
}
