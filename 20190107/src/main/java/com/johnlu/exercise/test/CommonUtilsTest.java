package com.johnlu.exercise.test;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.*;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * @author lxp
 * @date 2019/6/10 下午4:46
 * @Version 1.0
 */
public class CommonUtilsTest {
    @Test public void test1() {
        String s = StringUtils.abbreviate("hello man!", 4);
        System.out.println(s);
    }

    @Test public void test2()
        throws InvocationTargetException, NoSuchMethodException, InstantiationException,
        IllegalAccessException, ClassNotFoundException {
        Man a = new Man() {
            {
                setName("李鹏dd");
                setAge(25);
                setSex(false);
            }
        };
        a.setAge(20);
        com.johnlu.exercise.test.Man.class.newInstance();
        System.out.println("----------------");
        Class clazz1 = a.getClass();
        //        System.out.println("clazz1:"+clazz1);
        //        a.getClass().newInstance();
        //        Man b =  (Man)BeanUtils.cloneBean(a);
        Class clazz2 = Class.forName("com.johnlu.exercise.test.Man");
        //        System.out.println("clazz2:"+clazz2);
        System.out.println(clazz1 == clazz2);
        //        Man c = (Man) clazz2.newInstance();
        //        System.out.println(a);
        //        System.out.println(b);
        //        System.out.println(c);
    }

    @Test public void testCSVFormat1() {
        CSVFormat csvFormat1 = CSVFormat.Predefined.Excel.getFormat();
        CSVFormat csvFormat2 = CSVFormat.EXCEL;
        System.out.println(csvFormat1);
        System.out.println(csvFormat2);
        System.out.println(csvFormat1 == csvFormat2);
    }

    @Test public void testCSVFormat2() {
        CSVFormat csvFormat1 = CSVFormat.Predefined.Excel.getFormat();
        CSVFormat.Predefined[] s = CSVFormat.Predefined.values();
    }

    //excel建议使用POI类库
    @Test public void testCSVFormat3() throws IOException {
        CSVFormat csvFormat1 = CSVFormat.Predefined.Excel.getFormat();
        FileReader fileReader = new FileReader("/dashu/reconciliation/20190611/1.csv");

        CSVParser parser = csvFormat1.parse(fileReader);
        try{
            for(CSVRecord record : parser){
                int fieldNum = record.size();
                for(int i=0; i<fieldNum; i++){
                    System.out.print(record.get(i)+" ");
                }
                System.out.println();
            }
        }finally{
            fileReader.close();
        }
    }

    @Test
    //不兼容中文汉字
    public void testCSVFormat4() {
        try (CSVPrinter printer = new CSVPrinter(new FileWriter("1.csv"), CSVFormat.EXCEL)) {
            printer.printRecord("ddZ你好", "期数", "还款金额", "本金", "利息");
            printer.printRecord(1, "john73", "John", "Doe", LocalDate.of(1973, 9, 15));
            printer.println();
            printer.printRecord(2, "mary", "Mary", "Meyer", LocalDate.of(1985, 3, 29));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Test public void test5() {
        File file = new File("/dashu/reconciliation/20190407", "有利网支付.xlsx");

        Workbook wb = null;
        try {
            wb = WorkbookFactory.create(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Sheet sheet = wb.getSheetAt(0);
        Row row;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        int rows = sheet.getPhysicalNumberOfRows();
        for (int i = 2 - 1; i < rows - 0; i++) {
            row = sheet.getRow(i);
            //            row.cellIterator().forEachRemaining(r -> {
            //                String s;
            //                switch (r.getCellType().getCode()) {
            //                    case 0:
            //                        s = String.valueOf(r.getNumericCellValue());
            //                        break;
            //                    case 1:
            //                        s = r.getStringCellValue();
            //                        break;
            //                    default:
            //                        s = String.valueOf(r.toString());
            //                        break;
            //                }
            //                System.out.print(s);
            //                System.out.print(",");
            //            });
            //            System.out.println();
            System.out.println(row.getCell(9).getStringCellValue());
            System.out.print(",");
            Cell transactionDateCell = row.getCell(8);
            if (transactionDateCell.getCellType() == CellType.STRING) {
                try {
                    System.out.println(format.parse(transactionDateCell.getStringCellValue()));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            } else if (transactionDateCell.getCellType() == CellType.NUMERIC) {
                System.out.println(String.valueOf(transactionDateCell.getNumericCellValue()));
            }
        }
    }
    @Test
    public void testJsoup1() throws IOException {
        String url = "http://tcms.treefinance.com.cn/myAttendance";
        Document doc = Jsoup.connect(url).get();
        System.out.println(doc.data());
    }
    @Test
    public void testGzip() throws IOException {
        String fileName = "/dashu/reconciliation/20190611/1.csv";
        InputStream in = null;
        String gzipFileName = fileName + ".gz";
        OutputStream out = null;
        try {
            in = new BufferedInputStream(new FileInputStream(fileName));
            out = new GZIPOutputStream(new BufferedOutputStream(
                new FileOutputStream(gzipFileName)));
            copy(in, out);
        } finally {
            if (out != null) {
                out.close();
            }
            if (in != null) {
                in.close();
            }
        }
    }

    @Test
    public void testUngzip()
        throws IOException {
        String gzipFileName = "/dashu/reconciliation/20190611/1.csv.gz";
        String unzipFileName = "/dashu/reconciliation/20190611/2.csv";
        InputStream in = null;
        OutputStream out = null;
        try {
            in = new GZIPInputStream(new BufferedInputStream(
                new FileInputStream(gzipFileName)));
            out = new BufferedOutputStream(new FileOutputStream(
                unzipFileName));
            copy(in, out);
        } finally {
            if (out != null) {
                out.close();
            }
            if (in != null) {
                in.close();
            }
        }
    }

    //拷贝输入流的内容到输出流
    public static void copy(InputStream input,
        OutputStream output) throws IOException{
        byte[] buf = new byte[4096];
        int bytesRead = 0;
        while((bytesRead = input.read(buf))!=-1){
            output.write(buf, 0, bytesRead);
        }
    }
    //将文件读入字节数组
    public static byte[] readFileToByteArray(String fileName) throws IOException{
        InputStream input = new FileInputStream(fileName);
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        try{
            copy(input, output);
            return output.toByteArray();
        }finally{
            input.close();
        }
    }
    //将字节数组写到文件
    public static void writeByteArrayToFile(String fileName,
        byte[] data) throws IOException{
        OutputStream output = new FileOutputStream(fileName);
        try{
            output.write(data);
        }finally{
            output.close();
        }
    }
}
