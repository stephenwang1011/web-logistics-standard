package com.incito.logistics.pages;

import org.openqa.selenium.By;

/**
 * 定义首页页面元素
 * 
 * */
public class MyOrdersPage {
	/**我的订单页面 - 发货地输入框*/
	public static final By MOP_INPUT_FROM = By.name("originalcity");
	/**我的订单页面 - 收货地输入框*/
	public static final By MOP_INPUT_TO = By.name("receiptcity");
	/**我的订单页面 - 订单开始时间*/
	public static final By MOP_INPUT_STARTTIME = By.name("startime");
	/**我的订单页面 - 订单结束时间*/
	public static final By MOP_INPUT_ENDTIME = By.name("endtime");
	/**我的订单页面 - 搜索*/
	public static final By MOP_BUTTON_SEARCH = By.id("search_submit_btn");
	/**我的订单页面 - 高级搜索*/
	public static final By MOP_BUTTON_ADSEARCH = By.id("advanced_search_btn");
	/**我的订单页面 - 导航区*/
	public static final By MOP_SPAN_TABS = By.cssSelector("div.in-sortbox");
	

}