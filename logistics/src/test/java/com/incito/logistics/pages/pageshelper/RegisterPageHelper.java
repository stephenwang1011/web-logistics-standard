package com.incito.logistics.pages.pageshelper;

import com.incito.logistics.pages.HomePage;
import com.incito.logistics.pages.RegisterPage;
import com.incito.logistics.util.SeleniumUtil;

public class RegisterPageHelper {

	/**等待页面上某个重要元素显示出来*/
	public static void  waitRegisterPageToLoad(int timeOut,SeleniumUtil seleniumUtil){
		seleniumUtil.waitForElementToLoad(timeOut,RegisterPage.RP_INPUT_USERNAME);
		seleniumUtil.waitForElementToLoad(timeOut,RegisterPage.RP_INPUT_PASSWD);
		seleniumUtil.waitForElementToLoad(timeOut,RegisterPage.RP_INPUT_REPASSWD);
		seleniumUtil.waitForElementToLoad(timeOut,RegisterPage.RP_BUTTON_REGISTER);
		seleniumUtil.waitForElementToLoad(timeOut,RegisterPage.RP_BUTTON_BACK);

	}
	
	/**检查注册页面上的文本*/
	public static void checkRegisterPageText(SeleniumUtil seleniumUtil){
		seleniumUtil.isTextEquals( seleniumUtil.getTitle(), "logistics - 物流管理");
		seleniumUtil.isTextEquals(seleniumUtil.findElementBy(RegisterPage.RP_INPUT_USERNAME).getAttribute("placeholder"),"至少输入4个字符");
		seleniumUtil.isTextEquals(seleniumUtil.findElementBy(RegisterPage.RP_INPUT_PASSWD).getAttribute("placeholder"),"至少输入6个字符");
		seleniumUtil.isTextEquals(seleniumUtil.findElementBy(RegisterPage.RP_INPUT_REPASSWD).getAttribute("placeholder"),"请再次输入登录密码");
		seleniumUtil.isTextEquals(seleniumUtil.findElementBy(RegisterPage.RP_BUTTON_REGISTER).getText(),"注册");
		seleniumUtil.isTextEquals(seleniumUtil.findElementBy(RegisterPage.RP_BUTTON_BACK).getText(),"返回");
		seleniumUtil.isTextEquals(seleniumUtil.findElementBy(HomePage.HP_TEXT_FOOTER).getText(),"联系我们 | 关于我们 | 帮助中心"+"\n"+"@2014 灵动信息技术有限公司 版权所有 鄂ICP备13016476号"+"\n"+"公司联系邮箱：wuliu@incito.com.cn | 客服热线：400-860-3060");
			
	}
	

}
