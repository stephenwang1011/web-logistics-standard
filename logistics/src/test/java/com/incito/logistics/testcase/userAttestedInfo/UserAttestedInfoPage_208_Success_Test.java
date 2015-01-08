package com.incito.logistics.testcase.userAttestedInfo;

import java.util.Map;

import org.openqa.selenium.By;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.UserAttestedInfoPage;
import com.incito.logistics.pages.pageshelper.UserAttestedInfoPagerHelper;
import com.incito.logistics.plugins.father.UserAttestedInfoAttestedFather;

/**
 * @author xy-incito-wk
 * @Description 已认证用户页面上，填写修改联系电话、登陆密码、地址修改成功
 *
 * */
public class UserAttestedInfoPage_208_Success_Test extends UserAttestedInfoAttestedFather {
	@Test(dataProvider = "data")
	public void UserAttestingInfoPageSuccessTest(ITestContext context, Map<String, String> data) {
		UserAttestedInfoAttestedFather.userAtestedInfoParpare(context, seleniumUtil);

		UserAttestedInfoPagerHelper.enterPage(seleniumUtil, UserAttestedInfoPage.UAIP_BUTTON_MODIFY);
		//使其出现短信验证码
		seleniumUtil.clear(seleniumUtil.findElementBy(UserAttestedInfoPage.UAIP_INPUT_TEL));
		seleniumUtil.type(seleniumUtil.findElementBy(UserAttestedInfoPage.UAIP_INPUT_TEL), "15316225342");
		UserAttestedInfoPagerHelper.enterPage(seleniumUtil, UserAttestedInfoPage.UAIP_BUTTON_SAVE);
		seleniumUtil.clear(seleniumUtil.findElementBy(UserAttestedInfoPage.UAIP_INPUT_TEL));
		
		By[] bys={UserAttestedInfoPage.UAIP_INPUT_TEL, UserAttestedInfoPage.UAIP_INPUT_PHOTO,
				UserAttestedInfoPage.UAIP_INPUT_CHIT, UserAttestedInfoPage.UAIP_BUTTON_CHIT };
		UserAttestedInfoPagerHelper.typeTelChit(seleniumUtil, bys, data.get("ADD_TEL"), 
				data.get("ADD_PHOTO"), data.get("ADD_CHIT"));

		seleniumUtil.type(seleniumUtil.findElementBy(UserAttestedInfoPage.UAIP_INPUT_PASSWORD), "123456");
		seleniumUtil.address(UserAttestedInfoPage.UAIP_SELECT_PROVINCE, data.get("ADD_PROVINCE"), UserAttestedInfoPage.UAIP_SELECT_CITY, data.get("ADD_CITY"), UserAttestedInfoPage.UAIP_SELECT_REGION, data.get("ADD_REGION"), UserAttestedInfoPage.UAIP_INPUT_ADDRESS, data.get("ADD_ADDRESS"));
		
		UserAttestedInfoPagerHelper.enterPage(seleniumUtil, UserAttestedInfoPage.UAIP_BUTTON_MODIFY);
		
		seleniumUtil.pause(800);
		seleniumUtil.switchToPromptedAlertAfterWait(1000).accept();
		seleniumUtil.pause(800);

		UserAttestedInfoPagerHelper.checkUserAttestedInfoPageModifySuccess(seleniumUtil);
	}
}
