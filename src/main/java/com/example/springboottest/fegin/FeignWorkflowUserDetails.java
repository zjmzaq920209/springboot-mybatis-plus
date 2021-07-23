package com.example.springboottest.fegin;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(value="审批/抄送人 明细", description="")
public class FeignWorkflowUserDetails {

  @ApiModelProperty(value = "人员/机构/部门 id")
  private Long id;

  @ApiModelProperty(value = "人员/机构/部门 名称")
  private String name;

  @ApiModelProperty(value = "机构id")
  private Long belongTo;

  @ApiModelProperty(value = "机构名称")
  private String belongToName;

  @ApiModelProperty(value = "机构类型")
  private String belongToType;

}
