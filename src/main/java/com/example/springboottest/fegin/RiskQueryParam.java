package com.example.springboottest.fegin;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * RiskQueryParam
 *
 * @author： zeng qingbo
 * @date： 2021/04/01
 * @description：
 * @modifyDescription：
 * @version：1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel(value="风险辨识/调整/销号 审批查询参数", description="")
public class RiskQueryParam {

  @JsonInclude(JsonInclude.Include.NON_NULL)
  @ApiModelProperty(value = "业务单类型代码")
  private String riskBusType;

  @JsonInclude(JsonInclude.Include.NON_NULL)
  @ApiModelProperty(value = "项目id")
  private Long projectId;

  @JsonInclude(JsonInclude.Include.NON_NULL)
  @ApiModelProperty(value = "调整类型代码（RISKLEVELADJUSTYPE）：升级调整、降级调整")
  private String adjustmentTypeCode;

  @JsonInclude(JsonInclude.Include.NON_NULL)
  @ApiModelProperty(value = "流程发起时间起")
  private LocalDateTime startTime;

  @JsonInclude(JsonInclude.Include.NON_NULL)
  @ApiModelProperty(value = "流程发起时间止")
  private LocalDateTime endTime;

  @JsonInclude(JsonInclude.Include.NON_NULL)
  @ApiModelProperty("流程实例状态（0：结束[审批完成]；1：活动[审批中]；2：中断[审批驳回]；3：撤销[审批撤销]）")
  private Integer orderState;

  @JsonInclude(JsonInclude.Include.NON_NULL)
  @ApiModelProperty(value = "包含所有需模糊搜索的业务数据集合，格式：字符串",notes = "")
  private String searchVague;
}
