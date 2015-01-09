package com.incito.logistics.testcase.userAttestedInfo;

import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.UserAttestedInfoPage;
import com.incito.logistics.pages.pageshelper.UserAttestedInfoPagerHelper;
import com.incito.logistics.plugins.father.UserAttestedInfoAttestRejectFather;

/**
 * @author xy-incito-wk
 * @Description 认证未通过信息界面填写全部信息提交
 *
 * */
public class UserAttestedInfoPage_325_UnattestedReject_NameTelIdcard_Test extends UserAttestedInfoAttestRejectFather {
	@Test(dataProvider = "data")
	public void userAttestedInfoPageUnattestedRejectNameTelIdcard_Test(ITestContext context, Map<String, String> data) {
		UserAttestedInfoAttestRejectFather.userAtestRejectInfoParpare(context, seleniumUtil);
		
		UserAttestedInfoPagerHelper.updateUserAttestRejectInfo(context, seleniumUtil, 
				data.get("UPDATE_NAME"), data.get("UPDATE_TEL"),
				data.get("UPDATE_PHOTO"), data.get("UPDATE_CHIT"),
				data.get("UPDATE_PASSWORD"), data.get("UPDATE_IDCARD"),
				data.get("UPDATE_COMPANY"), data.get("UPDATE_PROVINCE"),
				data.get("UPDATE_CITY"), data.get("UPDATE_REGION"), 
				data.get("UPDATE_ADDRESS"), data.get("UPDATE_IDPHOTO"));
		UserAttestedInfoPagerHelper.saveAndAccept(seleniumUtil, UserAttestedInfoPage.UAIP_BUTTON_SUBMIT);
		UserAttestedInfoPagerHelper.checkUserAuthenticationInfoPrompt(timeOut, seleniumUtil);
		
		UserAttestedInfoPagerHelper.checkSubmitPrompt(seleniumUtil, UserAttestedInfoPage.UAIP_TEXT_NOTE_ATTESTING);
		UserAttestedInfoPagerHelper.checkUserAttestingInfo(seleniumUtil, 
				data.get("CHECK_NAME"), data.get("CHECK_TEL"),
				data.get("CHECK_IDCARD"), data.get("CHECK_COMPANY"),
				data.get("CHECK_ADDRESS"), data.get("CHECK_IDPHOTO"), 
				data.get("UPDATE_IDPHOTO"));
	}
}
