package com.example.springboottest.httprest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @PackageName: com.example.springboottest.httprest
 * @className: TestPage
 * @Description:
 * @Author: Jingmeng
 * @Date: 2021/1/4 10:11
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TestPage {
  String current;
  String size;
}
