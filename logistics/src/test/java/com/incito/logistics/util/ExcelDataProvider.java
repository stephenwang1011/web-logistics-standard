package com.incito.logistics.util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.testng.Assert;

import jxl.*;

/**
 * @author xy-incito-wangyang
 *  @description: 读取Excel数据<br>
 * 说明：<br>
 * Excel放在Data文件夹下<br>
 * Excel命名方式：测试类名.xls<br>
 * Excel的sheet命名方式：测试方法名<br>
 * Excel第一行为Map键值<br>
 */
public class ExcelDataProvider implements Iterator<Object[]> {

    private Workbook book         = null;
    private Sheet    sheet        = null;
    private int      rowNum       = 0;
    private int      currentRowNo = 0;
    private int      columnNum    = 0;
    private String[] columnnName;

    public ExcelDataProvider(String classname, String funnctionFolder) {

        try {

            int dotNum = classname.indexOf(".");

            if (dotNum > 0) {
                classname = classname.substring(classname.lastIndexOf(".") + 1,
                        classname.length());
            }

            String path = "data/"+funnctionFolder+"/" + classname + ".xls";
            InputStream inputStream = new FileInputStream(path);

            book = Workbook.getWorkbook(inputStream);
            // sheet = book.getSheet(methodname);
            sheet = book.getSheet(0);//获取第一个table（sheet）
            rowNum = sheet.getRows();//获取所有的行
            Cell[] cell = sheet.getRow(0);//获取所有的列
            columnNum = cell.length;//获取列的总数
            columnnName = new String[cell.length];//定义一个列数组(定义了几行)

            for (int i = 0; i < cell.length; i++) {
                columnnName[i] = cell[i].getContents().toString();
            }
            this.currentRowNo++;

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("unable to read Excel data");
        }
    }

    public boolean hasNext() {

        if (this.rowNum == 0 || this.currentRowNo >= this.rowNum) {

            try {
                book.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;
        } else {
            // sheet下一行内容为空判定结束
            if ((sheet.getRow(currentRowNo))[0].getContents().equals(""))
                return false;
            return true;
        }
    }

    public Object[] next() {

        Cell[] c = sheet.getRow(this.currentRowNo);
        Map<String, String> data = new HashMap<String, String>();
        // List<String> list = new ArrayList<String>();

        for (int i = 0; i < this.columnNum; i++) {

            String temp = "";

            try {
                temp = c[i].getContents().toString();
            } catch (ArrayIndexOutOfBoundsException ex) {
                temp = "";
            }

            // if(temp != null&& !temp.equals(""))
            // list.add(temp);
            data.put(this.columnnName[i], temp);
        }
        Object object[] = new Object[1];
        object[0] = data;
        this.currentRowNo++;
        return object;
    }

    public void remove() {
        throw new UnsupportedOperationException("remove unsupported.");
    }
}