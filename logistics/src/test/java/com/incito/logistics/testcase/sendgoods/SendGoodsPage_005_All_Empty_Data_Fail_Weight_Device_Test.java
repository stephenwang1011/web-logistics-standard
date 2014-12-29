package com.incito.logistics.testcase.sendgoods;

import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.base.BaseParpare;
import com.incito.logistics.pages.SendGoodsPage;
import com.incito.logistics.pages.pageshelper.SendGoodsPageHelper;
import com.incito.logistics.plugins.father.SendGoodsFather;


/**
 * @author xy-incito-wy
 * @Description 测试用例：发布货源，不输入任何内容点击发布按钮(针对 是抛货的情况下)
 * */
public class SendGoodsPage_005_All_Empty_Data_Fail_Weight_Device_Test extends BaseParpare {

	@Test(dataProvider="data")
	public void sendAllEmptyDataFailWeightForDeviceTest(ITestContext context,Map<String, String> data) {
		SendGoodsFather.sendGoodsParpare(context, seleniumUtil);
		SendGoodsPageHelper.typeGoodsInfo(seleniumUtil, SendGoodsPage.SGP_BUTTON_LIGHTGOODS, SendGoodsPage.SGP_BUTTON_GOODSDATE5, 
				data.get("SGP_INPUT_GOODSORIGINALCITY"), data.get("SGP_INPUT_GOODSRECEIPTCITY"), data.get("SGP_INPUT_GOODSNAME"), data.get("SGP_INPUT_GOODSDETAILS"),
				data.get("SGP_INPUT_VOLUME"), data.get("SGP_INPUT_COUNT"), data.get("SGP_INPUT_CARLENGTH"), data.get("SGP_INPUT_CARTYPE"), 
				data.get("SGP_INPUT_INFOFARE"), data.get("SGP_INPUT_FARE"), data.get("SGP_INPUT_DECLAREVALUE"), data.get("SGP_INPUT_INSTRUCTION"));
		SendGoodsPageHelper.enterPage(seleniumUtil, SendGoodsPage.SGP_BUTTON_SEND);
		SendGoodsPageHelper.checkSendGoodsAllEmptyFailedStatus(seleniumUtil);
		
	}
	

}
