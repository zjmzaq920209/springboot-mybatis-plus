package com.example.springboottest.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.springframework.core.io.ClassPathResource;

/**
 * @PackageName: com.example.springboottest.test
 * @className: ReadJson
 * @Description:
 * @Author: Jingmeng
 * @Date: 2019/12/2 19:17
 **/
public class ReadJson {

  public static Map<String, String> map = new HashMap<>();


  /**
   * 读取文件数据加入到map缓存中
   * @throws IOException
   */
  public static void readJsonData() throws IOException {


    ClassPathResource resource = new ClassPathResource("sql.json");
    File file = resource.getFile();
    String jsonString = FileUtils.readFileToString(file);


    JSONObject jsonObject = JSONObject.parseObject(jsonString);

    Set<String> keySet = jsonObject.keySet();
    for (String s : keySet) {

      String sql= jsonObject.get(s).toString();
      map.put(s, sql);
    }
  }

  public static void main(String[] args) throws Exception {
    readJsonData();
  }


}
