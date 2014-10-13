package com.incito.logistics.testcase.database.start;

import java.io.File;

import org.testng.annotations.Test;

import com.incito.logistics.util.Database;

/**
 * @author xy-incito-wk
 * @Description 备份数据库，且导入自动化测试环境所需要的数据库
 */
public class DatabaseBackup extends Database {
	@Test
	public void DatabaseBackup_start() {
		Database bak = new Database("192.168.11.140", "root", "p@ssw0rd");
		bak.backup(new File("res/db/backup/testback.sql"), "smartdbtest");// 1.备份数据的路径及文件名称；2.需要备份的数据库名称
		bak.restore(new File("res/db/restore/autoRestore.sql"), "smartdbtest");// 1.还原那个版本的数据库脚本；2.还原数据库的名称
	}
}