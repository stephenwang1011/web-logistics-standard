package com.incito.logistics.pages;
import org.openqa.selenium.By;
/**
 * 定义首页页面元素
 * 
 * */
public class HomePage {
	/**首页登陆按钮*/
	public static final By HP_BUTTON_LOGIN = By.id("login");
	/**首页注册按钮*/
	public static final By HP_BUTTON_REG = By.linkText("注册");
	/**首页登陆上的退出按钮*/
	public static final By HP_BUTTON_EXIT= By.linkText("退出");
	/** 首页几个tab：首页，个人中心，我的货源，我的订单....*/
	public static final By HP_LINK_HOME = By.linkText("首页");
//	public static final By HP_LINK_PERSONCEN = By.linkText("个人中心");
	public static final By HP_LINK_FINDCARDS= By.linkText("找车源");
	public static final By HP_LINK_FINDGOODS= By.linkText("找货源");
	public static final By HP_LINK_MYORDER = By.linkText("我的订单");
	public static final By HP_LINK_MYGOODS = By.linkText("我的货源");
	public static final By HP_LINK_MYCARDS= By.linkText("我的车队");
	
	/** 首页上的 免费发布货源 按钮*/
	public static final By HP_BUTTON_FREESEND = By.linkText("免费发布货源");
	/**首页上：物流跟踪 tab*/
	public static final By HP_TAB_TRACKGOODS = By.linkText("物流跟踪");
	/**首页上：找车源 tab*/
	public static final By HP_TAB_FINDCARS = By.linkText("找车源");
	/**首页上的《物流跟踪》中的订单号输入框*/
	public static final By HP_INPUT_ORDERNO= By.id("orderno");
	/**首页上的《物流跟踪》上的查询按钮*/
	public static final By HP_BUTTON_SEARCH1= By.xpath("//*[@id='findOrderForm']/div[2]/button");
	/**首页上的《找车源》上的出发地*/
	public static final By HP_INPUT_FROMCITY= By.id("carcity");
	/**首页上的《找车源》上的出发地*/
	public static final By HP_INPUT_TOCITY= By.id("targetcity");
	/**首页上的《找车源》上的查询按钮*/
	public static final By HP_BUTTON_SEARCH2= By.id("Fcar");
	/**登陆成功之后 用户名 区域*/
	public static final By HP_TEXT_USERINFO = By.className("dropdown");
	/**左上角的商标文字*/
	public static final By HP_LEFT_TITLE = By.className("navbar-left");
	/**首页上的换一批 2个*/
	//public static final By HP_LINK_CHANGEANOTHER = By.linkText("换一批");
	/**底部footer文字*/
	public static final By HP_TEXT_FOOTER = By.xpath("//*[@id='holder']/footer");
	/**首页上的更多按钮*/
	public static final By HP_LINK_MORE = By.linkText("更多>>");
	/**首页上公共车源 上的第一个车源 */
	public static final By HP_AREAR_CARS1 = By.xpath("//*[@id='carList']/div[1]");
	/**首页上公共车源的第一个车源上的收藏按钮*/
	public static final By HP_CARS1_FAV = By.xpath("//*[@id='carList']/div[1]/div[3]/img");
	/**首页上公共车源的第一个车源上的定位按钮*/
	public static final By HP_CARS1_LOC= By.xpath("//*[@id='carList']/div[1]/div[2]/img");
	/**首页顶部日期*/
	public static final By HP_TEXT_DATE = By.id("currentTimeDiv");
	/**首页中的frame*/
	public static final By HP_FRAME = By.xpath("//iframe");
	/**首页顶部城市*/
	public static final By HP_TEXT_CITY = By.id("city");
	/**首页顶部天气*/
	public static final By HP_TEXT_WEATHER = By.id("wea-items");
	
	/**公共货源上的一个货源*/
	public static final By HP_ARERA_GOODS1 = By.xpath("//*[@id='goodsList']/div[1]");
	/**首页上公共货源的第一个货源上的收藏按钮*/
	public static final By HP_GOODS1_FAV = By.xpath("//*[@id='goodsList']/*/div[2]/img");
	/**公共车源标题*/
	public static final  By HP_TITLE_PUBLICCARS = By.xpath("//*[@id='body']/div[2]/div");
	/**公共货源标题*/
	public static final By HP_TITLE_PUBLICGOODS = By.xpath("//*[@id='body']/div[4]/div");
	
	
	

	

}
