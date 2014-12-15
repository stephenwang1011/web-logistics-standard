package com.incito.logistics.testcase.flows;

import org.testng.ITestContext;
import org.testng.annotations.Test;
import com.incito.logistics.util.HttpRequestUtil;
import com.incito.logistics.util.PropertiesDataProvider;

/**
 * @author xy-incito-wy
 * @Description 预定指定的货源
 * */
public class Flows_003_OrderGoodsById_Test {

	@Test
	public void orderGoods(ITestContext context) {
		String GoodsInfo = context.getCurrentXmlTest().getParameter("GoodsInfo");
		String goodsid = PropertiesDataProvider.getTestData(GoodsInfo, "goodsid");

		HttpRequestUtil.post("http://192.168.11.201:8080/logistics/goods/destineGoods?imei=A0000002FF7099",
				"{\"goodsid\":\"" + goodsid + "\",\"carid\":\"a5cf1b6065ef468e84242ded4c9bc7f6\"}");

	}

}
