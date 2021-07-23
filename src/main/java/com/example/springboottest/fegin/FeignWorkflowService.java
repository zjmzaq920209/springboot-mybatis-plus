package com.example.springboottest.fegin;

import io.swagger.annotations.ApiParam;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * FeignWorkflowService
 *
 * @author： zeng qingbo
 * @date： 2021/03/16
 * @description： 审批流接口
 * @modifyDescription：
 * @version：1.0
 */
@Component
@FeignClient(name="AZB-WORKFLOW-SERVICE")
public interface FeignWorkflowService {

    /**
     * 获取流程定义及任务节点集合
     * @param reqVo
     * @return
     */
    @PostMapping("/processDetail")
    BaseResponseVo<FeignWorkflowProcessDetailResVo> processDetail(
        FeignWorkflowProcessDetailReqVo reqVo);


    /**
     * 实例id查询待办任务
     * @return
     */
    @GetMapping("/getWorkItems")
    BaseResponseVo<FeignWorkflowFlowPageResponseVo<FeignWorkflowGetWorkItemsResVo>> getWorkItems(@SpringQueryMap FeignWorkflowGetWorkItemsReqVo reqVo);


    /**
     * 我的待办
     * @return
     */
    @PostMapping("/userTasks")
    BaseResponseVo<FeignWorkflowFlowPageResponseVo<FeignWorkflowPendingResVo>> userTasks(FeignWorkflowPendingReqVo reqVo);


    /**
     * 移除办理人
     */
    @PostMapping("/actor/remove")
    BaseResponseVo removeActor(@ApiParam("任务办理人")@RequestParam("actors") List<Long> actors,
        @ApiParam("流程实例ID")@RequestParam("orderId") String orderId, @ApiParam("任务名称")@RequestParam("taskName") String taskName);
}


