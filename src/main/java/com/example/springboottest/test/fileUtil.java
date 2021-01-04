package com.example.springboottest.test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.CharArrayWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * @PackageName: com.example.springboottest.test
 * @className: testScannner
 * @Description:
 * @Author: Jingmeng
 * @Date: 2020/12/8 10:15
 **/
public class fileUtil {

  public static final String BASEPATH = "E:\\test\\";


  public static void main(String[] args) {
    System.out.println("===============================================");
    System.out.println("                    程序开始                    ");
    System.out.println("===============================================");

    while (true) {
      Scanner scFlag = new Scanner(System.in);
      System.out.println("输入'c'继续；'r'结束");
      String flag = scFlag.nextLine();
      if ("c".equals(flag)) {
        System.out.println("程序继续");
        generateFile();
      } else {
        System.out.println("===============================================");
        System.out.println("                    程序结束                    ");
        System.out.println("===============================================");
        return;
      }

    }


  }


  public static void generateFile() {
    Scanner sc = new Scanner(System.in);
    System.out.println(
        "配置文件修改小工具, 请输入要修改的配置文件编号：1-application.yml; 2-application-prod.yml; 3-appsettings.Production.json;");
    System.out.println("请输入你的选择：");
    int fileType = sc.nextInt();
    if (fileType == 1) {
      System.out.println("你选择的配置文件为： 1-application.yml");
      Scanner scFlag = new Scanner(System.in);
      System.out.println("开放式：输入'k'；封闭式：输入'f'");
      String flag = scFlag.nextLine();
      if ("k".equals(flag) || "f".equals(flag)) {
        System.out.println("开始批量修改application.yml");
        file1(flag);
      } else {
        return;
      }

    } else if (fileType == 2) {
      System.out.println("你选择的配置文件为： 2-application-prod.yml");
      Scanner scFlag = new Scanner(System.in);
      System.out.println("输入'c'继续；'r'结束");
      String flag = scFlag.nextLine();
      if ("c".equals(flag)) {
        System.out.println("开始批量修改application-prod.yml");
        file2();
      } else {
        return;
      }
    } else if (fileType == 3) {
      System.out.println("你选择的配置文件为： 3-appsettings.Production.json");
      Scanner scFlag = new Scanner(System.in);
      System.out.println("输入'c'继续；'r'结束");
      String flag = scFlag.nextLine();
      if ("c".equals(flag)) {
        System.out.println("开始批量修改application-prod.yml");
        file3();
      } else {
        return;
      }
    } else {
      System.out.println("输入文件类型错误！");
      return;
    }
  }

  /**
   * 处理application.yml文件
   */

  public static void file1(String flag) {
    File file1 = new File(BASEPATH + "application.yml");
    String stationIp = "";
    if("k".equals(flag)) {
      stationIp = "stationId-open.txt";
    } else if("f".equals(flag)) {
      stationIp = "stationId-close.txt";
    } else {
      return;
    }
    try {
      Files.lines(Paths.get(BASEPATH + stationIp)).forEach(line -> {
        String[] split = line.split("-");// .trim()可以去掉首尾多余的空格
        //6位老站号
        String stationId = split[0].trim();
        //文件夹不存在就创建
        if (!(new File(BASEPATH + stationId).isDirectory())) {
          new File(BASEPATH + stationId).mkdir();
        }

        try {
          copyFile(file1, new File(BASEPATH + "\\" + stationId + "\\" + "application.yml"));
          System.out.println(stationId+" 处理完成！");
        } catch (IOException e) {
          System.out.println("{}处理 "  + stationId + "失败！");
          e.printStackTrace();
        } catch (Exception e) {
          System.out.println("{}处理 "  + stationId + "失败！");
          e.printStackTrace();
        }
      });
    } catch (IOException e) {
      System.out.println("读取stationIp.txt文件失败！");
      e.printStackTrace();
    }
  }

  /**
   * 处理application-prod.yml文件
   */
  public static void file2() {

    //第二个文件;application-prod.yml
    String file2 = BASEPATH + "application-prod.yml";

    try {
      Files.lines(Paths.get(BASEPATH + "stationIp.txt")).forEach(line -> {
        String[] split = line.split("-");// .trim()可以去掉首尾多余的空格
        //mysql数据库地址
        String mysqlPath = split[0].trim();
        //6位老站号
        String stationId = split[1].trim();
        //文件夹不存在就创建
        if (!(new File(BASEPATH + stationId).isDirectory())) {
          new File(BASEPATH + stationId).mkdir();
        }
        //替换文件内容（1处）
        try {
          replacTextContent(file2, "$", mysqlPath,
              BASEPATH + "\\" + stationId + "\\" + "application-prod.yml");
          System.out.println(mysqlPath+"-"+stationId+" 处理完成！");
        } catch (IOException e) {
          System.out.println("{}处理" + mysqlPath + " " + stationId + "失败！");
          e.printStackTrace();
        }
      });
    } catch (IOException e) {
      System.out.println("读取stationIp.txt文件失败！");
      e.printStackTrace();
    }
  }


