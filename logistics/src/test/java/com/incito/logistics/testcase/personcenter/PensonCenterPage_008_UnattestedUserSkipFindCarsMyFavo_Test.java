package com.incito.logistics.testcase.personcenter;

/**
 *@author  xy-incito-wk
 *@Description 测试用例：已登录的情况下，未认证的用户登录，点击我的收藏中车辆，查看连接跳转并检查状态
 *
 * */
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.FindCarsPage;
import com.incito.logistics.pages.PersonCenterPage;
import com.incito.logistics.pages.pageshelper.FindCarsPageHelper;
import com.incito.logistics.plugins.father.PensonCenterUnatestedFather;

public class PensonCenterPage_008_UnattestedUserSkipFindCarsMyFavo_Test extends PensonCenterUnatestedFather {
	@Test
	public void personCenterMyOrdersFindCarsMyFavo(ITestContext context) {
		PensonCenterUnatestedFather.UnattestedPensonCenterParpare(context, seleniumUtil);

		int num = Integer.valueOf(seleniumUtil.findElementBy(PersonCenterPage.PCP_LINK_MYFAVOCARS_CARS).findElements(By.tagName("p")).get(0).getText());

		seleniumUtil.findElementBy(PersonCenterPage.PCP_LINK_MYFAVOCARS_CARS).click();
		FindCarsPageHelper.waitFindCarsPageToLoad(timeOut, seleniumUtil);
		String selected = seleniumUtil.findElementBy(FindCarsPage.FCP_TAB_FAV).getAttribute("class");
		try {
			Assert.assertTrue(selected.equals("active"));
		} catch (Exception e) {
			Assert.fail("在找货源页面中‘我的收藏’没有被选中。");
			e.printStackTrace();
			throw e;
		}
		if (num == 0) {
			seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(FindCarsPage.FCP_DIV_MENTION).getText().trim(), "没有搜索到相应的数据");
		} else if (20 >= num && num > 0) {
			int factNum = seleniumUtil.findElementsBy(FindCarsPage.FCP_ITEM_INFOS).size();
			try {
				Assert.assertTrue(factNum == num);
			} catch (Exception e) {
				Assert.fail("个人中心查找车源的收藏个数与找车源中个人不一致！！！");
				e.printStackTrace();
				throw e;
			}
		}
	}
}
