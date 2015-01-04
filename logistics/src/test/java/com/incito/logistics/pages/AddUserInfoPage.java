package com.incito.logistics.pages;

import org.openqa.selenium.By;

/**
 * 定义完善用户信息页面元素
 * 
 * */
public class AddUserInfoPage {
	/** 姓名输入框 */
	public static final By AUIP_INPUT_NAME = By.name("name");
	/** 联系电话输入框 */
	public static final By AUIP_INPUT_TEL = By.name("tel");
	/** 公司名称输入框 */
	public static final By AUIP_INPUT_COMPANY = By.name("company");
	/** 身份证输入框 */
	public static final By AUIP_INPUT_IDCARD = By.name("icard");
	/** 公司地址：“省”下拉列表 */
	public static final By AUIP_SELECT_PROVINCE = By.id("province");
	/** 公司地址：“市”下拉列表 */
	public static final By AUIP_SELECT_CITY = By.id("city");
	/** 公司地址：“区/县”下拉列表 */
	public static final By AUIP_SELECT_REGION = By.id("region");
	/** 公司地址：“街道地址”文本框 */
	public static final By AUIP_INPUT_ADDRESS = By.id("address");
	/** 上传图片按钮 */
	public static final By AUIP_INPUT_UPLOAD = By.className("fileinput-new");
	/** 提交按钮 */
	public static final By AUIP_BUTTON_SUBMIT = By.xpath("//button[text()='提 交']");
	/** 返回按钮 */
	public static final By AUIP_BUTTON_BACK = By.xpath("//button[text()='返 回']");
	/** 顶部title：认证信息 */
	public static final By AUIP_TEXT_TITLE = By.className("myInfo-right-title");
	/** 认证信息说明 */
	public static final By AUIP_TEXT_TITLE_DES = By.className("myInfo-auth-tip");
	/** 姓名错误提示语： */
	public static final By AUIP_INPUT_NAME_PROMPT = By.id("name_tip");
	/** 联系电话错误提示语： */
	public static final By AUIP_INPUT_TEL_PROMPT = By.id("tel_tip");
	/** 身份证错误提示语： */
	public static final By AUIP_INPUT_IDCARD_PROMPT = By.id("idcard_tip");
	/** 公司名称错误提示语： */
	public static final By AUIP_INPUT_COMPANY_PROMPT = By.id("");// 公司名称提示语没有
	/** 公司地址错误提示语： */
	public static final By AUIP_INPUT_ADDRESS_PROMPT = By.id("address_tip");
	/** 完成信息成功弹出框提示语 */
	public static final By AUIP_POPUP_TRUE = By.xpath("//label[text()='您已成功提交个人信息，我们将在24小时内完成审核，您可以先发货了！如需优先认证，请致电']");
	/** 完成信息成功弹出框下方确定按钮 */
	public static final By AUIP_BUTTON_CONFIRM = By.xpath("//*[@id='authenticating']/div/div/div/div/button");
	// **********************新改版页面元素，我是分割线进行隔开********************************
	/** 认证信息tab栏 */
	public static final By AUIP_USERINFO_TAB = By.xpath("//*[@class='myInfo-left']/li[2]");
	/** 输入文本框左边文本说明，包括有：姓名、联系电话、输入验证码、身份证号、公司名称、公司地址、证件照片 */
	public static final By AUIP_TEXT_DES = By.xpath("//*[@class='col-xs-2 myInfo-control-label']");
	/** 发送验证码至手机 */
	public static final By AUIP_TEL_PROVING = By.id("btn_code");
}
