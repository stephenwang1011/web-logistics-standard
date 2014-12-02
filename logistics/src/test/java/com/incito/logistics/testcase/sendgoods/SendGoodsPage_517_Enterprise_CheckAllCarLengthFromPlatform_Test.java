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
 * @Description 测试用例：发布货源界面，检查所有的车长文本
 * */
public class SendGoodsPage_517_Enterprise_CheckAllCarLengthFromPlatform_Test extends BaseParpare {

	@Test
	public void checkAllCarLengthFromPlatform(ITestContext context) {
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
		SendGoodsForEnterprisePageHelper.enterPage(seleniumUtil, SendGoodsPage.SGP_INPUT_CARLENGTH);
		SendGoodsPageHelper.checkReserveText(seleniumUtil,timeOut, SendGoodsPage.SGP_TEXT_CARLENGTHTOOPLATFORM, "不限 4米 4.2米 4.3米"+"\n"+
											"4.5米 4.8米 5米 5.8米"+"\n"+"6米 6.2米 6.8米 7米"+"\n"+
											"7.2米 7.4米 7.8米 8米"+"\n"+"8.7米 8.8米 9米 9.6米"+"\n"+"12.5米 13米 13.5米 17.5米"
				);

		
		
	}
	


}
