package com.incito.logistics.testcase.sendgoods;
import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.base.BaseParpare;
import com.incito.logistics.pages.pageshelper.SendGoodsPageHelper;
import com.incito.logistics.plugins.father.SendGoodsFather;

/**
 * @author xy-incito-wy
 * @Description 测试用例：发布货源页面，货源说明输入框，字数计数功能测试
 * */
public class SendGoodsPage_018_Goods_Memo_Count_Test extends BaseParpare {

	@Test(dataProvider="data")
	public void goodsMemoCountTest(ITestContext context,Map<String, String> data) {

		final String comment = data.get("SGP_INPUT_INSTRUCTION");
		SendGoodsFather.sendGoodsParpare(context, seleniumUtil);
		SendGoodsPageHelper.checkRemainText(seleniumUtil, comment);

		
	}
	


}
