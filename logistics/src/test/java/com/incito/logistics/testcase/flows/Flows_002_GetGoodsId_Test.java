package com.incito.logistics.testcase.flows;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.incito.logistics.base.BaseParpare;
import com.incito.logistics.pages.HomePage;
import com.incito.logistics.pages.pageshelper.HomePageHelper;
import com.incito.logistics.pages.pageshelper.LoginPageHelper;
import com.incito.logistics.pages.pageshelper.MyGoodsPageHelper;
import com.incito.logistics.util.ExcelDataProvider;
import com.incito.logistics.util.JdbcUtil;
import com.incito.logistics.util.PropertiesDataProvider;

/**
 * @author xy-incito-wy
 * @Description 辅助001测试，获取刚才发的的货源在数据库中的id
 * */
public class Flows_002_GetGoodsId_Test extends BaseParpare {

	@Test(dataProvider = "data")
	public void getGoodsID(ITestContext context, Map<String, String> data) {
		String userInfoPath = context.getCurrentXmlTest().getParameter("userInfoPath");
		String username = PropertiesDataProvider.getTestData(userInfoPath, "username");
		String password = PropertiesDataProvider.getTestData(userInfoPath, "password");
		int timeOut = Integer.valueOf(context.getCurrentXmlTest().getParameter("timeOut"));
		int sleepTime = Integer.valueOf(context.getCurrentXmlTest().getParameter("sleepTime"));

		HomePageHelper.waitHomePageToLoad(timeOut, seleniumUtil);
		HomePageHelper.enterPage(seleniumUtil, HomePage.HP_BUTTON_LOGIN);
		LoginPageHelper.waitLoginPageToLoad(timeOut, seleniumUtil);
		LoginPageHelper.login(seleniumUtil, username, password);
		LoginPageHelper.checkUserInfo(timeOut, sleepTime, seleniumUtil, username);
		HomePageHelper.enterPage(seleniumUtil, HomePage.HP_LINK_MYGOODS);
		MyGoodsPageHelper.waitMyGoodsPageToLoad(timeOut, seleniumUtil);
		String goodsno = MyGoodsPageHelper.getGoodsNo(seleniumUtil, data.get("SGP_INPUT_GOODSORIGINALCITY"), data.get("SGP_INPUT_GOODSRECEIPTCITY"), data.get("SGP_INPUT_INSTRUCTION"));
		PropertiesDataProvider.writeProperties("goodsno", goodsno);  //写入货源的编号到属性文件，便于下次读取
		String goodsid = JdbcUtil.query("select id from goods where goodsno='"+goodsno+"'");
		PropertiesDataProvider.writeProperties("goodsid", goodsid); //写入货源id到 属性文件，以便下次查询使用
		
	}
	

	@DataProvider(name = "data")
	public Iterator<Object[]> dataFortestMethod() throws IOException {
		String moduleName = null; // 模块的名字
		String caseNum = null; // 用例编号
		String className = this.getClass().getName();
		int dotIndexNum = className.indexOf("."); // 取得第一个.的index
		int underlineIndexNum = className.indexOf("_"); // 取得第一个_的index

		if (dotIndexNum > 0) {
			moduleName = className.substring(30, className.lastIndexOf(".")); // 取到模块的名称
		}

		if (underlineIndexNum > 0) {
			caseNum = className.substring(underlineIndexNum + 1, underlineIndexNum + 4); // 取到用例编号
		}
		// 将模块名称和用例的编号传给 ExcelDataProvider ，然后进行读取excel数据
		return new ExcelDataProvider(moduleName, caseNum);
	}

}
