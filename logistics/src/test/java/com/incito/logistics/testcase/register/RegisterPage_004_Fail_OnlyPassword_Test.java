package com.incito.logistics.testcase.register;

import org.openqa.selenium.By;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.RegisterPage;
import com.incito.logistics.pages.pageshelper.RegisterPageHelper;
import com.incito.logistics.plugins.father.RegisterFather;

/**
 * @author xy-incito-wk
 * @Description 注册失败：不输入用户名，只输入密码1，点击登陆提示 请输入用户名（但是实际中只提示：用户名称不能全部为数字。后期进行更改）
 * */
// 后期需要更改该测试用例中提示语
public class RegisterPage_004_Fail_OnlyPassword_Test extends RegisterFather {

	@Test
	public void registerFailTest_Password(ITestContext context) {
		RegisterFather.registerParpare(context, seleniumUtil);
		By[] bys = { RegisterPage.RP_INPUT_USERNAME, RegisterPage.RP_INPUT_PASSWD, RegisterPage.RP_INPUT_REPASSWD };
		for (By by : bys) {
			RegisterPageHelper.clearText(seleniumUtil, by);
		}
		seleniumUtil.type(seleniumUtil.findElementBy(RegisterPage.RP_INPUT_PASSWD), password);
		RegisterPageHelper.enterPage(seleniumUtil, RegisterPage.RP_BUTTON_REGISTER);
		RegisterPageHelper.checkRegistStatus(seleniumUtil);
	}

}
