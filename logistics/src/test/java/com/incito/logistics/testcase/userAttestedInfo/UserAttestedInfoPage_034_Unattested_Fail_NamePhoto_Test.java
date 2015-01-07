package com.incito.logistics.testcase.userAttestedInfo;

import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.UserAttestedInfoPage;
import com.incito.logistics.pages.pageshelper.UserAttestedInfoPagerHelper;
import com.incito.logistics.plugins.father.UserAttestedInfoUnattestedFather;

/**
 * @author xy-incito-wk
 * @Description 认证信息界面，未认证用户，填写信息姓名、上传证件照片
 *
 * */
public class UserAttestedInfoPage_034_Unattested_Fail_NamePhoto_Test extends UserAttestedInfoUnattestedFather {
	@Test(dataProvider = "data")
	public void UserAttestedInfoPageUnattestedFailNamePhotoTest(ITestContext context, Map<String, String> data) {
		UserAttestedInfoUnattestedFather.userUnatestedInfoParpare(context, seleniumUtil);

		seleniumUtil.type(seleniumUtil.findElementBy(UserAttestedInfoPage.UAIP_INPUT_NAME), data.get("ADD_NAME"));
		String[] filePath = { "res/img/userAuthenticationInfo/身份证正面.png",
				"res/img/userAuthenticationInfo/身份证反面.png",
				"res/img/userAuthenticationInfo/营业执照正面.png",
				"res/img/userAuthenticationInfo/营业执照反面.png" };
		UserAttestedInfoPagerHelper.upLoadPhoto(context, seleniumUtil, UserAttestedInfoPage.UAIP_INPUT_UPLOAD, filePath);
		UserAttestedInfoPagerHelper.enterPage(seleniumUtil, UserAttestedInfoPage.UAIP_BUTTON_SUBMIT);
		UserAttestedInfoPagerHelper.checkUserAuthenticationInfoPrompt(timeOut, seleniumUtil);
	}
}
