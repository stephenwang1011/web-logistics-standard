package com.incito.logistics.testcase.adduserinfo;

import org.testng.annotations.Test;

import com.incito.logistics.util.Jdbc_CURD;

public class AddUserInfoPage_034_JdbcUpdateDeleteAddUseInfo_Test extends Jdbc_CURD {
	@Test
	public void jdbcUpdate() {
		String sql = "UPDATE smartdb.agent SET name = NULL, tel = NULL, icard = NULL, company = NULL, province = NULL, city = NULL, region = NULL, address = NULL, status = 1 WHERE  username = 'wangkai'";
		update(sql);
	}

}
