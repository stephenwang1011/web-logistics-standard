package com.incito.logistics.testcase.findcars;

import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.FindCarsPage;
import com.incito.logistics.pages.pageshelper.FindCarsPageHelper;
import com.incito.logistics.plugins.father.FindCarsUnattestedFather;

/**
 * @author xy-incito-wy
 * @Description 未认证用户，在找车源-我的收藏模块中，输入所有输入条件之后进行搜索，可以准确查出正确的数据
 * */
public class FindCarsPage_222_UnattestedPrivateAllDataInputSearch_Test extends FindCarsUnattestedFather {

	@Test(dataProvider = "data")
	public void allDataInputSearch(ITestContext context, Map<String, String> data) {
		FindCarsUnattestedFather.unattestedFindCarsParpare(context, seleniumUtil);
		FindCarsPageHelper.enterPage(seleniumUtil, FindCarsPage.FCP_TAB_FAV);
		FindCarsPageHelper.typeCarsInfo(seleniumUtil, data.get("FCP_INPUT_FROM"), data.get("FCP_INPUT_TO"), 
				data.get("FCP_INPUT_STARTCARLEN"), data.get("FCP_INPUT_ENDCARLEN"), data.get("FCP_INPUT_CARTYPE"), data.get("FCP_INPUT_STARTWEIGHT"), 
				data.get("FCP_INPUT_ENDWEIGHT"), data.get("FCP_INPUT_STARTVOLUME"),  data.get("FCP_INPUT_ENDVOLUME"));
		FindCarsPageHelper.checkCurrentCarLocation(seleniumUtil, data.get("FCP_INPUT_FROM"));
		FindCarsPageHelper.checkTargetCity(seleniumUtil, data.get("FCP_INPUT_TO"));
		FindCarsPageHelper.checkCarLength(seleniumUtil,data.get("FCP_INPUT_STARTCARLEN"), data.get("FCP_INPUT_ENDCARLEN"));
		FindCarsPageHelper.checkCarType(seleniumUtil, data.get("FCP_INPUT_CARTYPE"));
		
		
	}



}
