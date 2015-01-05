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
 * @Description 测试用例：已登录的情况下，未认证的用户登录，点击公共货源，在搜索条件下输入发货地和收货地址，检查搜索结果
 */
public class FindGoodsPagePublicGoods_105_UnattestedUserSendFromAndSendTo_Test extends FindGoodsUnatestedFather {
	@Test(dataProvider = "data")
	public void FindGoodsPagePublicGoodsInfoCheck(ITestContext context, Map<String, String> data) {
		FindGoodsUnatestedFather.unattestedFindGoodsParpare(context, seleniumUtil);
		
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