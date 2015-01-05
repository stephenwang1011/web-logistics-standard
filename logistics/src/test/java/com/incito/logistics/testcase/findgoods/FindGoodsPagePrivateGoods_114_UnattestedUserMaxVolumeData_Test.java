package com.incito.logistics.testcase.findgoods;

import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.FindGoodsPage;
import com.incito.logistics.pages.pageshelper.FindGoodsPageHelper;
import com.incito.logistics.plugins.father.FindGoodsUnatestedFather;

/**
 * 
 * @author xy-incito-wk
 * @Description 测试用例：已登录的情况下，未认证的用户登录，点击我的收藏，在搜索条件下选择体积输入最大体积，检查搜索结果
 */
public class FindGoodsPagePrivateGoods_114_UnattestedUserMaxVolumeData_Test extends FindGoodsUnatestedFather {
	@Test(dataProvider = "data")
	public void unattestedUserMaxVolumeData(ITestContext context, Map<String, String> data) {
		FindGoodsUnatestedFather.unattestedFindGoodsParpare(context, seleniumUtil);
		
		FindGoodsPageHelper.enterPage(seleniumUtil, FindGoodsPage.FGP_BUTTON_MYFAVORITES);
		FindGoodsPageHelper.waitFindGoodsPageToLoad(timeOut, seleniumUtil);

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