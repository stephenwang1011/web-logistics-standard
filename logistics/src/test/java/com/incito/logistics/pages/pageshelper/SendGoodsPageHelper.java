package com.incito.logistics.pages.pageshelper;

import org.apache.log4j.Logger;

import com.incito.logistics.pages.SendGoodsPage;
import com.incito.logistics.util.SeleniumUtil;

public class SendGoodsPageHelper {
	public static Logger logger = Logger.getLogger(SendGoodsPageHelper.class.getName());

	/** 等待发布货源页面上某个重要元素显示出来 */
	public static void waitSendGoodsPageToLoad(int timeOut, SeleniumUtil seleniumUtil) {
		
		logger.info("Start checking SendGoods Page elements");
		seleniumUtil.waitForElementToLoad(timeOut, SendGoodsPage.SGP_INPUT_GOODSORIGINALCITY);
		seleniumUtil.waitForElementToLoad(timeOut, SendGoodsPage.SGP_INPUT_GOODSRECEIPTCITY);
		seleniumUtil.waitForElementToLoad(timeOut, SendGoodsPage.SGP_INPUT_GOODSNAME);
		seleniumUtil.waitForElementToLoad(timeOut, SendGoodsPage.SGP_INPUT_GOODSDETAILS);
		seleniumUtil.waitForElementToLoad(timeOut, SendGoodsPage.SGP_BUTTON_HEAVYGOODS);
		seleniumUtil.waitForElementToLoad(timeOut, SendGoodsPage.SGP_BUTTON_DEVICEGOODS);
		seleniumUtil.waitForElementToLoad(timeOut, SendGoodsPage.SGP_BUTTON_LIGHTGOODS);
		seleniumUtil.waitForElementToLoad(timeOut, SendGoodsPage.SGP_INPUT_WEIGHT);
		seleniumUtil.waitForElementToLoad(timeOut, SendGoodsPage.SGP_INPUT_CARLENGTH);
		seleniumUtil.waitForElementToLoad(timeOut, SendGoodsPage.SGP_INPUT_CARTYPE);
		seleniumUtil.waitForElementToLoad(timeOut, SendGoodsPage.SGP_INPUT_COUNT);
		seleniumUtil.waitForElementToLoad(timeOut, SendGoodsPage.SGP_INPUT_FARE);
		seleniumUtil.waitForElementToLoad(timeOut, SendGoodsPage.SGP_INPUT_DECLAREVALUE);
		seleniumUtil.waitForElementToLoad(timeOut, SendGoodsPage.SGP_INPUT_INFOFARE);
		seleniumUtil.waitForElementToLoad(timeOut, SendGoodsPage.SGP_BUTTON_GOODSDATE);
		seleniumUtil.waitForElementToLoad(timeOut, SendGoodsPage.SGP_BUTTON_SEND);
		seleniumUtil.waitForElementToLoad(timeOut, SendGoodsPage.SGP_BUTTON_RESET);
		seleniumUtil.waitForElementToLoad(timeOut, SendGoodsPage.SGP_INPUT_INSTRUCTION);
		logger.info("Checking SendGoods Page elements completed");
	}

	/** 检查发布货源页面页面上的文本 */
	public static void checkSendGoodsPageText(SeleniumUtil seleniumUtil) {
		logger.info("Starting checking sendgoods page text");
		seleniumUtil.isTextCorrect(seleniumUtil.getTitle(), "logistics - 物流管理");

		FooterPageHelper.checkFooterPageText(seleniumUtil);
		logger.info("Checking sendgoods page text completed");
	}

}
