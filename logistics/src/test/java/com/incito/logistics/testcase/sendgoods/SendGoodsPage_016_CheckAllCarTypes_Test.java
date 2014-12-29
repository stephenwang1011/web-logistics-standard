package com.incito.logistics.testcase.sendgoods;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.SendGoodsPage;
import com.incito.logistics.pages.pageshelper.SendGoodsPageHelper;
import com.incito.logistics.plugins.father.SendGoodsFather;

/**
 * @author xy-incito-wy
 * @Description 测试用例：发布货源界面，检查所有的车型文本
 * */
public class SendGoodsPage_016_CheckAllCarTypes_Test extends SendGoodsFather {

	@Test
	public void sendAllValidDataForWeightSuccessTest(ITestContext context) {
		SendGoodsFather.sendGoodsParpare(context, seleniumUtil);
		SendGoodsPageHelper.enterPage(seleniumUtil, SendGoodsPage.SGP_INPUT_CARTYPE);
		SendGoodsPageHelper.checkReserveText(seleniumUtil,timeOut, SendGoodsPage.SGP_TEXT_CARTYPE, "不限 普通车 前四后四 前四后八"+"\n"+
											"敞篷车 平板车 高栏车 集装箱"+"\n"+"冷藏车 起重车 后八轮 单桥车"+"\n"+
											"自卸车 半封闭车 半挂车 保温车"+"\n"+"双桥车 加长挂车 棉被车 前四后十"+"\n"+"大笼子车 高低板 翻斗车 厢式车"
				);

		
		
	}
	


}
