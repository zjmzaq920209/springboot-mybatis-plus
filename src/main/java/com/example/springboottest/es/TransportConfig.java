package com.example.springboottest.es;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;
import org.apache.http.HttpHost;
import org.elasticsearch.action.ActionListener;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.recycler.Recycler.V;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.Test;

/**
 * @PackageName: com.example.springboottest.es
 * @className: TransportConfig
 * @Description:
 * @Author: Jingmeng
 * @Date: 2021/4/25 15:26
 **/
public class TransportConfig {

  String ES_URL = "10.165.79.132";

  Integer ES_PORT = 9200;

  String ES_NAME = "";
  private RestHighLevelClient client;

  public TransportConfig() {
    RestHighLevelClient client = new RestHighLevelClient(
        RestClient.builder(
            //集群节点
//                        new HttpHost("localhost", 9200, "http"),
            new HttpHost(ES_URL, ES_PORT, "http")));
    this.client = client;
  }

  public void shutdown(){
    if(client!=null){
      try {
        client.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  /**
   * 获取指定index和id的 数据
   * @param index
   * @param id
   * @return
   */
  @Test
  public void getStringById(){
    String index = "";
    String id = "";
    String s = "";
    id = "".equals(id)?"2":id;
    index = "".equals(index)?"ems":index;
    GetRequest getRequest = new GetRequest(index,id);
    GetResponse response = null;
    try {
      response = this.client.get(getRequest, RequestOptions.DEFAULT);
    } catch (IOException e) {
      e.printStackTrace();
    }
    //按字段Key获取对应的值
    //DocumentField field = response.getField("content");
    //获取全部的map,除了正常的值之外，会存在key是@version和@timestamp的值
    Map<String, Object> source =  response.getSource();
    source.forEach((k,v) ->{
      System.out.println(k);
      System.out.println(v);
    });



    //return s;
  }



  /**
   * 根据指定的内容，查询所有Doc。
   * @param
   * @return
   */

  public SearchHits search(String index,String key,String value){
    QueryBuilder matchQueryBuilder = QueryBuilders.matchPhraseQuery(key, value);
//        matchQueryBuilder.
    SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
//        sourceBuilder.query(QueryBuilders.termQuery("content", content));
    sourceBuilder.query(matchQueryBuilder);
    sourceBuilder.from(0);
    sourceBuilder.size(100);
    sourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));
    SearchRequest searchRequest = new SearchRequest();
    searchRequest.indices(index);
    searchRequest.source(sourceBuilder);
    SearchResponse searchResponse;
    List<Map<String,Object>> list = new ArrayList<>();
    SearchHits searchHits = null;
    try {
      searchResponse = this.client.search(searchRequest,RequestOptions.DEFAULT);
      searchHits =  searchResponse.getHits();
      for(SearchHit hit:searchHits.getHits()){
        System.out.println( hit.getSourceAsString());
        list.add(hit.getSourceAsMap());
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return searchHits;
  }

  public long deleteArticle(String titleName){
    long deleteNum = 0L;

    SearchHits searchHits = search("article-2019.08.08.03","title",titleName);
    System.out.println("Exxcute Start" );
    deleteCommon(searchHits);
    //deleteAsync(searchHits);
    System.out.println("Exxcute Done" );
    return deleteNum;

  }

  /**
   * 正常删除
   * @param searchHits
   */
  private void deleteCommon (SearchHits searchHits){
    DeleteRequest deleteRequest = new DeleteRequest();
    for(SearchHit hit:searchHits.getHits()) {
      deleteRequest = new DeleteRequest("article-2019.08.08.03",hit.getId());
      try {
        DeleteResponse deleteResponse = this.client.delete(deleteRequest,RequestOptions.DEFAULT);
        System.out.println("Delete Done【"+deleteResponse.getId()+"】,Status:【" + deleteResponse.status() + "】");
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  /**
   * 异步删除
   * @param searchHits
   */
  private void deleteAsync (SearchHits searchHits) {
    DeleteRequest deleteRequest = new DeleteRequest();
    for(SearchHit hit:searchHits.getHits()){
      deleteRequest = new DeleteRequest("article-2019.08.08.03",hit.getId());


      //异步删除
      this.client.deleteAsync(deleteRequest, RequestOptions.DEFAULT, new ActionListener<DeleteResponse>() {
        @Override
        public void onResponse(DeleteResponse deleteResponse) {
          RestStatus restStatus = deleteResponse.status();
          int status = restStatus.getStatus();
          deleteResponse.getId();
          System.out.println("Delete Done【"+deleteResponse.getId()+"】,Status:【" + status + "】");
        }
        @Override
        public void onFailure(Exception e) {
          e.printStackTrace();
          System.out.println("ERROR  " + hit.getId());
        }
      });
    }

  }



}