  public static void file3() {

    //第三个文件;appsettings.Production.json
    String file3 = BASEPATH + "appsettings.Production.json";

    try {
      Files.lines(Paths.get(BASEPATH + "stationIp.txt")).forEach(line -> {
        String[] split = line.split("-");// .trim()可以去掉首尾多余的空格
        //mysql数据库地址
        String mysqlPath = split[0].trim();
        //6位老站号
        String stationId = split[1].trim();
        //文件夹不存在就创建
        if (!(new File(BASEPATH + stationId).isDirectory())) {
          new File(BASEPATH + stationId).mkdir();
        }
        //老oracle数据库ip
        //第三个配置文件替换
        try {
          replaceContent(file3, mysqlPath, stationId,
              BASEPATH + "\\" + stationId + "\\" + "appsettings.Production.json");
          System.out.println(mysqlPath+"-"+stationId+" 处理完成！");
        } catch (IOException e) {
          System.out.println("{}处理" + mysqlPath + " " + stationId + "失败！");
          e.printStackTrace();
        }
      });
    } catch (IOException e) {
      System.out.println("读取stationIp.txt文件失败！");
      e.printStackTrace();
    }
  }


  /**
   * 替换文本文件中的 非法字符串
   */
  public static void replacTextContent(String readPath, String srcStr, String replaceStr,
      String outPath) throws IOException {

    // 读
    File file = new File(readPath);
    FileReader in = new FileReader(file);
    BufferedReader bufIn = new BufferedReader(in);
    // 内存流, 作为临时流
    CharArrayWriter tempStream = new CharArrayWriter();
    // 替换
    String line = null;
    while ((line = bufIn.readLine()) != null) {
      // 替换每行中, 符合条件的字符串
      line = line.replace(srcStr, replaceStr);
      // 将该行写入内存
      tempStream.write(line);
      // 添加换行符
      tempStream.append(System.getProperty("line.separator"));
    }
    // 关闭 输入流
    bufIn.close();
    // 将内存中的流 写入 文件
    FileWriter out = new FileWriter(new File(outPath));
    tempStream.writeTo(out);
    out.close();
    System.out.println("====path:" + readPath);

  }


  public static void copyFile(File resource, File target) throws Exception {
    // 输入流 --> 从一个目标读取数据
    // 输出流 --> 向一个目标写入数据

    long start = System.currentTimeMillis();

    // 文件输入流并进行缓冲
    FileInputStream inputStream = new FileInputStream(resource);
    BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);

    // 文件输出流并进行缓冲
    FileOutputStream outputStream = new FileOutputStream(target);
    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);

    // 缓冲数组
    // 大文件 可将 1024 * 2 改大一些，但是 并不是越大就越快
    byte[] bytes = new byte[1024 * 2];
    int len = 0;
    while ((len = inputStream.read(bytes)) != -1) {
      bufferedOutputStream.write(bytes, 0, len);
    }
    // 刷新输出缓冲流
    bufferedOutputStream.flush();
    //关闭流
    bufferedInputStream.close();
    bufferedOutputStream.close();
    inputStream.close();
    outputStream.close();

    long end = System.currentTimeMillis();

    System.out.println("耗时：" + (end - start) / 1000 + " s");

  }

  /**
   * 替换文本文件中的 非法字符串
   */
  public static void replaceContent(String readPath, String mysqlPath, String stationId,
      String outPath) throws IOException {

    // 读
    File file = new File(readPath);
    FileReader in = new FileReader(file);
    BufferedReader bufIn = new BufferedReader(in);
    // 内存流, 作为临时流
    CharArrayWriter tempStream = new CharArrayWriter();
    // 替换
    String line = null;
    while ((line = bufIn.readLine()) != null) {
      // 替换每行中, 符合条件的字符串

      line = line.replace("$", mysqlPath);
      line = line.replace("!", stationId);
      // 将该行写入内存
      tempStream.write(line);
      // 添加换行符
      tempStream.append(System.getProperty("line.separator"));
    }
    // 关闭 输入流
    bufIn.close();
    // 将内存中的流 写入 文件
    FileWriter out = new FileWriter(new File(outPath));
    tempStream.writeTo(out);
    out.close();
    System.out.println("====path:" + readPath);

  }
}
