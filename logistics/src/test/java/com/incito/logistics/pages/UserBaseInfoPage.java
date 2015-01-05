package com.incito.logistics.pages;

import org.openqa.selenium.By;

/**
 * 定义“基本信息”页面基本元素
 *
 */
public class UserBaseInfoPage {
	/** 基本信息tab栏 */
	public static final By UBIP_TAB_BASEINFO = By.xpath("//*[@class='myInfo-left']/li[1]");
	/** 基本信息标题栏 */
	public static final By UBIP_TITLE_USERINFO = By.className("myInfo-right-title");
	/** 用户的基本信息 */
	public static final By UBIP_TEXT_BASEINFO = By.xpath("//*[@class='myInfo-left']");
	/** 基本信息中的用户名 */
	public static final By BUIP_TEXT_NAME = By.xpath("//*[@class='myInfo-right-content myInfo-right-contentUpd']/div[1]/div");
	/** 右上角的用户名（已认证右边的用户名） */
	public static final By BUIP_TEXT_NAME_R = By.xpath("//*[@class='dropdown-toggle text-primary']");
	/** 基本信息中用户的信息的提示语，包括有：用户名、用户头像、姓名、性别、生日、QQ、邮箱 */
	public static final By BUIP_TEXT_USERINFO = By.cssSelector("label.col-xs-2");
	/** 用户的性别值 */
	public static final By BUIP_TEXT_USER_SEX = By.xpath("//*[@class='myInfo-right-content myInfo-right-contentUpd']/div[4]/div/span");
	/** 用户的生日值 */
	public static final By BUIP_TEXT_USER_BIRTHDAY = By.xpath("//*[@class='myInfo-right-content myInfo-right-contentUpd']/div[5]/div");
	/** 用户的QQ值 */
	public static final By BUIP_TEXT_USER_QQ = By.xpath("//*[@class='myInfo-right-content myInfo-right-contentUpd']/div[6]/span");
	/** 用户的邮箱值 */
	public static final By BUIP_TEXT_USER_EMAIL = By.xpath("//*[@class='myInfo-right-content myInfo-right-contentUpd']/div[7]/span");

	/** 修改按钮 */
	public static final By BUIP_BUTTON_REVISE = By.xpath("//*[@class='btn btn-major']");
	// ******************修改页面中的元素**********************************************
	/** 修改基本信息中的用户名 */
	public static final By BUIP_TEXT_NAME_REVISE = By.xpath("//*[@class='myInfo-right-content']/div[1]/div");
	/** 修改基本信息中的性别：男 */
	public static final By BUIP_INPUT_SEX_MAN_REVISE = By.xpath("//*[@name='sex' and @value='m']");
	/** 修改基本信息中的性别：女 */
	public static final By BUIP_INPUT_SEX_FEMALE_REVISE = By.xpath("//*[@name='sex' and @value='f']");
	/** 修改基本信息中的生日 */
	public static final By BUIP_INPUT_BIRTHDAY_REVISE = By.name("birthday");
	/** 修改基本信息中的QQ */
	public static final By BUIP_INPUT_QQ_REVISE = By.name("qq");
	/** 修改基本信息中的邮箱 */
	public static final By BUIP_INPUT_EMAIL_REVISE = By.name("email");
	/** 修改基本信息中的保存 */
	public static final By BUIP_BUTTON_SAVE = By.xpath("//*[@class='btn btn-major' and @type='submit']");
	/** 修改基本信息中的取消 */
	public static final By BUIP_BUTTON_CANCEL = By.xpath("//*[@class='btn btn-white']");
}
