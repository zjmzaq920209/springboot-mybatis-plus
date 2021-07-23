package com.example.springboottest.fegin;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * FeignWorkflowGetWorkItemsReqVo
 *
 * @author： zeng qingbo
 * @date： 2021/03/27
 * @description：
 * @modifyDescription：
 * @version：1.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel("实例id查询待办任务 响应结果")
public class FeignWorkflowGetWorkItemsResVo {

    @ApiModelProperty("流程实例ID")
    private String orderId;

    @ApiModelProperty("待办任务ID")
    private String taskId;

    @ApiModelProperty("环节类型代码")
    private String bizType;

    @ApiModelProperty("待办人员ID")
    private Long actor;
    @ApiModelProperty("任务创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime taskCreateTime;

    @ApiModelProperty("审核人详情")
    private List<ActorInfosVo> actorInfos;

}
