package com.example.springboottest.fegin;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * FeignWorkflowProcessDetailReqVo
 *
 * @author： zeng qingbo
 * @date： 2021/03/30
 * @description：
 * @modifyDescription：
 * @version：1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("获取流程定义及任务节点集合 请求参数")
public class FeignWorkflowProcessDetailReqVo {

  @ApiModelProperty("机构id")
  private Long belongTo;

  @ApiModelProperty("业务单类型")
  private String businessSign;

  @ApiModelProperty("业务单条件")
  private Map<String,String> conditionMap;

}
