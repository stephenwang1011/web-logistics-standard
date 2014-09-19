package com.incito.logistics.pages;

import org.openqa.selenium.By;

/**
 * 定义首页页面元素
 * 
 * */
public class HomePage {
	/** 首页登陆按钮 */
	public static final By HP_BUTTON_LOGIN = By.id("login");
	/** 首页注册按钮 */
	public static final By HP_BUTTON_REG = By.linkText("注册");
	/** 首页登陆上的退出按钮 */
	public static final By HP_BUTTON_EXIT = By.linkText("退出");
	/** tab首页 */
	public static final By HP_LINK_HOME = By.linkText("首页");
	/** tab找车源 */
	public static final By HP_LINK_FINDCARDS = By.linkText("找车源");
	/** tab找货源 */
	public static final By HP_LINK_FINDGOODS = By.linkText("找货源");
	/** tab我的订单 */
	public static final By HP_LINK_MYORDER = By.linkText("我的订单");
	/** 我的货源 */
	public static final By HP_LINK_MYGOODS = By.linkText("我的货源");

	/** 首页上的 免费发布货源 按钮 */
	public static final By HP_BUTTON_FREESEND = By.linkText("免费发布货源");
	/** 首页上：物流跟踪 tab */
	public static final By HP_TAB_TRACKGOODS = By.linkText("物流跟踪");
	/** 首页上：找车源 tab */
	public static final By HP_TAB_FINDCARS = By.linkText("找车源");
	/** 首页上的《物流跟踪》中的订单号输入框 */
	public static final By HP_INPUT_ORDERNO = By.id("orderno");
	/** 首页上的《物流跟踪》上的查询按钮 */
	public static final By HP_BUTTON_SEARCH1 = By.xpath("//*[@id='findOrderForm']/div[2]/button");
	/** 首页上的《找车源》上的出发地 */
	public static final By HP_INPUT_FROMCITY = By.id("carcity");
	/** 首页上的《找车源》上的出发地 */
	public static final By HP_INPUT_TOCITY = By.id("targetcity");
	/** 首页上的《找车源》上的查询按钮 */
	public static final By HP_BUTTON_SEARCH2 = By.id("Fcar");
	/** 登陆成功之后 用户名 区域 */
	public static final By HP_TEXT_USERINFO = By.className("dropdown");
	/** 左上角的商标文字 */
	public static final By HP_LEFT_TITLE = By.className("navbar-left");
	/** 底部footer文字 */
	public static final By HP_TEXT_FOOTER = By.className("in-footer");
	/**
	 * 公共车源和公共和货源 每个小模块<br>
	 * 通过findByElements 拆分:<br>
	 * 前8个是 公共货源的 数据，后八个是公共车源的数据<br>
	 * */
	public static final By HP_ARERA_CARDSANDGOODS = By.xpath("//*[@class='index-infobox']");
	/** 公共车源或者公共货源 上的收藏按钮 */
	public static final By HP_BUTTON_FAV = By.xpath("//*[text()='收藏']");
	/** 公共货源上的定位按钮 */
	public static final By HP_BUTTON_LOC = By.xpath("//*[text()='定位']");
	/** 首页顶部日期 */
	public static final By HP_TEXT_DATE = By.id("currentTimeDiv");
	/** 首页中的frame */
	public static final By HP_FRAME = By.xpath("//iframe");
	/** 首页顶部城市 */
	public static final By HP_TEXT_CITY = By.id("city");
	/** 首页顶部天气 */
	public static final By HP_TEXT_WEATHER = By.id("wea-items");
	/** 关于我们链接 */
	public static final By HP_LINK_ABOUT = By.xpath("//[text()='关于我们']");
	/** 关于我们链接 */
	public static final By HP_LINK_ABOUTUS = By.xpath("//[text()='关于我们']");
	/** 联系我们链接 */
	public static final By HP_LINK_CONTACTUS = By.xpath("//[text()='联系我们']");
	/** 联系我们链接 */
	public static final By HP_LINK_HELP = By.xpath("//[text()='帮助中心']");
	/** 两个 更多>> */
	public static final By HP_LINK_MORE = By.xpath("	//*[text()='更多>>']");
	


}
