package com.incito.logistics.testcase.findcars;

import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.pageshelper.FindCarsPageHelper;
import com.incito.logistics.plugins.father.FindCarsUnattestedFather;

/**
 * @author xy-incito-wy
 * @Description 未认证的用户，在找车源页面进行检索操作：输入车辆的开始和结束载重属性，点击查询按钮之后 未认证用户会得到查询列表并且结果正确（有权限）
 * */
public class FindCarsPage_212_Public_UnattestedAllCarWeightDataInputSearch_Test extends FindCarsUnattestedFather {

	@Test(dataProvider = "data")
	public void publicUnattestedAllCarWeightDataInputSearch(ITestContext context, Map<String, String> data) {
		FindCarsUnattestedFather.unattestedFindCarsParpare(context, seleniumUtil);
		FindCarsPageHelper.typeCarsInfo(seleniumUtil, data.get("FCP_INPUT_FROM"), data.get("FCP_INPUT_TO"), 
				data.get("FCP_INPUT_STARTCARLEN"), data.get("FCP_INPUT_ENDCARLEN"), data.get("FCP_INPUT_CARTYPE"), data.get("FCP_INPUT_STARTWEIGHT"), 
				data.get("FCP_INPUT_ENDWEIGHT"), data.get("FCP_INPUT_STARTVOLUME"),  data.get("FCP_INPUT_ENDVOLUME"));
		FindCarsPageHelper.checkCarWeight(seleniumUtil, data.get("FCP_INPUT_STARTWEIGHT"),data.get("FCP_INPUT_ENDWEIGHT"));

	}


}
