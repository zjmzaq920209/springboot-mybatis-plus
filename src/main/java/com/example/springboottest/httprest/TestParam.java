package com.example.springboottest.httprest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @PackageName: com.example.springboottest.httprest
 * @className: TestParam
 * @Description:
 * @Author: Jingmeng
 * @Date: 2021/1/4 10:09
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TestParam {

  String startTime;
  String endTime;
  String cardId;
  String plateNum;
  String autoAxisType;

}
