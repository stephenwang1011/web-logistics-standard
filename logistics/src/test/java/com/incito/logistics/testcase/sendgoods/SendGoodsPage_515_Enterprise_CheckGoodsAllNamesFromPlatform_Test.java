package com.incito.logistics.testcase.sendgoods;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.base.BaseParpare;
import com.incito.logistics.pages.HomePage;
import com.incito.logistics.pages.SendGoodsForEnterprisePage;
import com.incito.logistics.pages.SendGoodsPage;
import com.incito.logistics.pages.pageshelper.HomePageHelper;
import com.incito.logistics.pages.pageshelper.LoginPageHelper;
import com.incito.logistics.pages.pageshelper.SendGoodsForEnterprisePageHelper;
import com.incito.logistics.pages.pageshelper.SendGoodsPageHelper;
import com.incito.logistics.util.PropertiesDataProvider;

/**
 * @author xy-incito-wy
 * @Description 测试用例：发布货源界面，检查所有的货源名称
 * */
public class SendGoodsPage_515_Enterprise_CheckGoodsAllNamesFromPlatform_Test extends BaseParpare {

	@Test
	public void checkGoodsAllNamesFromPlatformSuccessTest(ITestContext context) {
		String userInfoPath = context.getCurrentXmlTest().getParameter("userInfoPath");
		String username = PropertiesDataProvider.getTestData(userInfoPath, "enterprise_username");
		String password = PropertiesDataProvider.getTestData(userInfoPath, "enterprise_password");
		int timeOut = Integer.valueOf(context.getCurrentXmlTest().getParameter("timeOut"));
		int sleepTime = Integer.valueOf(context.getCurrentXmlTest().getParameter("sleepTime"));

		HomePageHelper.waitHomePageToLoad(timeOut, seleniumUtil);
		HomePageHelper.enterPage(seleniumUtil, HomePage.HP_BUTTON_LOGIN);
		LoginPageHelper.waitLoginPageToLoad(timeOut, seleniumUtil);
		LoginPageHelper.login(seleniumUtil, username, password);
		LoginPageHelper.checkUserInfo(timeOut, sleepTime, seleniumUtil, username);
		HomePageHelper.enterPage(seleniumUtil, HomePage.HP_BUTTON_FREESEND);
		SendGoodsForEnterprisePageHelper.enterPage(seleniumUtil, SendGoodsForEnterprisePage.SGP_LINK_SENDPLATAM);
		SendGoodsForEnterprisePageHelper.waitSendGoodsToPlatam(timeOut, seleniumUtil);
		SendGoodsForEnterprisePageHelper.enterPage(seleniumUtil, SendGoodsForEnterprisePage.SGP_INPUT_GOODSNAME);
		SendGoodsPageHelper.checkReserveText(seleniumUtil, timeOut,SendGoodsPage.SGP_TEXT_GOODSNAMECHOICE, "原料 煤炭 矿产 建材"+"\n"+
											"钢材 木材 化工产品 机械五金"+"\n"+"电子电工 数码电器 医药 危险品"+"\n"+
											"家具 办公设备 工艺品 纺织服鞋"+"\n"+"文体用品 日用品 食品饮料 冻货"+"\n"+"农副产品 其他"
				);

		
		
	}
	


}
