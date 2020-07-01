package com.example.springboottest.test;

import java.sql.Connection;
import java.sql.Timestamp;

/**
 * @PackageName: com.example.springboottest.test
 * @className: Sequences
 * @Description:
 * @Author: Jingmeng
 * @Date: 2020/1/4 17:33
 **/
public class Sequences {


  //11位序列

  public static void main(String[] args) {
    Long todNo = 1L;


      if(null == todNo) {
        todNo = 1L;
      } else {
        todNo = todNo + 1;
      }



  }

}
