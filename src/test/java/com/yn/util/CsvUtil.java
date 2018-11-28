package com.yn.util;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * 文件操作
 *
 * @author qiulinhe
 * @version 2016年12月23日14:21:39
 */
public class CsvUtil {

    /**
     * 生成为CVS文件
     *
     * @param exportData 源数据List
     * @param fileds
     * @param map        csv文件的列表头map
     * @param outPutPath 文件路径
     * @param fileName   文件名称
     * @return
     */
    @SuppressWarnings("rawtypes")
    public static File createCSVFile(List exportData, String[] fileds,
                                     LinkedHashMap map, String outPutPath, String fileName) {
        File csvFile = null;
        BufferedWriter csvFileOutputStream = null;
        try {
            File file = new File(outPutPath);
            if (!file.exists()) {
                file.mkdir();
            }
            // 定义文件名格式并创建
            csvFile = File.createTempFile(fileName, ".csv",
                    new File(outPutPath));
            System.out.println("csvFile：" + csvFile);
            // UTF-8使正确读取分隔符","
            csvFileOutputStream = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(csvFile), "GBK"), 1024);
            System.out.println("csvFileOutputStream：" + csvFileOutputStream);
            // 写入文件头部
            for (Iterator propertyIterator = map.entrySet().iterator(); propertyIterator
                    .hasNext(); ) {
                java.util.Map.Entry propertyEntry = (java.util.Map.Entry) propertyIterator
                        .next();
                csvFileOutputStream
                        .write((String) propertyEntry.getValue() != null ? new String(
                                ((String) propertyEntry.getValue())
                                        .getBytes("GBK"), "GBK") : "");
                if (propertyIterator.hasNext()) {
                    csvFileOutputStream.write(",");
                }
                System.out.println(new String(((String) propertyEntry
                        .getValue()).getBytes("GBK"), "GBK"));
            }
            csvFileOutputStream.write("\r\n");
            // 写入文件内容,
            // ============ //第一种格式：Arraylist<实体类>填充实体类的基本信息==================
            for (int j = 0; exportData != null && !exportData.isEmpty()
                    && j < exportData.size(); j++) {
                BankWageMonth t = (BankWageMonth) exportData.get(j);
                Class clazz = t.getClass();
                String[] contents = new String[fileds.length];
                for (int i = 0; fileds != null && i < fileds.length; i++) {
                    String filedName = toUpperCaseFirstOne(fileds[i]);
                    Method method = clazz.getMethod(filedName);
                    method.setAccessible(true);
                    Object obj = method.invoke(t);
                    String str = String.valueOf(obj);
                    if (str == null || str.equals("null"))
                        str = "";
                    contents[i] = str;

                }

                for (int n = 0; n < contents.length; n++) {
                    // 将生成的单元格添加到工作表中
                    csvFileOutputStream.write(contents[n]);
                    csvFileOutputStream.write(",");

                }
                csvFileOutputStream.write("\r\n");
            }

            // ============ //第二种格式：Arraylist<map>填充实体类的基本信息==================
            // for (Iterator iterator = exportData.iterator();
            // iterator.hasNext();) {
            // Object row = (Object) iterator.next();
            // for (Iterator propertyIterator = map.entrySet().iterator();
            // propertyIterator
            // .hasNext();) {
            // java.util.Map.Entry propertyEntry = (java.util.Map.Entry)
            // propertyIterator
            // .next();
            // csvFileOutputStream
            // .write((String) BeanUtils.getProperty(
            // row,
            // ((String) propertyEntry.getKey()) != null ? (String)
            // propertyEntry
            // .getKey() : ""));
            // if (propertyIterator.hasNext()) {
            // csvFileOutputStream.write(",");
            // }
            // }
            // if (iterator.hasNext()) {
            // csvFileOutputStream.write("\r\n");
            // }
            // }

