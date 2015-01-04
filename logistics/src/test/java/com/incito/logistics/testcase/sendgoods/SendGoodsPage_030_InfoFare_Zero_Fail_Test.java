package com.incito.logistics.testcase.sendgoods;

import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.SendGoodsPage;
import com.incito.logistics.pages.pageshelper.SendGoodsPageHelper;
import com.incito.logistics.plugins.father.SendGoodsFather;

/**
 * @author xy-incito-wy
 * @Description 测试用例：发布货源，信息费0
 * */
public class SendGoodsPage_030_InfoFare_Zero_Fail_Test extends SendGoodsFather {

	@Test(dataProvider = "data")
	public void sendInfoFareZeroFailTest(ITestContext context, Map<String, String> data) {
		SendGoodsFather.sendGoodsParpare(context, seleniumUtil);
		SendGoodsPageHelper.typeGoodsInfo(seleniumUtil, SendGoodsPage.SGP_BUTTON_LIGHTGOODS, SendGoodsPage.SGP_BUTTON_GOODSDATE3, 
				data.get("SGP_INPUT_GOODSORIGINALCITY"), data.get("SGP_INPUT_GOODSRECEIPTCITY"), data.get("SGP_INPUT_GOODSNAME"), data.get("SGP_INPUT_GOODSDETAILS"),
				data.get("SGP_INPUT_VOLUME"), data.get("SGP_INPUT_COUNT"), data.get("SGP_INPUT_CARLENGTH"), data.get("SGP_INPUT_CARTYPE"), 
				data.get("SGP_INPUT_INFOFARE"), data.get("SGP_INPUT_UNITPRICE"),data.get("SGP_SELECT_UNITNAME"),data.get("SGP_INPUT_ALLPRICE"), data.get("SGP_INPUT_DECLAREVALUE"), data.get("SGP_INPUT_INSTRUCTION"));
		SendGoodsPageHelper.enterPage(seleniumUtil, SendGoodsPage.SGP_BUTTON_SEND);
		SendGoodsPageHelper.checkSendStatus(seleniumUtil);
		
		
		
	}
	


}
