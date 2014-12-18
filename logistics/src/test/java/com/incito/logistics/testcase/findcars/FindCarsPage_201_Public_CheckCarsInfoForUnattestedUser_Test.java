package com.incito.logistics.testcase.findcars;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.pageshelper.FindCarsPageHelper;
import com.incito.logistics.plugins.father.FindCarsUnattestedFather;

/**
 * @author xy-incito-wy
 * @Description 未认证用户在找车源-公共车源中查看司机的信息 ，相关信息被隐藏不能够查看
 * */
public class FindCarsPage_201_Public_CheckCarsInfoForUnattestedUser_Test extends FindCarsUnattestedFather {

	@Test
	public void publicCheckCarsInfoForUnattestedUser(ITestContext context) {
		FindCarsUnattestedFather.unattestedFindCarsParpare(context, seleniumUtil);
		FindCarsPageHelper.checkCarsInfoForUnattestedUser(seleniumUtil, sleepTime);


	}

}
