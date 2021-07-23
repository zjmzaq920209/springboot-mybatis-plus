package com.example.springboottest.test;

import java.text.MessageFormat;
import java.text.NumberFormat;

/**
 * @PackageName: com.example.springboottest.test
 * @className: trimTest
 * @Description:
 * @Author: Jingmeng
 * @Date: 2021/2/19 17:23
 **/
public class trimTest {

  public static void main(String[] args) {
   /* String message ="修改了id={ %s },loginTime 由：{ %s }修改为：{22}, workeDate由：{ %s } 修改为：{33}";

    *//*System.out.println(MessageFormat
        .format(message, 1, 2, 3));*//*


    System.out.println(String.format(message,1,2,3));*/

//String a = "12,\r\n34";
//
////a = a.replaceAll("\r|\n","");
//    System.out.println(a);
//
//    System.out.println(a);



//    String a = "6500124";

//    System.out.println(a.substring(3));
    Integer a = 100;
    Integer b = 100;
//    System.out.println(a == b);

    System.out.println(a.equals(b));


//int c = 200;
//int d = 200;
//
//    System.out.println(c == d);

    double first = 9.4;
    double second = 9.5;
    double third = 9.6;
    NumberFormat numberFormat = NumberFormat.getInstance();




  }

}
