package com.incito.logistics.testcase.findgoods;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.FindGoodsPage;
import com.incito.logistics.pages.pageshelper.FindGoodsPageHelper;
import com.incito.logistics.plugins.father.FindGoodsUnatestedFather;

/**
 * 
 * @author xy-incito-wk
 * @Description 测试用例：已登录的情况下，未认证的用户登录，收藏的货源在我的收藏中查看
 */
public class FindGoodsPagePrivateGoods_101_UnattestedUserCheckCollection_Test extends FindGoodsUnatestedFather {
	@Test
	public void FindGoodsPagePublicGoodsInfoCheck(ITestContext context) {
		FindGoodsUnatestedFather.UnattestedFindGoodsParpare(context, seleniumUtil);
		String publicGoodsId = FindGoodsPageHelper.firstGoodsId(seleniumUtil, FindGoodsPage.FGP_ITEM_GOODS, FindGoodsPage.FGP_HIDE_ATTESTED);
		String firstButtonTest = seleniumUtil.findElementsBy(FindGoodsPage.FGP_GOODS_BUTTON_MYFAVOANDCANCEL).get(0).getText();
		if (firstButtonTest.equals("收藏")) {
			seleniumUtil.click(seleniumUtil.findElementsBy(FindGoodsPage.FGP_GOODS_BUTTON_MYFAVO).get(0));
		}
		FindGoodsPageHelper.enterPage(seleniumUtil, FindGoodsPage.FGP_BUTTON_MYFAVORITES);
		FindGoodsPageHelper.waitFindGoodsPageToLoad(timeOut, seleniumUtil);

		String[] allGoodsIds = FindGoodsPageHelper.allGoodsId(seleniumUtil, FindGoodsPage.FGP_ITEM_GOODS, FindGoodsPage.FGP_HIDE_ATTESTED);
		String all = "";
		for (int i = 0; i < allGoodsIds.length; i++) {
			all = all + "第" + (i + 1) + "个货源编号为：" + allGoodsIds[i] + ";";
		}
		seleniumUtil.isContains(all, publicGoodsId);
		FindGoodsPageHelper.FavoGoodsChangepublicGoods(seleniumUtil, FindGoodsPage.FGP_GOODS_BUTTON_CANCELMYFAVO);
	}
}