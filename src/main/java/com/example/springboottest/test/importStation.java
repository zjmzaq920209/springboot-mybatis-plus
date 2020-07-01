package com.example.springboottest.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;

/**
 * @PackageName: com.example.springboottest.test
 * @className: importStation
 * @Description:
 * @Author: Jingmeng
 * @Date: 2019/12/20 16:50
 **/
public class importStation {


  /**
   * 查询中心数据库，获得收费站信息列表
   * @return
   */

  private static List<Map<String, String>>  getstationList() {
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
   * 插入收费站信息
   * @return
   */

  private static String  insertStationInfo(String ip,Map<String, String> map) {
    String url = "jdbc:mysql://"+  ip  +":3306/db_tollstation_dev?useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT%2B8";
    String userName = "md_dbbase";
    String password = "Dbbase_2019";
    String selectSql = "select count(*) from t_self_tollstationdic where ID = '"+map.get("ID")+"'";
    String insertSql = "insert into t_self_tollstationdic(ID,OLDSTATIONNO,NAME,TOLLROADID,SECTIONID) values (?,?,?,?,?)";



    List<Map<String, String>> maps = new ArrayList<>();// 保存数据
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    try {
      conn = JdbcUtils.getConnection(url, userName, password);
      //查询数据是否存在，若存在则跳过
      Statement statement = conn.createStatement();
      rs = statement.executeQuery(selectSql);
      int flag = 0;
      while (rs.next()) {
        flag = flag + rs.getInt(1);
      }
      if(0 !=  flag) {
        return ip + "     此站已存在数据";
      } else {
        ps = conn.prepareStatement(insertSql);
        ps.setString(1,map.get("ID"));
        ps.setString(2,null == map.get("SITENO") ?  "" : map.get("SITENO"));
        ps.setString(3,map.get("NAME"));
        ps.setString(4,map.get("TOLLROADID"));
        ps.setString(5,map.get("SECTIONID"));
        ps.executeUpdate();
        System.out.println(ip+"    站数据插入成功！");
      }

    } catch (SQLException e) {
      System.out.println(ip+"    站数据插入失败！");
      e.printStackTrace();
    } finally {
      JdbcUtils.close(conn, ps, rs);
    }
    return ip+"插入完成";
  }


  /**
   * 初始化卡库存数据
   * @param args
   */
  private static String  insertCardStarage(String ip,Map<String, String> map) {
    String url = "jdbc:mysql://"+  ip  +":3306/db_tollstation_dev?useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT%2B8";
    String userName = "md_dbbase";
    String password = "Dbbase_2019";
    String selectSql = "select count(*) from t_card_starage where STATION_ID = '"+map.get("ID")+"'";
    String insertSql = "insert into t_card_starage(ID,SECTION_ID,STATION_ID,VARY_TIME,CARD_TYPE,NOW_STOR,USEFLAG,IN_TIME) values (?,?,?,?,?,?,?,?)";



    List<Map<String, String>> maps = new ArrayList<>();// 保存数据
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    try {
      conn = JdbcUtils.getConnection(url, userName, password);
      //查询数据是否存在，若存在则跳过
      Statement statement = conn.createStatement();
      rs = statement.executeQuery(selectSql);
      int flag = 0;
      while (rs.next()) {
        flag = flag + rs.getInt(1);
      }
      if(0 !=  flag) {
        return ip + "     此站已存在数据";
      } else {
        ps = conn.prepareStatement(insertSql);
        ps.setString(1,generateUUID());
        ps.setString(2,map.get("SECTIONID"));
        ps.setString(3,map.get("ID"));
        ps.setString(4,"2019-12-23 16:48:00");
        ps.setString(5,"01");
        ps.setInt(6,100);
        ps.setString(7,"1");
        ps.setString(8,"2019-12-23 16:48:00");
        ps.executeUpdate();
        System.out.println(ip+"    卡库存插入成功！");
      }

    } catch (SQLException e) {
      System.out.println(ip+"    卡库存插入失败！");
      e.printStackTrace();
    } finally {
      JdbcUtils.close(conn, ps, rs);
    }
    return ip+"插入完成";
  }



  public static String generateUUID() {
    String uuId = UUID.randomUUID().toString().replace("-", "");
    return uuId;
  }

  public static void main(String[] args) {
    List<Map<String, String>>  stationList = getstationList();
    for (Map<String, String> station : stationList) {
        if("0.0.0.0".equals(station.get("IPADDRESS"))) {
          continue;
        }
      insertStationInfo(station.get("IPADDRESS"),station);
      insertCardStarage(station.get("IPADDRESS"),station);

    }
  }


}
