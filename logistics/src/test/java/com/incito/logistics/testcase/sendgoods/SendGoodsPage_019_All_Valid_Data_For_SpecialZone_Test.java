package com.incito.logistics.testcase.sendgoods;

import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.HomePage;
import com.incito.logistics.pages.SendGoodsPage;
import com.incito.logistics.pages.pageshelper.HomePageHelper;
import com.incito.logistics.pages.pageshelper.SendGoodsPageHelper;
import com.incito.logistics.pages.pageshelper.SendGoodsSuccessPageHelper;
import com.incito.logistics.plugins.father.SendGoodsFather;

/**
 * @author xy-incito-wy
 * @Description 测试用例：发布货源,特别行政区之间的发货 
 * */
public class SendGoodsPage_019_All_Valid_Data_For_SpecialZone_Test extends SendGoodsFather {

	@Test(dataProvider = "data")
	public void sendAllValidDataForSpecialZoneTest(ITestContext context, Map<String, String> data) {
		SendGoodsFather.sendGoodsParpare(context, seleniumUtil);
		SendGoodsPageHelper.typeGoodsInfo(seleniumUtil, SendGoodsPage.SGP_BUTTON_LIGHTGOODS, SendGoodsPage.SGP_BUTTON_GOODSDATE5, 
				data.get("SGP_INPUT_GOODSORIGINALCITY"), data.get("SGP_INPUT_GOODSRECEIPTCITY"), data.get("SGP_INPUT_GOODSNAME"), data.get("SGP_INPUT_GOODSDETAILS"),
				data.get("SGP_INPUT_WEIGHT"), data.get("SGP_INPUT_COUNT"), data.get("SGP_INPUT_CARLENGTH"), data.get("SGP_INPUT_CARTYPE"), 
				data.get("SGP_INPUT_INFOFARE"),data.get("SGP_INPUT_UNITPRICE"),data.get("SGP_SELECT_UNITNAME"),data.get("SGP_INPUT_ALLPRICE"), data.get("SGP_INPUT_DECLAREVALUE"), data.get("SGP_INPUT_INSTRUCTION"));
		SendGoodsPageHelper.enterPage(seleniumUtil, SendGoodsPage.SGP_BUTTON_SEND);
		SendGoodsSuccessPageHelper.waitSendGoodsSuccessPageToLoad(timeOut, seleniumUtil);
		SendGoodsSuccessPageHelper.checkSendGoodsPageText(seleniumUtil);
		HomePageHelper.enterPage(seleniumUtil, HomePage.HP_TEXT_USERINFO);
		HomePageHelper.enterPage(seleniumUtil, HomePage.HP_LINK_EXIT);
		
		
		
	}
	

}
