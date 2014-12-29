package com.incito.logistics.testcase.register;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.base.BaseParpare;
import com.incito.logistics.plugins.father.RegisterFather;

/**
 * @author xy-incito-wk
 * @Description 注册页面上的文本检查
 * 
 * */
public class RegisterPage_001_UICheck_Test extends BaseParpare {
	@Test
	public void registerPageUiTest(ITestContext context) {
		RegisterFather.registerParpare(context, seleniumUtil);
	}

}
