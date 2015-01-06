package com.incito.logistics.testcase.sendgoods;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.SendGoodsPage;
import com.incito.logistics.pages.pageshelper.SendGoodsPageHelper;
import com.incito.logistics.plugins.father.SendGoodsFather;

/**
 * @author xy-incito-wy
 * @Description 测试用例：发布货源界面，检查所有的车长文本
 * */
public class SendGoodsPage_017_CheckAllCarLength_Test extends SendGoodsFather {

	@Test
	public void checkAllCarLength(ITestContext context) {
		SendGoodsFather.sendGoodsParpare(context, seleniumUtil);
		SendGoodsPageHelper.enterPage(seleniumUtil, SendGoodsPage.SGP_INPUT_CARLENGTH);
		SendGoodsPageHelper.checkReserveText(seleniumUtil,timeOut, SendGoodsPage.SGP_TEXT_CARLENGTH, "不限 4米 4.2米 4.3米"+"\n"+
											"4.5米 4.8米 5米 5.8米"+"\n"+"6米 6.2米 6.8米 7米"+"\n"+
											"7.2米 7.4米 7.8米 8米"+"\n"+"8.7米 8.8米 9米 9.6米"+"\n"+"12.5米 13米 13.5米 17.5米"
				);

		
		
	}
	


}
