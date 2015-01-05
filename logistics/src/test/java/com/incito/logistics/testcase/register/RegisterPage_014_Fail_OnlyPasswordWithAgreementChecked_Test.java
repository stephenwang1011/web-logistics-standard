package com.incito.logistics.testcase.register;

import org.openqa.selenium.By;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.RegisterPage;
import com.incito.logistics.pages.pageshelper.RegisterPageHelper;
import com.incito.logistics.plugins.father.RegisterFather;

/**
 * @author xy-incito-wy
 * @Description 注册页面，只输入密码，不输入用户名和确认密码，勾选同意协议checkbox，最后点击注册，注册不成功
 * */
// 后期需要更改该测试用例中提示语
public class RegisterPage_014_Fail_OnlyPasswordWithAgreementChecked_Test extends RegisterFather {

	@Test
	public void onlyPasswordWithAgreementChecked_(ITestContext context) {
		RegisterFather.registerParpare(context, seleniumUtil);
		By[] bys = { RegisterPage.RP_INPUT_USERNAME, RegisterPage.RP_INPUT_PASSWD, RegisterPage.RP_INPUT_REPASSWD };
		for (By by : bys) {
			RegisterPageHelper.clearText(seleniumUtil, by);
		}
		seleniumUtil.type(seleniumUtil.findElementBy(RegisterPage.RP_INPUT_PASSWD), password);
		RegisterPageHelper.checkAgreement(seleniumUtil, timeOut);
		RegisterPageHelper.enterPage(seleniumUtil, RegisterPage.RP_BUTTON_REGISTER);
		RegisterPageHelper.checkRegistStatus(seleniumUtil);
	}

}
