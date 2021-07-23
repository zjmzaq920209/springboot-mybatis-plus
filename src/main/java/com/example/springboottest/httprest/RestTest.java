package com.example.springboottest.httprest;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * @PackageName: com.example.springboottest.httprest
 * @className: RestTest
 * @Description:
 * @Author: Jingmeng
 * @Date: 2021/1/4 9:55
 **/
public class RestTest {

  @Test
  public void rtPostObject() throws Exception {
    RestTemplate restTemplate = new RestTemplate();
    String url1 = "http://10.165.77.31/api/traffic-info/entryWaste/queryEntryWastePage";
    String url2 = "http://10.165.77.31/api/traffic-info/exitWaste/queryExitWastePage";
    String url3 = "http://10.165.79.119/api/traffic-info/gantryWaste/queryGantryWastePage";
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    Map<String,Object> map = new HashMap<>();


    //构建参数
    TestPage page = new TestPage();
    page.setCurrent("1");
    page.setSize("10");

    TestParam param = new TestParam();
    param.setStartTime("2021-04-06 00:00:00");
    param.setEndTime("2021-04-07 00:00:00");
    param.setPlateNum("鲁EA0009");
    //param.setAutoAxisType("0");

    map.put("params",JSONObject.toJSON(param));
    map.put("page",JSONObject.toJSON(page));

    HttpEntity request = new HttpEntity(map, headers);
    ResponseEntity<String> response = restTemplate.postForEntity( url2, request , String.class );
    if (response.getStatusCode().equals(HttpStatus.OK)) {
      String body = response.getBody();
      System.out.println(response.getBody());
    } else {
      throw new Exception("请求接口出错");
    }


  }

}
