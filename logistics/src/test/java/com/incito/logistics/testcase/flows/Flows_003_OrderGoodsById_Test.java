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
		String goodsInfo = context.getCurrentXmlTest().getParameter("goodsInfo");		
		String interface_flow = context.getCurrentXmlTest().getParameter("interface_flow");
		String goodsid = PropertiesDataProvider.getTestData(goodsInfo, "goodsid");
		String url = PropertiesDataProvider.getTestData(interface_flow, "order_url");

		HttpRequestUtil.post(url,"{\"goodsid\":\"" + goodsid + "\",\"carid\":\"a5cf1b6065ef468e84242ded4c9bc7f6\"}");
	}
}
