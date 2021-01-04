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
    String url1 = "http://10.165.79.119/api/traffic-info/entryWaste/queryEntryWastePage";
    String url2 = "http://10.165.79.119/api/traffic-info/exitWaste/queryExitWastePage";
    String url3 = "http://10.165.79.119/api/traffic-info/gantryWaste/queryGantryWastePage";
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    Map<String,Object> map = new HashMap<>();


    //构建参数
    TestPage page = new TestPage();
    page.setCurrent("1");
    page.setSize("10");

    TestParam param = new TestParam();
    param.setStartTime("2020-12-01");
    param.setEndTime("2020-12-28");
    map.put("params",JSONObject.toJSON(param));
    map.put("page",JSONObject.toJSON(page));

    HttpEntity request = new HttpEntity(map, headers);
    ResponseEntity<String> response = restTemplate.postForEntity( url3, request , String.class );
    if (response.getStatusCode().equals(HttpStatus.OK)) {
      System.out.println(response.getBody());
    } else {
      throw new Exception("请求接口出错");
    }


  }

}
