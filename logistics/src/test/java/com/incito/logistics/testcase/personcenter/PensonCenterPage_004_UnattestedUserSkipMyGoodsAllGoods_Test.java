package com.incito.logistics.testcase.personcenter;

/**
 *@author  xy-incito-wk
 *@Description 测试用例：已登录的情况下，未认证的用户登录，点击累计发布，查看连接跳转并检查状态
 *
 * */
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.MyGoodsPage;
import com.incito.logistics.pages.PersonCenterPage;
import com.incito.logistics.pages.pageshelper.MyGoodsPageHelper;
import com.incito.logistics.plugins.father.PensonCenterUnatestedFather;

public class PensonCenterPage_004_UnattestedUserSkipMyGoodsAllGoods_Test extends PensonCenterUnatestedFather {
	@Test
	public void personCenterMyGoodsAllGoods(ITestContext context) {
		PensonCenterUnatestedFather.UnattestedPensonCenterParpare(context, seleniumUtil);

		int num = Integer.valueOf(seleniumUtil.findElementsBy(PersonCenterPage.PCP_LINK_MYGOODSALLGOODS).get(0).findElements(By.tagName("p")).get(0).getText());

		seleniumUtil.findElementsBy(PersonCenterPage.PCP_LINK_MYGOODSALLGOODS).get(0).click();
		MyGoodsPageHelper.waitMyGoodsPageToLoad(timeOut, seleniumUtil);
		boolean selected = seleniumUtil.findElementBy(MyGoodsPage.MGP_RADIOBOX_GOODSTYPE_ALL).isSelected();
		try {
			Assert.assertTrue(selected);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("在我的货源页面中‘已失效货源’没有被选中。");
		}
		if (num == 0) {
			seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(MyGoodsPage.MGP_TEXT_NOINFO).getText().trim(), "没有搜索到相应的数据");
		}else{
			try {
				Assert.assertTrue(false);
			} catch (Exception e) {
				Assert.fail("在我的货源页面中‘已失效货源’中未认证的用户含有新货源！！！");
			}
		}
	}
}
