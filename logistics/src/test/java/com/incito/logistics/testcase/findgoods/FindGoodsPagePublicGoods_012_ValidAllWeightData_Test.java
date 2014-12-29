package com.incito.logistics.testcase.findgoods;

import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.FindGoodsPage;
import com.incito.logistics.pages.pageshelper.FindGoodsPageHelper;
import com.incito.logistics.plugins.father.FindGoodsFather;

/**
 * 
 * @author xy-incito-wk
 *@Description 测试用例：找货源——填写最小重量和最大重量
 */
public class FindGoodsPagePublicGoods_012_ValidAllWeightData_Test extends FindGoodsFather {
	@Test(dataProvider = "data")
	public void FindGoodsPagePublicGoodsValidMaxWeightData(ITestContext context, Map<String, String> data) {
		FindGoodsFather.FindGoodsParpare(context, seleniumUtil);

		FindGoodsPageHelper.enterPage(seleniumUtil, FindGoodsPage.FGP_BUTTON_ADVANCESEARCH);
		FindGoodsPageHelper.typeFindGoodsInfo(seleniumUtil, 
				data.get("FGP_INPUT_GOODSORIGINALCITY"), data.get("FGP_INPUT_GOODSRECEIPTCITY"), 
				data.get("FGP_INPUT_STARTCARLONG"), data.get("FGP_INPUT_ENDTCARLONG"), 
				data.get("FGP_INPUT_CARTYPE"), data.get("FGP_INPUT_GOODSNAME"), 
				data.get("FGP_INPUT_WEIGHT_VOLUME"), data.get("FGP_START_WEIGHT_VOLUME"), 
				data.get("FGP_END_WEIGHT_VOLUME"));
		FindGoodsPageHelper.enterPage(seleniumUtil, FindGoodsPage.FGP_BUTTON_SEARCH);
		seleniumUtil.waitForElementToLoad(timeOut, FindGoodsPage.FGP_SECOND_INFO);
		FindGoodsPageHelper.checkGoodsWeightOrVolume(seleniumUtil, FindGoodsPage.FGP_SECOND_INFO, FindGoodsPage.FGP_SECOND_INFO_CAR_LENGTH,
				data.get("FGP_INPUT_WEIGHT_VOLUME"), data.get("FGP_START_WEIGHT_VOLUME"),
				data.get("FGP_END_WEIGHT_VOLUME"));
	}
}
