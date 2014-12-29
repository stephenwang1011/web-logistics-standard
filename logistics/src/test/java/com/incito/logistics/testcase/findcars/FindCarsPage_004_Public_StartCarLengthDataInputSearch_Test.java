package com.incito.logistics.testcase.findcars;

import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.pageshelper.FindCarsPageHelper;
import com.incito.logistics.plugins.father.FindCarsFather;

/**
 * @author xy-incito-wy
 * @Description 测试用例：找车源，只输入车长：开始车长
 * */
public class FindCarsPage_004_Public_StartCarLengthDataInputSearch_Test extends FindCarsFather {

	@Test(dataProvider = "data")
	public void startCarLengthDataInputSearch(ITestContext context, Map<String, String> data) {
		FindCarsFather.FindCarsParpare(context, seleniumUtil);
		FindCarsPageHelper.typeCarsInfo(seleniumUtil, data.get("FCP_INPUT_FROM"), data.get("FCP_INPUT_TO"), 
				data.get("FCP_INPUT_STARTCARLEN"), data.get("FCP_INPUT_ENDCARLEN"), data.get("FCP_INPUT_CARTYPE"), data.get("FCP_INPUT_STARTWEIGHT"), 
				data.get("FCP_INPUT_ENDWEIGHT"), data.get("FCP_INPUT_STARTVOLUME"),  data.get("FCP_INPUT_ENDVOLUME"));
		FindCarsPageHelper.checkCarLength(seleniumUtil,data.get("FCP_INPUT_STARTCARLEN"), data.get("FCP_INPUT_ENDCARLEN"));
	}
}
