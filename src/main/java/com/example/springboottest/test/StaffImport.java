package com.example.springboottest.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @PackageName: com.example.springboottest.test
 * @className: StaffImport
 * @Description:
 * @Author: Jingmeng
 * @Date: 2019/12/31 12:56
 **/
public class StaffImport {

  /**
   * 查询中心数据库，获得收费站信息列表
   * @return
   */

  private static List<Map<String, String>> getstationList() {
    String url = "jdbc:mysql://10.165.79.41:3306/db_tolldata_prod?useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT%2B8";
    String userName = "db_tolldata_user";
    String password = "Dbtollprod2019_s";
    String sql = "select * from t_md_tollstationdic";
    List<Map<String, String>> maps = new ArrayList<>();// 保存数据
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    try {
      conn = JdbcUtils.getConnection(url, userName, password);
      Statement statement = conn.createStatement();
      rs = statement.executeQuery(sql);
      ResultSetMetaData rsm = rs.getMetaData();
      int colums = rsm.getColumnCount();
      HashMap<String, String> map = new HashMap<>();
      while (rs.next()) {
        map.clear();
        for (int i = 1; i <= colums; i++) {
          map.put(rsm.getColumnName(i), rs.getString(i));
        }
        // Map中存储map对象的地址,所以这块new map
        maps.add(new HashMap<String, String>() {{
          putAll(map);
        }});
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      JdbcUtils.close(conn, ps, rs);
    }
    return maps;

  }

  /**
   * 根据站号查询员工
   */

 /* public static List<Map<String,Object>> getUsers(String stationId) {


  }*/

}
