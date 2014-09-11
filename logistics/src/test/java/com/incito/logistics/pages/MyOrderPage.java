package com.incito.logistics.pages;

/**
 * 我的订单页面元素声明
 * */
import org.openqa.selenium.By;

public class MyOrderPage {
	// 声明常量 我的订单中 顶部分类：“近三个月订单。。。。。。”
	public static final String NAVTYPE = "navType";
	/** 订单编号输入框 */
	public static final By MOP_INPUT__ORDERNO = By.name("orderNo");
	/** 订单开始时间 */
	public static final By MOP_INPUT_STARTDATE = By.name("startime");
	/** 订单结束时间 */
	public static final By MOP_INPUT_ENDDATE = By.name("endtime");

	/** 搜索按钮 */
	public static final By MOP_BUTTON_SEARCH = By.xpath("//*[@id='myorderform']/div/input[1]");

	/** 顶部筛选订单的分类:一共11个 */
	public static final By MOP_TEXT_TABS = By.id(NAVTYPE);

}
