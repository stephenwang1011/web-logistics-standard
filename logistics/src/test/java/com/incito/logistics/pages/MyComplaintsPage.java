
package com.incito.logistics.pages;

import org.openqa.selenium.By;

/**
 * @author xy-incito-wy
 * @desprition  我的投诉页面元素声明
 * */
public class MyComplaintsPage {
	
	/**tab 我的投诉他人的*/
	public static final By MCP_TAB_COMPLAINTSOTHERS = By.linkText("我投诉他人");
	/**tab 他人投诉我的*/
	public static final By MCP_TAB_OTHERSCOMPLAINTS = By.linkText("他人投诉我");
	
	//以下是我投诉他人页面下的元素
	/**全部分类*/
	public static final By MCP_CHECKBOX_ALL = By.xpath("//*[@value='' and @name='status']");
	/**待对方回复 和  对方已投诉*/
	public static final By MCP_CHECKBOX_ANSWERANDCOMPLAINT = By.xpath("//*[@value='0' and @name='status']");
	/**已回复*/
	public static final By MCP_CHECKBOX_ANSWER = By.xpath("//*[@value='6' and @name='status']");
	/**处理中*/
	public static final By MCP_CHECKBOX_INPROCESS = By.xpath("//*[@value='1' and @name='status']");
	/**已处理*/
	public static final By MCP_CHECKBOX_PROCESSED = By.xpath("//*[@value='2' and @name='status']");
	/**已撤诉*/
	public static final By MCP_CHECKBOX_COMPLAINTSCANCEL = By.xpath("//*[@value='4' and @name='status']");
	
	
	
	
	
	
}
