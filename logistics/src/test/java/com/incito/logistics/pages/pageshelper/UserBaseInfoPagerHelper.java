package com.incito.logistics.pages.pageshelper;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

import com.incito.logistics.pages.UserBaseInfoPage;
import com.incito.logistics.util.SeleniumUtil;

/**
 * @author xy-incito-wk
 * @description 用户的基本信息帮助类
 * */
public class UserBaseInfoPagerHelper {
	public static Logger logger = Logger.getLogger(UserBaseInfoPagerHelper.class.getName());

	/** 基本信息页面上点击“提交”或者“返回”按钮 */
	public static void enterPage(SeleniumUtil seleniumUtil, By elementLocator) {
		seleniumUtil.click(seleniumUtil.findElementBy(elementLocator));
	}

	/** 基本信息页面元素校验 */
	public static void checkUserInfoPageText(int timeOut, SeleniumUtil seleniumUtil) {
		logger.info("Start checking UserInfo page elements");
		int size = seleniumUtil.findElementsBy(UserBaseInfoPage.BUIP_TEXT_USERINFO).size();
		String tabs[] = { "用户名", "用户头像", "姓名", "性别", "生日", "QQ", "邮箱" };
		for (int i = 0; i < size; i++) {
			String temp = seleniumUtil.findElementsBy(UserBaseInfoPage.BUIP_TEXT_USERINFO).get(i).getText().replaceAll(" ", "");
			temp = temp.substring(0, temp.lastIndexOf("："));
			seleniumUtil.isTextCorrect(temp, tabs[i]);
		}
		logger.info("Check UserInfo page elements completed");
	}

	public static void typeUserBaseInfo(SeleniumUtil seleniumUtil, String... info) {
		// 填充性别男或者女
		if (info[0].equals("男")) {
			enterPage(seleniumUtil, UserBaseInfoPage.BUIP_INPUT_SEX_MAN_REVISE);
		} else if (info[0].equals("女")) {
			enterPage(seleniumUtil, UserBaseInfoPage.BUIP_INPUT_SEX_FEMALE_REVISE);
		}
		// 填充用户的生日
		if (info[1].toString() != "") {
			String birthday = "document.getElementsByName('birthday')[0].setAttribute('value','" + info[1].toString().substring(0, info[1].toString().indexOf(" ")) + "');";
			((JavascriptExecutor) seleniumUtil.driver).executeScript(birthday);
		}
		// 填充用户的QQ
		if (info[2] != "") {
			seleniumUtil.type(seleniumUtil.findElementBy(UserBaseInfoPage.BUIP_INPUT_QQ_REVISE), info[2].toString());
		}
		// 填充用户的邮箱
		if (info[3] != "") {
			seleniumUtil.type(seleniumUtil.findElementBy(UserBaseInfoPage.BUIP_INPUT_EMAIL_REVISE), info[3].toString());
		}
	}

	public static void saveOrCancel(SeleniumUtil seleniumUtil, By elementLocator, boolean flag) {
		seleniumUtil.click(seleniumUtil.findElementBy(elementLocator));
		seleniumUtil.pause(800);
		if (flag) {
			seleniumUtil.switchToPromptedAlertAfterWait(1000).accept();
		} else {
			seleniumUtil.switchToPromptedAlertAfterWait(1000).dismiss();
		}
		seleniumUtil.pause(800);
	}

	public static void checkUserBaseInfo(SeleniumUtil seleniumUtil, String... info) {
		String[] values = { seleniumUtil.findElementBy(UserBaseInfoPage.BUIP_TEXT_USER_SEX).getText(), seleniumUtil.findElementBy(UserBaseInfoPage.BUIP_TEXT_USER_BIRTHDAY).getText(), seleniumUtil.findElementBy(UserBaseInfoPage.BUIP_TEXT_USER_QQ).getText(), seleniumUtil.findElementBy(UserBaseInfoPage.BUIP_TEXT_USER_EMAIL).getText(), };
		for (int i = 0; i < 4; i++) {
			try {// 判断基本信息中填写的用户信息值和提交之后的值是否相等
				if (i == 1 && info[1] != "")
					info[1] = info[1].toString().substring(0, info[1].toString().indexOf(" "));
				Assert.assertTrue(values[i].equals(info[i]));
			}catch(AssertionError ae){
				Assert.fail("在基本信息页面中填写值:"+values[i]+"和修改之后的值:"+info[i]+"不相等");
			} 
			catch (Exception e) {
			
				e.printStackTrace();
				throw e;
			}
		}
	}
}
