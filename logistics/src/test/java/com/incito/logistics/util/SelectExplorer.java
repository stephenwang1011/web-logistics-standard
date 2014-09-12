package com.incito.logistics.util;

/**
 * @author wangyang
 * @Description 这是一个选择平台和浏览器的操作
 * 
 * */
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.ITestContext;
/**
 * @author xy-incito-wangyang
 * @decription 在不同的平台上选择对应的浏览器
 * */
public class SelectExplorer {
	static Logger logger = Logger.getLogger(SelectExplorer.class.getName());

	public WebDriver selectExplorerByName(String browser, ITestContext context, String platform) {
		String driverConfgFilePath = context.getCurrentXmlTest().getParameter("driverConfgFilePath");
		/** 声明好驱动的路径 */
		String chromedriver_win = PropertiesDataProvider.getTestData(driverConfgFilePath, "chromedriver_win");
		String chromedriver_linux = PropertiesDataProvider.getTestData(driverConfgFilePath, "chromedriver_linux");
		String chromedriver_mac = PropertiesDataProvider.getTestData(driverConfgFilePath, "chromedriver_mac");
		String iedriver = PropertiesDataProvider.getTestData(driverConfgFilePath, "iedriver");

		Properties props = System.getProperties(); // 获得系统属性集
		String osName = props.getProperty("os.name"); // 操作系统名称
//		if(osName!=platform.toLowerCase()){
//			logger.error("The platform you selected is ["+platform+"] and conflict with current ["+osName+"] os,please change the platform in testng xml");
//			Assert.fail("The platform you selected is ["+platform+"] and conflict with current ["+osName+"] os,please change the platform in testng xml");
//		}
		switch (platform.toLowerCase()) {

		case "win":
			if (browser.equalsIgnoreCase("ie")) {
				System.setProperty("webdriver.ie.driver", iedriver);
				DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
				ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
				return new InternetExplorerDriver(ieCapabilities);
			} else if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", chromedriver_win);
				return new ChromeDriver();
			} else if (browser.equalsIgnoreCase("firefox")) {
				return new FirefoxDriver();

			} else {

				logger.error("[" + browser + "]" + " explorer does not apply to  " + osName + " OS");
				Assert.fail("[" + browser + "]" + " explorer does not apply to  " + osName + " OS");

			}
			break;

		case "linux":
			if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", chromedriver_linux);
				return new ChromeDriver();

			} else if (browser.equalsIgnoreCase("firefox")) {
				return new FirefoxDriver();
			}else if(browser.equalsIgnoreCase("ie")){
				logger.error( "iexplorer does not apply to  " + platform + " OS");
				Assert.fail( "iexplorer does not apply to  " + platform + " OS");
			} 
			else {
				logger.error("[" + browser + "]" + " explorer does not apply to  " + osName + " OS");
				Assert.fail("[" + browser + "]" + " explorer does not apply to  " + osName + " OS");
			}
			break;

		case "mac":
			if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", chromedriver_mac);
				return new ChromeDriver();
			} else if (browser.equalsIgnoreCase("firefox")) {
				return new FirefoxDriver();
			}else if(browser.equalsIgnoreCase("ie")){
				logger.error( "iexplorer does not apply to  " + platform + " OS");
				Assert.fail( "iexplorer does not apply to  " + platform + " OS");
			} else {
				logger.error("[" + browser + "]" + " explorer does not apply to  " + osName + " OS");
				Assert.fail("[" + browser + "]" + " explorer does not apply to  " + osName + " OS");
			}
			break;

		default:
			logger.error("The platfrom that you selected" + " [" + platform + "] " + "was not supported!");
			Assert.fail("The platfrom that you selected" + " [" + platform + "] " + "was not supported!");
			break;
		}

		return null;

	}

}
