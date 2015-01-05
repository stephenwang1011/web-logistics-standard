package com.incito.logistics.testcase.register;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.pageshelper.RegisterPageHelper;
import com.incito.logistics.plugins.father.RegisterFather;

/**
 * @author xy-incito-wy
 * @Description 注册页面，点击《智慧物流网站注册协议》链接打开一个新的窗口
 * */
public class RegisterPage_021_OpenAgreement_Test extends RegisterFather {

	@Test
	public void openAgreement(ITestContext context) {
		RegisterFather.registerParpare(context, seleniumUtil);
		RegisterPageHelper.switchWindow(seleniumUtil, sleepTime, timeOut);

	}

}