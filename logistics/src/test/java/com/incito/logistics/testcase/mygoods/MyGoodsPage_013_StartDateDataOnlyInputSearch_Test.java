package com.incito.logistics.testcase.mygoods;

import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.MyGoodsPage;
import com.incito.logistics.pages.pageshelper.MyGoodsPageHelper;
import com.incito.logistics.plugins.father.MyGoodsFather;

/**
 * @author xy-incito-wy
 * @Description 测试用例：查找我的货源-只输入发布的开始时间
 * */
public class MyGoodsPage_013_StartDateDataOnlyInputSearch_Test extends MyGoodsFather {

	@Test(dataProvider = "data")
	public void startDateDataOnlyInputSearch(ITestContext context, Map<String, String> data) {
		MyGoodsFather.myGoodsParpare(context, seleniumUtil);
		MyGoodsPageHelper.enterPage(seleniumUtil, MyGoodsPage.MGP_BUTTON_ADSEARCH);
		MyGoodsPageHelper.typeGoodsInfo(seleniumUtil, data.get("MGP_INPUT_GOODSNO"),data.get("MGP_INPUT_ORIGINALCITY"),
				data.get("MGP_INPUT_TARGETCITY"),data.get("MGP_INPUT_GOODSNAME"),data.get("MGP_WEIGHT_VOLUME"),
				data.get("MGP_START_WEIGHT_VOLUME"),data.get("MGP_END_WEIGHT_VOLUME"),data.get("MGP_INPUT_STARTDATE"),data.get("MGP_INPUT_ENDDATE"));
		MyGoodsPageHelper.checkGoodsSendDate(seleniumUtil, MyGoodsPage.MGP_DIV_GOODSHEADER, data.get("MGP_INPUT_STARTDATE"),data.get("MGP_INPUT_ENDDATE"));
		

	}
	


}
