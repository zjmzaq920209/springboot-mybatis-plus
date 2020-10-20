package com.example.springboottest.task;

import java.util.ArrayList;
import java.util.List;

/**
 * @PackageName: com.example.springboottest.task
 * @className: listTet
 * @Description:
 * @Author: Jingmeng
 * @Date: 2020/10/20 11:04
 **/
public class listTet {

  public static void main(String[] args) {
    List<Integer> list = new ArrayList<>();
    List<Integer> list1 = new ArrayList<>();
    list1.add(1);
    list1.add(2);
    list = list1;
    System.out.println(list);
  }

}
