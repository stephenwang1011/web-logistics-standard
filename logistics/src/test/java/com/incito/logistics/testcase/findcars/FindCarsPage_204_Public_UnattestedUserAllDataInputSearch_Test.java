package com.incito.logistics.testcase.findcars;

import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.pageshelper.FindCarsPageHelper;
import com.incito.logistics.plugins.father.FindCarsUnattestedFather;

/**
 * @author xy-incito-wy
 * @Description 未认证用户登录情况下，在找车源页面输入所有内容进行检索，未认证用户有权限做此操作
 * */
public class FindCarsPage_204_Public_UnattestedUserAllDataInputSearch_Test extends FindCarsUnattestedFather {

	@Test(dataProvider = "data")
	public void publicUnattestedUserAllDataInputSearch(ITestContext context, Map<String, String> data) {
		FindCarsUnattestedFather.unattestedFindCarsParpare(context, seleniumUtil);
		FindCarsPageHelper.typeCarsInfo(seleniumUtil, data.get("FCP_INPUT_FROM"), data.get("FCP_INPUT_TO"), 
				data.get("FCP_INPUT_STARTCARLEN"), data.get("FCP_INPUT_ENDCARLEN"), data.get("FCP_INPUT_CARTYPE"), data.get("FCP_INPUT_STARTWEIGHT"), 
				data.get("FCP_INPUT_ENDWEIGHT"), data.get("FCP_INPUT_STARTVOLUME"),  data.get("FCP_INPUT_ENDVOLUME"));
		FindCarsPageHelper.checkCurrentCarLocation(seleniumUtil, data.get("FCP_INPUT_FROM"));

	}
}
