package com.incito.logistics.testcase.personcenter;

/**
 *@author  xy-incito-wk
 *@Description 测试用例：已登录的情况下，未认证的用户登录，点击我的订单中待评价，查看连接跳转并检查状态
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

public class PensonCenterPage_007_UnattestedUserSkipMyOrdersToBeEvaluated_Test extends PensonCenterUnatestedFather {
	@Test
	public void personCenterMyOrdersPendingPayment(ITestContext context) {
		PensonCenterUnatestedFather.UnattestedPensonCenterParpare(context, seleniumUtil);

		int num = Integer.valueOf(seleniumUtil.findElementsBy(PersonCenterPage.PCP_LINK_MYGOODSALLGOODS).get(1).findElements(By.tagName("p")).get(0).getText());

		seleniumUtil.findElementsBy(PersonCenterPage.PCP_LINK_MYGOODSALLGOODS).get(1).click();
		MyOrdersPageHelper.waitForMyOrdersPageToLoad(seleniumUtil, timeOut);
		String selected = seleniumUtil.findElementBy(MyOrdersPage.MOP_SPAN_TABS_TOBEEVALUATED).getAttribute("class");
		try {
			Assert.assertTrue(selected.equals("in-sortbox-active"));
		} catch (Exception e) {
			Assert.fail("在我的订单页面中‘待评价’没有被选中。");
			e.printStackTrace();
			throw e;
		}
		if (num == 0) {
			seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(MyGoodsPage.MGP_TEXT_NOINFO).getText().trim(), "没有搜索到相应的数据");
		}else{
			try {
				Assert.assertTrue(false);
			} catch (Exception e) {
				Assert.fail("在我的订单页面中‘待评价’中未认证的用户含有新货源！！！");
				e.printStackTrace();
				throw e;
			}
		}
	}
}
