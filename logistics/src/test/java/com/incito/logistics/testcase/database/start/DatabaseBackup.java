package com.incito.logistics.testcase.database.start;

import java.io.File;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.util.Database;
import com.incito.logistics.util.PropertiesDataProvider;

/**
 * @author xy-incito-wk
 * @Description 备份数据库，且导入自动化测试环境所需要的数据库
 */
public class DatabaseBackup extends Database {
	@Test
	public void databaseBackup_start(ITestContext context) {
		String configFilePath = String.valueOf(context.getCurrentXmlTest().getParameter("databasePath"));
		String databaseIp = PropertiesDataProvider.getTestData(configFilePath, "databaseIp");
		String databaseRoot = PropertiesDataProvider.getTestData(configFilePath, "databaseRoot");
		String databasePassword = PropertiesDataProvider.getTestData(configFilePath, "databasePassword");
		String databaseName = PropertiesDataProvider.getTestData(configFilePath, "databaseName");

		Database bak = new Database(databaseIp, databaseRoot, databasePassword);
		// bak.backup(new File("res/db/backup/testback.sql"), "smartdb");//1.备份数据的路径及文件名称；2.需要备份的数据库名称
		bak.restore(new File("res/db/restore/autorestore.sql"), databaseName);// 1.还原那个版本的数据库脚本；2.还原数据库的名称

	}
}