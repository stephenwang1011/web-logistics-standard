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
 * @Description 测试用例：找货源——只填写发货地
 */
public class FindGoodsPagePublicGoods_002_ValidSendFrom_Test extends FindGoodsFather {
	@Test(dataProvider = "data")
	public void FindGoodsPagePublicGoodsValidSendFrom(ITestContext context, Map<String, String> data) {
		FindGoodsFather.FindGoodsParpare(context, seleniumUtil);

		FindGoodsPageHelper.typeFindGoodsInfo(seleniumUtil, 
				data.get("FGP_INPUT_GOODSORIGINALCITY"), data.get("FGP_INPUT_GOODSRECEIPTCITY"), 
				data.get("FGP_INPUT_STARTCARLONG"), data.get("FGP_INPUT_ENDTCARLONG"), 
				data.get("FGP_INPUT_CARTYPE"), data.get("FGP_INPUT_GOODSNAME"), 
				data.get("FGP_INPUT_WEIGHT_VOLUME"), data.get("FGP_START_WEIGHT_VOLUME"), 
				data.get("FGP_END_WEIGHT_VOLUME"));
		FindGoodsPageHelper.enterPage(seleniumUtil, FindGoodsPage.FGP_BUTTON_SEARCH);
		seleniumUtil.waitForElementToLoad(timeOut, FindGoodsPage.FGP_DISPLAY_SEARCH);
		FindGoodsPageHelper.checkGoodsAddress(seleniumUtil, FindGoodsPage.FGP_DISPLAY_SEARCH, 
				data.get("ORIGINAL_ADDRESS"),data.get("TARGET_ADDRESS"));
	}
}