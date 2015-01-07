package com.incito.logistics.testcase.userBaseInfo;

import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.UserBaseInfoPage;
import com.incito.logistics.pages.pageshelper.UserBaseInfoPagerHelper;
import com.incito.logistics.plugins.father.UserBaseInfoAttestedFather;

/**
 * @author xy-incito-wk
 * @Description 认证用户，进入我的资料-基本信息模块，修改用户的头像并检测是不是修改成功
 *
 * */
public class UserBaseInfoPage_204_Attested_Photo_Test extends UserBaseInfoAttestedFather {
	@Test(dataProvider = "data")
	public void modifyPhotoForAttestedUser(ITestContext context, Map<String, String> data) {
		UserBaseInfoAttestedFather.userBaseInfoParpare(context, seleniumUtil, true);
		
		UserBaseInfoPagerHelper.upLoadPhoto(context, seleniumUtil, UserBaseInfoPage.BUIP_BUTTON_PHOTO, "res/img/userBaseInfo/自拍.png");
		UserBaseInfoPagerHelper.saveOrCancel(seleniumUtil, UserBaseInfoPage.BUIP_BUTTON_SAVE, true);
	}
}