package com.incito.logistics.testcase.register;

import org.testng.annotations.Test;

import com.incito.logistics.util.JdbcUtil;

public class RegisterPage_012_JdbcUpdateDeleteUsername_Test extends JdbcUtil {
	@Test
	public void jdbcUpdate() {
		String sql = "DELETE FROM smartdb.agent WHERE username = 'GOGOGO'";
		delete(sql);
	}

}

