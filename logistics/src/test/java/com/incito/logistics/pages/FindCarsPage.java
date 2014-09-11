package com.incito.logistics.pages;

/**
 * 找车源的页面元素声明
 * */
import org.openqa.selenium.By;

public class FindCarsPage {
	/** 线路方向 出发地 */
	public static final By FCP_INPUT_FROM = By.id("carcity");
	/** 线路方向 目的地 */
	public static final By FCP_INPUT_TO = By.id("targetcity");
	/** 搜索按钮 */
	public static final By FCP_BUTTON_SEARCH = By.xpath("//div[4]/a");
	/** 开始车厂 */
	public static final By FCP_INPUT_STARTCARLEN = By.name("startcarlong");
	/** 结束车厂 */
	public static final By FCP_INPUT_ENDCARLEN = By.name("endcarlong");
	/** 开始重量 */
	public static final By FCP_INPUT_STARTWEIGHT = By.name("startweight");
	/** 结束重量 */
	public static final By FCP_INPUT_ENDWEIGHT = By.name("endweight");
	/** 按照信用等级排序 */
	public static final By FCP_BUTTON_CREDIT = By.id("carcreditbutton");
	/** 按照车厂排序 */
	public static final By FCP_BUTTON_CARLEN = By.id("carlengthbutton");
	/** 按照剩余载重排序 */
	public static final By FCP_BUTTON_WEIGHT = By.id("carlengthbutton");

}
