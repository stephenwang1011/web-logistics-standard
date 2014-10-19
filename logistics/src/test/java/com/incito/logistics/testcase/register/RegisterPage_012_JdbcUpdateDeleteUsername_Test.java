package com.incito.logistics.testcase.register;

import org.testng.annotations.Test;

import com.incito.logistics.util.Jdbc_CURD;

public class RegisterPage_012_JdbcUpdateDeleteUsername_Test extends Jdbc_CURD {
	@Test
	public void jdbcUpdate() {
		String sql = "DELETE FROM smartdb.agent WHERE username = 'GOGOGO'";
		delete(sql);
	}

}

