package com.incito.logistics.testcase.userBaseInfo;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.UserBaseInfoPage;
import com.incito.logistics.pages.pageshelper.UserBaseInfoPagerHelper;
import com.incito.logistics.plugins.father.UserBaseInfoUnattestedFather;

/**
 * @author xy-incito-wk
 * @Description 未认证的用户，进入我的资料-基本信息模块,只修改基本信息中的头像
 *
 * */
public class UserBaseInfoPage_004_Unattested_Photo_Test extends UserBaseInfoUnattestedFather {
	@Test
	public void modifyUserPhotoForUnattestedUser(ITestContext context) {
		UserBaseInfoUnattestedFather.userBaseInfoParpare(context, seleniumUtil, true);
		
		UserBaseInfoPagerHelper.upLoadPhoto(context, seleniumUtil, UserBaseInfoPage.BUIP_BUTTON_PHOTO, "res/img/userBaseInfo/自拍.png");
		UserBaseInfoPagerHelper.saveOrCancel(seleniumUtil, UserBaseInfoPage.BUIP_BUTTON_SAVE, true);
	}
}