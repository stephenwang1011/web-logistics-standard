package com.incito.logistics.testcase.personcenter;

/**
 *@author  xy-incito-wk
 *@Description 测试用例：已登录的情况下，未认证的用户登录，点击我的订单中新订单，查看连接跳转并检查状态
 *
 * */
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.MyGoodsPage;
import com.incito.logistics.pages.MyOrdersPage;
import com.incito.logistics.pages.PersonCenterPage;
import com.incito.logistics.pages.pageshelper.MyOrdersPageHelper;
import com.incito.logistics.plugins.father.PensonCenterUnatestedFather;

public class PensonCenterPage_005_UnattestedUserSkipMyOrdersNewOrders_Test extends PensonCenterUnatestedFather {
	@Test
	public void personCenterMyOrdersNewOrders(ITestContext context) {
		PensonCenterUnatestedFather.UnattestedPensonCenterParpare(context, seleniumUtil);

		int num = Integer.valueOf(seleniumUtil.findElementsBy(PersonCenterPage.PCP_LINK_MYGOODSNEWGOODS).get(1).findElements(By.tagName("p")).get(0).getText());

		seleniumUtil.findElementsBy(PersonCenterPage.PCP_LINK_MYGOODSNEWGOODS).get(1).click();
		MyOrdersPageHelper.waitForMyOrdersPageToLoad(seleniumUtil, timeOut);
		String selected = seleniumUtil.findElementBy(MyOrdersPage.MOP_SPAN_TABS_BOOKEDORDERS).getAttribute("class");
		try {
			Assert.assertTrue(selected.equals("in-sortbox-active"));
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("在我的订单页面中‘已预订’没有被选中。");
		}
		if (num == 0) {
			seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(MyGoodsPage.MGP_TEXT_NOINFO).getText().trim(), "没有搜索到相应的数据");
		}else{
			try {
				Assert.assertTrue(false);
			} catch (Exception e) {
				Assert.fail("在我的订单页面中‘已预订’中未认证的用户含有新货源！！！");
			}
		}
	}
}
