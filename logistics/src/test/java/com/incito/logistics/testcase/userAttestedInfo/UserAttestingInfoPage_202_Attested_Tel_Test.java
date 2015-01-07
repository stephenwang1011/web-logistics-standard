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
 * @Description 已认证用户页面上，填写修改联系电话
 *
 * */
public class UserAttestingInfoPage_202_Attested_Tel_Test extends UserAttestedInfoAttestedFather {
	@Test(dataProvider = "data")
	public void UserAttestingInfoPageAttestedTelTest(ITestContext context, Map<String, String> data) {
		UserAttestedInfoAttestedFather.userAtestedInfoParpare(context, seleniumUtil);

		UserAttestedInfoPagerHelper.enterPage(seleniumUtil, UserAttestedInfoPage.UAIP_BUTTON_MODIFY);
		//使其出现短信验证码
		seleniumUtil.clear(seleniumUtil.findElementBy(UserAttestedInfoPage.UAIP_INPUT_TEL));
		seleniumUtil.type(seleniumUtil.findElementBy(UserAttestedInfoPage.UAIP_INPUT_TEL), "15316225342");
		UserAttestedInfoPagerHelper.enterPage(seleniumUtil, UserAttestedInfoPage.UAIP_BUTTON_MODIFY);
		seleniumUtil.clear(seleniumUtil.findElementBy(UserAttestedInfoPage.UAIP_INPUT_TEL));
		
		By[] bys={UserAttestedInfoPage.UAIP_INPUT_TEL, UserAttestedInfoPage.UAIP_INPUT_PHOTO,
				UserAttestedInfoPage.UAIP_INPUT_CHIT, UserAttestedInfoPage.UAIP_BUTTON_CHIT };
		UserAttestedInfoPagerHelper.typeTelChit(seleniumUtil, bys, data.get("ADD_TEL"), 
				data.get("ADD_PHOTO"), data.get("ADD_CHIT"));
		
		UserAttestedInfoPagerHelper.enterPage(seleniumUtil, UserAttestedInfoPage.UAIP_BUTTON_MODIFY);
		UserAttestedInfoPagerHelper.checkUserAttestedInfoPageModifyFail(seleniumUtil);
	}
}
