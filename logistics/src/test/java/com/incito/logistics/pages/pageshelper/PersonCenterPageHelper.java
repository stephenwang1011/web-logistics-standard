package com.incito.logistics.pages.pageshelper;

import com.incito.logistics.pages.PersonCenterPage;
import com.incito.logistics.util.SeleniumUtil;

public class PersonCenterPageHelper {
	// 等待页面上某个重要元素显示出来
	public static void waitPCPageToLoad(int timeOut, SeleniumUtil seleniumUtil) {
		seleniumUtil.waitForElementToLoad(timeOut, PersonCenterPage.PCP_TEXT_BODY);

	}

}
