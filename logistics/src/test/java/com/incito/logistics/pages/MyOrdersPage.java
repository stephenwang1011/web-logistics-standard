package com.incito.logistics.pages;

import org.openqa.selenium.By;

/**
 * 定义首页页面元素
 * 
 * */
public class MyOrdersPage {
	//以下是搜索及高级搜索的条件****************************************************
	/**我的订单页面 - 发货地输入框*/
	public static final By MOP_INPUT_FROM = By.name("originalcity");
	/**我的订单页面 - 收货地输入框*/
	public static final By MOP_INPUT_TO = By.name("receiptcity");
	/**我的订单页面 - 订单开始时间*/
	public static final By MOP_INPUT_STARTTIME = By.name("startime");
	/**我的订单页面 - 订单结束时间*/
	public static final By MOP_INPUT_ENDTIME = By.name("endtime");
	/**我的订单页面 高级搜索条件输入框 - 订单编号*/
	public static final By MOP_INPUT_ORDERNO = By.name("orderNo");
	/**我的订单页面 高级搜索条件输入框 - 承运司机*/
	public static final By MOP_INPUT_DRIVER = By.name("drivername");
	/**我的订单页面 高级搜索条件输入框 - 收货人*/
	public static final By MOP_INPUT_RECEIVER = By.name("consigneename");
	/**我的订单页面 高级搜索条件输入框 - 收获公司*/
	public static final By MOP_INPUT_HARVESTCOMPANY = By.name("company");
	/**我的订单页面 - 搜索*/
	public static final By MOP_BUTTON_SEARCH = By.id("search_submit_btn");
	/**我的订单页面 - 高级搜索*/
	public static final By MOP_BUTTON_ADSEARCH = By.id("advanced_search_btn");
	/**我的订单页面 - 导航区*/
	public static final By MOP_SPAN_TABS = By.cssSelector("div.in-sortbox");
	
	//以下是我的订单中详情****************************************************
	/**我的订单页面 高级搜索条件输入框 - 订单号*/
	public static final By MOP_TEXT_NOINFO = By.linkText("没有搜索到相应的数据");
	/**我的订单页面 订单的数目：只含有货物信息*/
	public static final By MOP_TEXT_ORDERSINFOES = By.className("order-info");
	/**我的订单页面 订单的详情的订单编号*/
	public static final By MOP_TEXT_ORDERNO = By.className("order-no");
	/**我的订单页面 订单收货地址*/
	public static final By MOP_TEXT_ADDRESS = By.cssSelector("span.in-city-highlight");
	/**我的订单页面 订单的详情的订单时间*/
	public static final By MOP_TEXT_ORDERDATE = By.cssSelector("span.order-time");
	/**我的订单页面 隐藏司机的姓名*/
	public static final By MOP_TEXT_ORDERDRIVERNAME = By.cssSelector("div.order-infobox");
	

}
