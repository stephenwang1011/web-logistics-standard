package com.incito.logistics.testcase.userPassword;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.incito.logistics.util.ExcelDataProvider;
import com.incito.logistics.util.JdbcUtil;

/**
 * 
 * @author xy-incito-wy
 * @Description 还原用户的默认密码
 */
public class UserPasswordPage_316_AttestRejectResetPassword_Test extends JdbcUtil {
	@Test(dataProvider="data")
	public void jdbcUpdate(ITestContext context,Map<String,String> data){
		String sql = "UPDATE smartdb.agent SET password  = "+"'"+data.get("RESTPASSWORD")+"'"+"where id = "+"'"+data.get("USERID")+"'";
		update(sql);
	}

	@DataProvider(name = "data")
	public  Iterator<Object[]> dataFortestMethod() throws IOException {
		String moduleName = null; //模块的名字
		String caseNum = null;  //用例编号
		String className = this.getClass().getName();
		 int dotIndexNum = className.indexOf("."); //取得第一个.的index 
		 int underlineIndexNum = className.indexOf("_");  //取得第一个_的index 
		 
		 if (dotIndexNum > 0) {
			 moduleName = className.substring(30,className.lastIndexOf(".")); //取到模块的名称
		 }
		 
		 if (underlineIndexNum > 0) {
			 caseNum = className.substring(underlineIndexNum+1, underlineIndexNum+4); //取到用例编号
		 }
		//将模块名称和用例的编号传给 ExcelDataProvider ，然后进行读取excel数据
		return new ExcelDataProvider(moduleName, caseNum);
	}
}

