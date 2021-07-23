package com.example.springboottest.fegin;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * FeignWorkflowUserInfo
 *
 * @author： zeng qingbo
 * @date： 2021/04/01
 * @description：
 * @modifyDescription：
 * @version：1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value="审批环节 明细", description="")
public class FeignWorkflowStepDetails {

  @ApiModelProperty("环节名称")
  private String name;

  @ApiModelProperty("流程显示名称")
  private String displayName;

  @ApiModelProperty("审批审批/部门明细")
  private List<String> assignee;

  @ApiModelProperty("流程环节类型代码")
  private String bizType;

  @ApiModelProperty(value = "派生列字符串",notes = "参与接口：已处理")
  private String variable;

  @ApiModelProperty(value = "派生列Map",notes = "参与接口：已处理")
  private Map<String,String> variableMap;

  @ApiModelProperty("任务处理类型：0 主办、1 协办、3 自动办理")
  private Integer taskType;

}
