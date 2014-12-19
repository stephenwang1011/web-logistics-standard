package com.incito.logistics.testcase.personcenter;

/**
 *@author  xy-incito-wk
 *@Description 测试用例：已登录的情况下，未认证的用户登录，点击新货源，查看连接跳转并检查状态
 *
 * */
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.FindGoodsPage;
import com.incito.logistics.pages.PersonCenterPage;
import com.incito.logistics.pages.pageshelper.FindGoodsPageHelper;
import com.incito.logistics.plugins.father.PensonCenterUnatestedFather;

public class PensonCenterPage_008_UnattestedUserSkipFindGoodsMyFavo_Test extends PensonCenterUnatestedFather {
	@Test
	public void personCenterMyOrdersFindGoodsMyFavo(ITestContext context) {
		PensonCenterUnatestedFather.UnattestedPensonCenterParpare(context, seleniumUtil);

		int num = Integer.valueOf(seleniumUtil.findElementBy(PersonCenterPage.PCP_LINK_MYFAVOCARS_GOODS).findElements(By.tagName("p")).get(0).getText());

		seleniumUtil.findElementBy(PersonCenterPage.PCP_LINK_MYFAVOCARS_GOODS).click();
		FindGoodsPageHelper.waitFindGoodsPageToLoad(timeOut, seleniumUtil);
		String selected = seleniumUtil.findElementBy(FindGoodsPage.FGP_BUTTON_MYFAVORITES).getAttribute("class");
		try {
			Assert.assertTrue(selected.equals("active"));
		} catch (Exception e) {
			Assert.fail("在找货源页面中‘我的收藏’没有被选中。");
		}
		if (num == 0) {
			seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(FindGoodsPage.FGP_NODIAPALY_SEARCH).getText().trim(), "没有搜索到相应的数据");
		} else if (20 >= num && num > 0) {
			int factNum = seleniumUtil.findElementsBy(FindGoodsPage.FGP_SECOND_INFO).size();
			try {
				Assert.assertTrue(factNum == num);
			} catch (Exception e) {
				Assert.fail("个人中心查找货源的收藏个数与找货源中个数不一致！！！");
			}
		}
	}
}
