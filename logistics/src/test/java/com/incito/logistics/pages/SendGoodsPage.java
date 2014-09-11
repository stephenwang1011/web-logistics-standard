package com.incito.logistics.pages;

/**
 * 发布货源页面上的元素声明
 * */
import org.openqa.selenium.By;

public class SendGoodsPage {
	/** 发布货源界面上的货源出发地 */
	public final static By SGP_INPUT_GOODSORIGINALCITY = By.name("originalcity");
	/** 发布货源上的收货地 */
	public final static By SGP_INPUT_GOODSRECEIPTCITY = By.name("receiptcity");
	/** 发布货源界面山的货物名称输入框 */
	public final static By SGP_INPUT_GOODSNAME = By.id("goodsname");
	/** 货物类型:重货 */
	public final static By SGP_BUTTON_HEAVYGOODS = By.id("goodstype1");
	/** 货物类型:设备 */
	public final static By SGP_BUTTON_DEVICEGOODS = By.id("goodstype3");
	/** 货物类型:抛货 */
	public final static By SGP_BUTTON_LIGHTGOODS = By.id("goodstype2");
	/** 重量输入框 */
	public final static By SGP_INPUT_WEIGHT = By.id("weight");
	/** 体积输入框 */
	public final static By SGP_INPUT_VOLUME = By.id("volume");
	/** 车长要求 */
	public final static By SGP_INPUT_CARLENGTH = By.id("carlength");
	/** 件数 */
	public final static By SGP_INPUT_COUNT = By.id("count");
	/** 运费 */
	public final static By SGP_INPUT_FARE = By.id("fare");
	/** 声明价值 */
	public final static By SGP_INPUT_DECLAREVALUE = By.id("declaredvalue");
	/** 信息费 */
	public final static By SGP_INPUT_INFOFARE = By.id("infofare");
	/** 有效期3天 */
	public final static By SGP_BUTTON_THREEDAYS = By.id("fetchdate3");
	/** 有效期5天 */
	public final static By SGP_BUTTON_FIVEDAYS = By.id("fetchdate5");
	/** 有效期7天 */
	public final static By SGP_BUTTON_SEVENDAYS = By.id("fetchdate7");
	/** 发布对象：全部车辆 */
	public final static By SGP_CHECKBOX_ALL = By.id("all_assigncarno");
	/* 发布对象：指定车辆 */
	public static final By SGP_CHECKBOX_ASSIGN = By.id("appoint_assigncarno");
	/** 指定车辆输入框 */
	public static final By SGP_INPUT_ASSIGINCAR = By.id("assigncarno");

}
