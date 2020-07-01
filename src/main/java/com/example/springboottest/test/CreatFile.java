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
import java.util.Arrays;

/**
 * @PackageName: com.example.springboottest.test
 * @className: CreatFile
 * @Description:
 * @Author: Jingmeng
 * @Date: 2019/12/1 16:29
 **/
public class CreatFile {

  public static void main(String[] args) throws Exception {

    String basePath = "E:\\reportmanage\\test\\";

    //第一个文件;application.yml
    //File file1 = new File(basePath + "application.yml");

    //第二个文件;application-prod.yml
    String file2 = basePath + "application-prod.yml";

    //第三个文件;appsettings.Production.json
  //  String file3 = basePath + "appsettings.Production.json";



    Files.lines(Paths.get(basePath + "stationIp.txt")).forEach(line -> {
     String[] split = line.split("-");// .trim()可以去掉首尾多余的空格

      //mysql数据库地址
      String mysqlPath = split[0].trim();

      //老站号
      String stationId = split[1].trim();

      /* String oraclePath = split[2].trim();*/

     String dir = line.trim();


      //创建文件夹并返回文件夹路径
      //String folder = creatFolder(stationId);




      //放入第一个文件
     /* try {
        copyFile(file1, new File(basePath + "\\" + dir + "\\" + "application.yml"));
      } catch (Exception e) {
        e.printStackTrace();
      }*/





      //替换文件内容（1处）
      try {
        replacTextContent(file2,"$", mysqlPath,basePath + "\\" + stationId + "\\" + "application-prod.yml");
      } catch (IOException e) {
        e.printStackTrace();
      }






      //第三个配置文件替换
     /* try {
        replaceContent(file3,oraclePath,mysqlPath,stationId,basePath + "\\" + stationId + "\\" + "appsettings.Production.json");
      } catch (IOException e) {
        e.printStackTrace();
      }*/

      //System.out.println(Arrays.toString(split));
      });






  }





  public static String creatFolder(String stationId) {
    //创建文件夹
    // 指定路径如果没有则创建并添加
    File file = new File("E:\\reportmanage\\test\\" + stationId);

      //创建父目录文件
    file.mkdirs();

    return file.getPath();
  }



  /**
   * 复制文件
   *
   * @param resource
   * @param target
   */
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
   * @throws IOException
   */
  public static void replacTextContent(String readPath,String srcStr, String replaceStr, String outPath) throws IOException{

    // 读
    File file = new File(readPath);
    FileReader in = new FileReader(file);
    BufferedReader bufIn = new BufferedReader(in);
    // 内存流, 作为临时流
    CharArrayWriter tempStream = new CharArrayWriter();
    // 替换
    String line = null;
    while ( (line = bufIn.readLine()) != null) {
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
    System.out.println("====path:"+readPath);

  }





  /**
   * 替换文本文件中的 非法字符串
   * @throws IOException
   */
  public static void replaceContent(String readPath,String oraclePath, String mysqlPath,String stationId, String outPath) throws IOException{

    // 读
    File file = new File(readPath);
    FileReader in = new FileReader(file);
    BufferedReader bufIn = new BufferedReader(in);
    // 内存流, 作为临时流
    CharArrayWriter tempStream = new CharArrayWriter();
    // 替换
    String line = null;
    while ( (line = bufIn.readLine()) != null) {
      // 替换每行中, 符合条件的字符串

      line = line.replace("%", oraclePath);
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
    System.out.println("====path:"+readPath);

  }




}
