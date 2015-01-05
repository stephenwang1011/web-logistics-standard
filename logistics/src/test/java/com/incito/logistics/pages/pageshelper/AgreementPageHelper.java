package com.incito.logistics.pages.pageshelper;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

import com.incito.logistics.pages.AgreementPage;
import com.incito.logistics.util.SeleniumUtil;

public class AgreementPageHelper {
	public static Logger logger = Logger.getLogger(AgreementPageHelper.class.getName());
	static int times = 0;

	/** 等待协议上元素显示出来 */
	public static void waitAgreementPageToLoad(int timeOut, SeleniumUtil seleniumUtil) {
		logger.info("开始检查协议页面元素");
		seleniumUtil.waitForElementToLoad(timeOut, AgreementPage.AP_BUTTON_CLOSE);
		seleniumUtil.waitForElementToLoad(timeOut, AgreementPage.AP_TEXT_CONTENT);
		seleniumUtil.waitForElementToLoad(timeOut, AgreementPage.AP_TEXT_TITLE);
		logger.info("检查协议页面元素完毕");
	}

	/** 检查首页上的文本 */
	public static void checkAgreementPageText(SeleniumUtil seleniumUtil) {
		logger.info("检查协议页面文本");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AgreementPage.AP_TEXT_TITLE).getText(), "智慧物流网站注册协议");
		FooterPageHelper.checkFooterPageText(seleniumUtil);
		logger.info("检查协议页面文本完毕");

	}

	
	/**点击关闭按钮,点击15次，最后的一次点击才关闭 才正确*/
	public static void click15TimesCloseButton(SeleniumUtil seleniumUtil){
		WebElement e = seleniumUtil.findElementBy(AgreementPage.AP_BUTTON_CLOSE);
		try{
		e.click();
		}catch(WebDriverException wde){
			
			times++;
			logger.info("已经点了"+times+"次");
			seleniumUtil.pause(1000);
			click15TimesCloseButton(seleniumUtil);
			
		}


		
	}
	
	
	
	
	
}
