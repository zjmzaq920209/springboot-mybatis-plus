package com.example.springboottest.fegin;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @PackageName: com.example.springboottest.fegin
 * @className: FeignTestController
 * @Description:
 * @Author: Jingmeng
 * @Date: 2021/7/12 15:46
 **/
@Api(tags = "feign测试",value = "测试")
@RestController
@RequestMapping("feign")
public class FeignTestController {
  @Autowired
  FeignWorkflowService feignWorkflowService;
  
  @ApiOperation(value = "测试接口", tags = "测试")
  @GetMapping("feignTest")
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

  public void testWorkItems() {
    FeignWorkflowGetWorkItemsReqVo param = new FeignWorkflowGetWorkItemsReqVo();
    List<String> orderIds = new ArrayList<>();
    orderIds.add("1413304772395536385");
    param.setOrderIds(orderIds);

    feignWorkflowService.getWorkItems(param);
  }

  @ApiOperation(value = "我的待办", tags = "我的待办")
  @GetMapping("userTask")
  public BaseResponseVo<FeignWorkflowFlowPageResponseVo<FeignWorkflowPendingResVo>> getUserTask() {
    FeignWorkflowPendingReqVo param = new FeignWorkflowPendingReqVo();
    param.setActorId(1413304772395536385L);
    param.setPageNo(1);
    BaseResponseVo<FeignWorkflowFlowPageResponseVo<FeignWorkflowPendingResVo>> feignWorkflowFlowPageResponseVoBaseResponseVo = feignWorkflowService
        .userTasks(param);
    return feignWorkflowFlowPageResponseVoBaseResponseVo;
  }

  @ApiOperation(value = "移除用户", tags = "移除办理用户")
  @GetMapping("removeUser")
  public BaseResponseVo testRemove() {
    List<Long> actors = new ArrayList<>();
    BaseResponseVo response = feignWorkflowService
        .removeActor(actors, "1414773761806176258", "task_643211293255536641");

    return response;
  }
}
