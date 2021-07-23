package com.example.springboottest.fegin;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhanxin
 * @description: 字段太多，有需要自己去加
 * @date 2021-03-22 17:19:33
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel("我的待办返回参数")
public class FeignWorkflowPendingResVo {

    private String id;

    @ApiModelProperty("任务关联的表单url")
    private String actionUrl;

    @ApiModelProperty("参与者")
    private String actor;

    @ApiModelProperty("任务参与者列表")
    private List<String> actorIds;

    @ApiModelProperty("流程实例附属变量")
    private String bizType;

    @ApiModelProperty("流程实例创建者ID")
    private String creator;

    @ApiModelProperty("扩展字段")
    private String extend;

    @ApiModelProperty("流程实例url")
    private String instanceUrl;

    @ApiModelProperty("任务处理者ID")
    private String operator;

    @ApiModelProperty("流程实例ID")
    private String orderId;

    @ApiModelProperty("任务ID")
    private String taskId;

    @ApiModelProperty("流程实例编号")
    private String orderNo;

    @ApiModelProperty("流程实例状态（0：结束；1：活动；2：中断；3：撤销）")
    private String orderState;

    @ApiModelProperty("流程实例附属变量")
    private String orderVariable;

    @ApiModelProperty("实例派生列map")
    private Map<String, Object> orderVariableMap;

    @ApiModelProperty("流程实例为子流程时，该字段标识父流程实例ID")
    private String parentId;

    @ApiModelProperty("参与类型（0：普通任务；1：参与者fork任务[即：如果10个参与者，需要每个人都要完成，才继续流转]）")
    private Integer performType;

    @ApiModelProperty("流程定义ID")
    private String processId;

    @ApiModelProperty("流程名称")
    private String processName;

    @ApiModelProperty("流程派生列map")
    private Map<String, Object> taskVariableMap;

    @ApiModelProperty("审核人详情")
    private List<ActorInfosVo> actorInfos;

    @ApiModelProperty("任务名称")
    private String taskName;



}
