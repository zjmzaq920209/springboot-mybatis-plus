package com.example.springboottest.fegin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @PackageName: com.mydao.control
 * @className: workFlowTest
 * @Description:
 * @Author: Jingmeng
 * @Date: 2021/7/9 14:51
 **/

public class workFlowTest {

  @Autowired
  FeignWorkflowService feignWorkflowService;

  @Test
  public void testWorkFlow() {
    //拼接参数

    FeignWorkflowProcessDetailReqVo param = new FeignWorkflowProcessDetailReqVo();
    param.setBelongTo(1413012535602319362L);
    param.setBusinessSign("RISKBUSTYPE_005");
    Map<String,String> paramMap = new HashMap<>();
    paramMap.put("PROJECTATTRIBUTE","PROJECTATTRIBUTE_001");
    param.setConditionMap(paramMap);

    BaseResponseVo<FeignWorkflowProcessDetailResVo> response = feignWorkflowService
        .processDetail(param);

    System.out.println(response);
  }

  public void testRemove() {
    List<Long> actors = new ArrayList<>();
    BaseResponseVo response = feignWorkflowService
        .removeActor(actors, "1414773761806176258", "task_643211293255536641");

    System.out.println(response);
  }

}
