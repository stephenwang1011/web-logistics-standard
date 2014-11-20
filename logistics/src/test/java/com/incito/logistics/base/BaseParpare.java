package com.incito.logistics.base;

/**
 * @author xy-incito-wy
 * @Description 测试开始 和 测试结束 的操作
 * 
 * */
import junit.framework.Assert;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriverException;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.incito.logistics.util.SeleniumUtil;

public class BaseParpare {
	static Logger logger = Logger.getLogger(BaseParpare.class.getName());
	protected SeleniumUtil seleniumUtil = null;
	// 添加成员变量来获取beforeClass传入的context参数
	protected ITestContext testContext = null;

	@BeforeClass
	/**启动浏览器并打开测试页面*/
	public void startTest(ITestContext context) {
		seleniumUtil = new SeleniumUtil();
		// 这里得到了context值
		this.testContext = context;
		String browserName = context.getCurrentXmlTest().getParameter("browserName");

		try {
			seleniumUtil.launchBrowser(browserName, context);
		} catch (WebDriverException e) {
			seleniumUtil.quit();
			logger.error("浏览器不能正常工作，请检查是不是被手动关闭或者其他原因");
			Assert.fail("浏览器不能正常工作，请检查是不是被手动关闭或者其他原因");
		}
		// 设置一个testng上下文属性，将driver存起来，之后可以使用context随时取到
		testContext.setAttribute("SELENIUM_DRIVER", seleniumUtil.driver);
	}

	@AfterClass
	/**结束测试关闭浏览器*/
	public void endTest() {
		if (seleniumUtil.driver != null) {
			seleniumUtil.quit();
		} else {
			logger.error("浏览器driver没有获得对象,退出操作失败");
			Assert.fail("浏览器driver没有获得对象,退出操作失败");

		}
	}

}
