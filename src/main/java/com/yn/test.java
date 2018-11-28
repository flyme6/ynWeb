package com.yn;

import com.csvreader.CsvWriter;

import java.io.IOException;
import java.nio.charset.Charset;

public class test {

    public static void main(String args[]) {

        String filePath = "yntest.csv";

        try {
            // 创建CSV写对象
            CsvWriter csvWriter = new CsvWriter(filePath, ',', Charset.forName("GBK"));
            //CsvWriter csvWriter = new CsvWriter(filePath);

            // 写表头
            String[] headers = {"编号", "姓名", "年龄"};
            String[] content = {"12365", "张山", "34"};

            csvWriter.writeRecord(headers);
            csvWriter.writeRecord(content);
            csvWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
