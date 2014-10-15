package com.incito.logistics.testcase.database.jdbc;

import org.testng.annotations.Test;

import com.incito.logistics.util.Jdbc_CURD;

public class JdbcUpdate extends Jdbc_CURD {
	@Test
	public void jdbcUpdate() {
		String sql = "UPDATE smartdbtest.agent SET name = NULL, tel = NULL, icard = NULL, company = NULL, province = NULL, city = NULL, region = NULL, address = NULL, status = 1 WHERE  username = 'wangkai'";
		update(sql);
	}

}
