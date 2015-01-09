package com.incito.logistics.testcase.sendgoods;

import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.SendGoodsPage;
import com.incito.logistics.pages.pageshelper.SendGoodsPageHelper;
import com.incito.logistics.pages.pageshelper.SendGoodsSuccessPageHelper;
import com.incito.logistics.plugins.father.SendGoodsFather;

/**
 * @author xy-incito-wy
 * @Description 货代A发布一条声明价值私有的货源，货代B登陆之后去找货源处检查此货源声明价值不可以看到
 * */
public class SendGoodsPage_045_AttestedSendPrivateDeclareValue_Test extends SendGoodsFather {

	@Test(dataProvider = "data")
	public void attestedSendPrivateDeclareValue(ITestContext context, Map<String, String> data) {
		SendGoodsFather.sendGoodsParpare(context, seleniumUtil);
		SendGoodsPageHelper.typeGoodsInfo(seleniumUtil, SendGoodsPage.SGP_BUTTON_DEVICEGOODS, SendGoodsPage.SGP_BUTTON_GOODSDATE3, 
				data.get("SGP_INPUT_GOODSORIGINALCITY"), data.get("SGP_INPUT_GOODSRECEIPTCITY"), data.get("SGP_INPUT_GOODSNAME"), data.get("SGP_INPUT_GOODSDETAILS"),
				data.get("SGP_INPUT_WEIGHT"), data.get("SGP_INPUT_COUNT"), data.get("SGP_INPUT_CARLENGTH"), data.get("SGP_INPUT_CARTYPE"), data.get("SGP_INPUT_INFOFARE"),
				data.get("SGP_INPUT_UNITPRICE"),data.get("SGP_SELECT_UNITNAME"),data.get("SGP_INPUT_ALLPRICE"), data.get("SGP_INPUT_DECLAREVALUE"), data.get("SGP_INPUT_INSTRUCTION"));
		SendGoodsPageHelper.doesCheckDeclareValue(seleniumUtil, "NO");
		SendGoodsPageHelper.enterPage(seleniumUtil, SendGoodsPage.SGP_BUTTON_SEND);
		SendGoodsSuccessPageHelper.waitSendGoodsSuccessPageToLoad(timeOut, seleniumUtil);
		SendGoodsPageHelper.checkDeclareValueInGoods(seleniumUtil, "private", data.get("SGP_INPUT_DECLAREVALUE"), data.get("AGENT"), data.get("PASSWD"), timeOut);
		
		
		
	}
	

}
