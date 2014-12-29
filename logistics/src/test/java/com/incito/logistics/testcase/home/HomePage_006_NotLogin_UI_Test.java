package com.incito.logistics.testcase.home;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.plugins.father.HomeNotLoginFather;

/**
 * @author xy-incito-wy
 * @Description 测试用例：首页UI测试
 * 
 * */
public class HomePage_006_NotLogin_UI_Test extends HomeNotLoginFather {
	@Test
	public void uiTest(ITestContext context) {
		HomeNotLoginFather.homeNotLoginParpare(context, seleniumUtil);


	}

}
