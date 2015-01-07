package com.incito.logistics.pages;

import org.openqa.selenium.By;

/**
 * 定义完善用户信息页面元素
 * 
 * */
public class UserAttestedInfoPage {
	/** 姓名输入框 */
	public static final By UAIP_INPUT_NAME = By.name("name");
	/** 联系电话输入框 */
	public static final By UAIP_INPUT_TEL = By.name("tel");
	/** 图形码输入框 */
	public static final By UAIP_INPUT_PHOTO = By.id("pic_validcode");
	/** 短信验证码输入框 */
	public static final By UAIP_INPUT_CHIT = By.id("code");
	/** 发送验证码至手机 */
	public static final By UAIP_BUTTON_CHIT = By.id("btn_code");
	/** 公司名称输入框 */
	public static final By UAIP_INPUT_COMPANY = By.name("company");
	/** 身份证输入框 */
	public static final By UAIP_INPUT_IDCARD = By.name("icard");
	/** 公司地址：“省”下拉列表 */
	public static final By UAIP_SELECT_PROVINCE = By.id("province");
	/** 公司地址：“市”下拉列表 */
	public static final By UAIP_SELECT_CITY = By.id("city");
	/** 公司地址：“区/县”下拉列表 */
	public static final By UAIP_SELECT_REGION = By.id("region");
	/** 公司地址：“街道地址”文本框 */
	public static final By UAIP_INPUT_ADDRESS = By.id("address");
	/** 上传图片按钮 */
	public static final By UAIP_INPUT_UPLOAD = By.xpath("//span[@class='btn default btn-file']");
	/** 提交按钮 */
	public static final By UAIP_BUTTON_SUBMIT = By.xpath("//button[text()='提 交']");
	/** 返回按钮 */
	public static final By UAIP_BUTTON_BACK = By.xpath("//button[text()='返 回']");
	/** 顶部title：认证信息 */
	public static final By UAIP_TEXT_TITLE = By.className("myInfo-right-title");
	/** 认证信息说明 */
	public static final By UAIP_TEXT_TITLE_DES = By.className("myInfo-auth-tip");
	/** 姓名错误提示语： */
	public static final By UAIP_INPUT_NAME_PROMPT = By.id("name_tip");
	/** 联系电话错误提示语： */
	public static final By UAIP_INPUT_TEL_PROMPT = By.id("tel_tip");
	/** 身份证错误提示语： */
	public static final By UAIP_INPUT_IDCARD_PROMPT = By.id("idcard_tip");
	/** 公司名称错误提示语： */
	public static final By UAIP_INPUT_COMPANY_PROMPT = By.id("");// 公司名称提示语没有
	/** 公司地址错误提示语： */
	public static final By UAIP_INPUT_ADDRESS_PROMPT = By.id("address_tip");
	/** 完成信息成功弹出框提示语 */
	public static final By UAIP_POPUP_TRUE = By.xpath("//label[text()='您已成功提交个人信息，我们将在24小时内完成审核，您可以先发货了！如需优先认证，请致电']");
	/** 完成信息成功弹出框下方确定按钮 */
	public static final By UAIP_BUTTON_CONFIRM = By.xpath("//*[@id='authenticating']/div/div/div/div/button");
	// **********************新改版页面元素，未认证状态，我是分割线进行隔开********************************
	/** 认证信息tab栏 */
	public static final By UAIP_USERINFO_TAB = By.xpath("//*[@class='myInfo-left']/li[2]");
	/** 输入文本框左边文本说明，包括有：姓名、联系电话、输入验证码、身份证号、公司名称、公司地址、证件照片 */
	public static final By UAIP_TEXT_DES = By.xpath("//*[@class='col-xs-2 myInfo-control-label']");
	/** 发送验证码至手机 */
	public static final By UAIP_TEL_PROVING = By.id("btn_code");
	//***********************新改版页面元素,“认证审核中”，我是分割线进行隔开*********************************************
	/** 认证审核中，认证说明：“您的资料正在审核中，请耐心等待！” */
	public static final By UAIP_TEXT_NOTE_ATTESTING = By.className("myInfo-auth-progCont");
	/** 认证审核中，认证项目，包括有：姓名、联系电话、身份证号、公司名称、公司地址、证件照片 */
	public static final By UAIP_TEXT_INFO_ATTESTING = By.xpath("//div[@class='form-group row']/label");
	/** 认证审核中，认证项目，包括有：姓名、联系电话、身份证号、公司名称、公司地址、证件照片 */
	public static final By UAIP_TEXT_CONTACT_ATTESTING = By.xpath("//div[@class='myInfo-tip mt50 mb50']");
	//***********************新改版页面元素,“已认证”，我是分割线进行隔开*********************************************
	/** 已认证，认证说明：“您的资料已通过认证！” */
	public static final By UAIP_TEXT_NOTE1_ATTESTED = By.className("myInfo-auth-progCont");
	/** 已认证，认证说明：“恭喜您认证成功，现在您可以发布已认证的货源，货源信息更加可靠，司机会更加快速的找到您！” */
	public static final By UAIP_TEXT_NOTE2_ATTESTED = By.className("myInfo-auth-progContD");
	/** 已认证，底部修改按钮 */
	public static final By UAIP_BUTTON_MODIFY = By.xpath("//button[@class='btn btn-major']");
	/** 已认证，修改界面中，认证项目，包括有：姓名、联系电话、身份证号、公司名称、公司地址、证件照片 */
	public static final By UAIP_TEXT_INFO_ATTESTED = By.xpath("//div[@class='form-group']/label");
	/** 已认证，修改界面中，认证项目，包括有：姓名、联系电话、身份证号、公司名称、公司地址、证件照片 */
	public static final By UAIP_INPUT_PASSWORD = By.id("password");

	
	
}
