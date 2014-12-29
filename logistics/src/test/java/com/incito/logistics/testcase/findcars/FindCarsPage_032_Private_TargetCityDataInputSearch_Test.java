package com.incito.logistics.testcase.findcars;

import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.FindCarsPage;
import com.incito.logistics.pages.pageshelper.FindCarsPageHelper;
import com.incito.logistics.plugins.father.FindCarsFather;

/**
 * @author xy-incito-wy
 * @Description 测试用例：找车源，输入开始喝结束容积
 * */
public class FindCarsPage_032_Private_TargetCityDataInputSearch_Test extends FindCarsFather {

	@Test(dataProvider = "data")
	public void targetCityDataInputSearch(ITestContext context, Map<String, String> data) {
		FindCarsFather.FindCarsParpare(context, seleniumUtil);
		FindCarsPageHelper.enterPage(seleniumUtil, FindCarsPage.FCP_TAB_FAV);
		FindCarsPageHelper.typeCarsInfo(seleniumUtil, data.get("FCP_INPUT_FROM"), data.get("FCP_INPUT_TO"), 
				data.get("FCP_INPUT_STARTCARLEN"), data.get("FCP_INPUT_ENDCARLEN"), data.get("FCP_INPUT_CARTYPE"), data.get("FCP_INPUT_STARTWEIGHT"), 
				data.get("FCP_INPUT_ENDWEIGHT"), data.get("FCP_INPUT_STARTVOLUME"),  data.get("FCP_INPUT_ENDVOLUME"));
		FindCarsPageHelper.checkTargetCity(seleniumUtil,data.get("FCP_INPUT_TO"));
	}
}
