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
 * @Description 测试用例：发布货源界面，检查所有的车型文本
 * */
public class SendGoodsPage_516_Enterprise_CheckAllCarTypesFromPlatform_Test extends BaseParpare {

	@Test
	public void checkAllCarTypesFromPlatform(ITestContext context) {
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
		SendGoodsForEnterprisePageHelper.enterPage(seleniumUtil, SendGoodsForEnterprisePage.SGP_INPUT_CARTYPE);
		SendGoodsPageHelper.checkReserveText(seleniumUtil,timeOut, SendGoodsPage.SGP_TEXT_CARTYPETOPLATFORM, "不限 普通车 前四后四 前四后八"+"\n"+
											"敞篷车 平板车 高栏车 集装箱"+"\n"+"冷藏车 起重车 后八轮 单桥车"+"\n"+
											"自卸车 半封闭车 半挂车 保温车"+"\n"+"双桥车 加长挂车 棉被车 前四后十"+"\n"+"大笼子车 高低板 翻斗车 厢式车"
				);

		
		
	}
	


}
