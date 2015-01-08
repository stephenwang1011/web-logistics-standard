package com.incito.logistics.testcase.userBaseInfo;

import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.UserBaseInfoPage;
import com.incito.logistics.pages.pageshelper.UserBaseInfoPagerHelper;
import com.incito.logistics.plugins.father.UserBaseInfoAttestRejectFather;

/**
 * @author xy-incito-wk
 * @Description 认证驳回的用户，进入我的资料-基本信息模块，修改用户的email并检测是不是修改成功过
 *
 * */
public class UserBaseInfoPage_307_AttestReject_Email_Test extends UserBaseInfoAttestRejectFather {
	@Test(dataProvider = "data")
	public void modifyEmailForAttestRejectUser(ITestContext context, Map<String, String> data) {
		UserBaseInfoAttestRejectFather.userBaseInfoParpare(context, seleniumUtil, true);

		UserBaseInfoPagerHelper.typeUserBaseInfo(seleniumUtil, 
				data.get("BUIP_TEXT_SEX"), data.get("BUIP_INPUT_BIRTHDAY"),
				data.get("BUIP_INPUT_QQ"), data.get("BUIP_INPUT_EMAIL"));
		UserBaseInfoPagerHelper.saveOrCancel(seleniumUtil, UserBaseInfoPage.BUIP_BUTTON_SAVE, true);
		seleniumUtil.waitForElementToLoad(timeOut, UserBaseInfoPage.UBIP_TITLE_USERINFO);
		UserBaseInfoPagerHelper.checkUserBaseInfo(seleniumUtil, 
				data.get("BUIP_TEXT_SEX"), data.get("BUIP_INPUT_BIRTHDAY"),
				data.get("BUIP_INPUT_QQ"), data.get("BUIP_INPUT_EMAIL"));
	}
}