package com.example.springboottest.test;

import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.commons.lang.RandomStringUtils;

/**
 * @PackageName: com.example.springboottest.test
 * @className: CreateUser
 * @Description:
 * @Author: Jingmeng
 * @Date: 2021/2/3 18:26
 **/
public class CreateUser {


  public static void main(String[] args) {
    String salt = RandomStringUtils.randomAlphanumeric(20);

    String password = new Sha256Hash("#EDC4rfv", salt).toHex();

    System.out.println(salt);

    System.out.println(password);
  }

}
