package com.incito.logistics.pages;
import org.openqa.selenium.By;

/**
 * @Description 发布货源页面上的元素声明
 * @author xy-incito-wy
 * */
public class SendGoodsPage {
	/** 发布货源界面上的货源出发地 */
	public final static By SGP_INPUT_GOODSORIGINALCITY = By.name("originalcity");
	/** 发布货源上的收货地 */
	public final static By SGP_INPUT_GOODSRECEIPTCITY = By.name("receiptcity");
	/** 发布货源界面山的货物名称输入框 */
	public final static By SGP_INPUT_GOODSNAME = By.id("goodsname");
	/**详细货物名称*/
	public final static By SGP_INPUT_GOODSDETAILS = By.id("goodsnamedetail");
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
	public final static By SGP_INPUT_CARLENGTH = By.name("carlength");
	/**车型要求*/
	public final static By SGP_INPUT_CARTYPE = By.name("fitcartype");
	/** 件数 */
	public final static By SGP_INPUT_COUNT = By.id("count");
	/** 运费 */
	public final static By SGP_INPUT_FARE = By.id("fare");
	/** 声明价值 */
	public final static By SGP_INPUT_DECLAREVALUE = By.id("declaredvalue");
	/** 信息费 */
	public final static By SGP_INPUT_INFOFARE = By.id("infofare");
	/** 有效期3天 */
	public final static By SGP_BUTTON_GOODSDATE3 = By.xpath("//*[@name='fetchdate' and @value='3']");
	/** 有效期5天 */
	public final static By SGP_BUTTON_GOODSDATE5 = By.xpath("//*[@name='fetchdate' and @value='5']");
	/** 有效期7天 */
	public final static By SGP_BUTTON_GOODSDATE7 = By.xpath("//*[@name='fetchdate' and @value='7']");
	
	/** 发布按钮 */
	public final static By SGP_BUTTON_SEND = By.xpath("//*[text()='发布']");
	/** 清空按钮 */
	public final static By SGP_BUTTON_RESET = By.xpath("//*[text()='清空']");
	/**货源说明输入框*/
	public final static By SGP_INPUT_INSTRUCTION = By.id("memo");	
	/**发布货源失败以后 发货地的的标示：必填字段*/
	public final static By SGP_TEXT_ORIGINALCITYERROR = By.xpath("//label[@class='error' and @for='originalcity']");
	/**发布货源失败以后 收货地的的标示：必填字段*/
	public final static By SGP_TEXT_RECEIPTCITYERROR = By.xpath("//label[@class='error' and @for='receiptcity']");
	/**发布货源失败以后 货物名称的的标示：必填字段*/
	public final static By SGP_TEXT_GOODSNAMEERROR = By.xpath("//label[@class='error' and @for='goodsname']");
	/**发布货源失败以后 重量的标示：必填字段*/
	public final static By SGP_TEXT_WEIGHTERROR = By.xpath("//label[@class='error' and @for='weight']");
	/**发布货源失败以后 体积的标示：必填字段*/
	public final static By SGP_TEXT_VOLUMEERROR = By.xpath("//label[@class='error' and @for='volume']");
	/**货物的预留的几十个名称*/
	public final static By SGP_TEXT_GOODSNAMECHOICE = By.id("goodsnamechoice");
	/**车型的预留的几十个名称*/
	public final static By SGP_TEXT_CARTYPE = By.xpath("//*[@id='publishForm']/div[4]/div[2]/table");
	/**车长的预留的几十个名称*/
	public final static By SGP_TEXT_CARLENGTH = By.xpath("//*[@id='publishForm']/div[4]/div[1]/table");
	
	
	
	
}
