package com.incito.logistics.testcase.sendgoods;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.SendGoodsPage;
import com.incito.logistics.pages.pageshelper.SendGoodsPageHelper;
import com.incito.logistics.plugins.father.SendGoodsFather;

/**
 * @author xy-incito-wy
 * @Description 测试用例：发布货源界面，检查所有的货源名称
 * */
public class SendGoodsPage_015_CheckGoodsAllNames_Test extends SendGoodsFather {

	@Test
	public void sendAllValidDataForWeightSuccessTest(ITestContext context) {
		SendGoodsFather.sendGoodsParpare(context, seleniumUtil);
		SendGoodsPageHelper.enterPage(seleniumUtil, SendGoodsPage.SGP_INPUT_GOODSNAME);
		SendGoodsPageHelper.checkReserveText(seleniumUtil, timeOut,SendGoodsPage.SGP_TEXT_GOODSNAMECHOICE, "原料 煤炭 矿产 建材"+"\n"+
											"钢材 木材 化工产品 机械五金"+"\n"+"电子电工 数码电器 医药 危险品"+"\n"+
											"家具 办公设备 工艺品 纺织服鞋"+"\n"+"文体用品 日用品 食品饮料 冻货"+"\n"+"农副产品 其他"
				);

		
		
	}
	


}
