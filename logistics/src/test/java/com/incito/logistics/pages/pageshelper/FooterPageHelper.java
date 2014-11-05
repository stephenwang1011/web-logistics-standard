package com.incito.logistics.pages.pageshelper;

import org.apache.log4j.Logger;

import com.incito.logistics.pages.HomePage;
import com.incito.logistics.util.SeleniumUtil;

public class FooterPageHelper {
	public static Logger logger = Logger.getLogger(HomePageHelper.class.getName());

	/** 检查底部相关信息：关于我们，联系我们，帮助中心等 */
	public static void checkFooterPageText(SeleniumUtil seleniumUtil) {
		logger.info("Start checking footer page elements");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(HomePage.HP_TEXT_FOOTER).getText(), "联系我们 | 关于我们 | 帮助中心" + "\n" + "Incito Information Technology Co.,Ltd 2014 Incito Co.,Ltd." + "\n" + "©2014 Incito Co.,Ltd.All rights reserved." + "\n" + "鄂ICP备13016476号 公司邮箱：wuliu@incito.com.cn 客服热线：400-860-3060");
		logger.info("Checking footer page elements completed");
	}

}