            // =================================
            csvFileOutputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                csvFileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return csvFile;
    }

    /**
     * 下载文件
     *
     * @param response
     * @param csvFilePath 文件路径
     * @param fileName    文件名称
     * @throws IOException
     */
    public static void exportFile(HttpServletResponse response,
                                  String csvFilePath, String fileName) throws IOException {
        response.setContentType("application/csv;charset=GBK");
        response.setHeader("Content-Disposition", "attachment;  filename="
                + new String(fileName.getBytes("GBK"), "ISO8859-1"));
        // URLEncoder.encode(fileName, "GBK")

        InputStream in = null;
        try {
            in = new FileInputStream(csvFilePath);
            int len = 0;
            byte[] buffer = new byte[1024];
            response.setCharacterEncoding("GBK");
            OutputStream out = response.getOutputStream();
            while ((len = in.read(buffer)) > 0) {
                // out.write(new byte[] { (byte) 0xEF, (byte) 0xBB, (byte) 0xBF
                // });
                out.write(buffer, 0, len);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    /**
     * 删除该目录filePath下的所有文件
     *
     * @param filePath 文件目录路径
     */
    public static void deleteFiles(String filePath) {
        File file = new File(filePath);
        if (file.exists()) {
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                if (files[i].isFile()) {
                    files[i].delete();
                }
            }
        }
    }

    /**
     * 删除单个文件
     *
     * @param filePath 文件目录路径
     * @param fileName 文件名称
     */
    public static void deleteFile(String filePath, String fileName) {
        File file = new File(filePath);
        if (file.exists()) {
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                if (files[i].isFile()) {
                    if (files[i].getName().equals(fileName)) {
                        files[i].delete();
                        return;
                    }
                }
            }
        }
    }

    /**
     * 测试数据
     *
     * @param args
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public static void main(String[] args) {
        // 获取农商银行的数据:true代表是农商
        // =======改成list的格式，支持（Arraylist传入实体类的形式），改造的方法============
        ArrayList<BankWageMonth> bankWageList = new ArrayList<BankWageMonth>();
        BankWageMonth bankWage = new BankWageMonth();
        bankWage.setId("123");
        bankWage.setNumber("2016rz0001");

        BankWageMonth bankWage2 = new BankWageMonth();
        bankWage2.setId("124");
        bankWage2.setNumber("2016rz0002");

        bankWageList.add(bankWage);
        bankWageList.add(bankWage2);

        // =======改成list的格式(支持map的形式），原作者的方法============

        // List exportData = new ArrayList<Map>();
        // Map row1 = new LinkedHashMap<String, String>();
        // row1.put("1", "11");
        // row1.put("2", "12");
        // row1.put("3", "13");
        // row1.put("4", "14");
        // exportData.add(row1);
        // row1 = new LinkedHashMap<String, String>();
        // row1.put("1", "21");
        // row1.put("2", "22");
        // row1.put("3", "23");
        // row1.put("4", "24");
        // exportData.add(row1);

        // ++++++++++++++++++++++++++++++++++

        LinkedHashMap map = new LinkedHashMap();
        map.put("1", "第一列");
        map.put("2", "第二列");
        map.put("3", "第三列");
        map.put("4", "第四列");

        String path = "D://export//";
        String fileName = "文件导出";
        String fileds[] = new String[]{"id", "number"};// 设置列英文名（也就是实体类里面对应的列名）
        File file = CsvUtil.createCSVFile(bankWageList, fileds, map, path,
                fileName);

        File file2 = CsvUtil.createCSVFile(bankWageList, fileds, map, path,
                fileName);
        String fileName2 = file.getName();
        String fileName3 = file2.getName();
        System.out.println("文件名称：" + fileName2);
        System.out.println("文件名称：" + fileName3);
    }

    /**
     * 将第一个字母转换为大写字母并和get拼合成方法
     *
     * @param origin
     * @return
     */
    private static String toUpperCaseFirstOne(String origin) {
        StringBuffer sb = new StringBuffer(origin);
        sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
        sb.insert(0, "get");
        return sb.toString();
    }
}
