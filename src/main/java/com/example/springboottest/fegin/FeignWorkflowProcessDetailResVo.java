package com.example.springboottest.fegin;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import lombok.AllArgsConstructor;
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
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("获取流程定义及任务节点集合 响应结果")
public class FeignWorkflowProcessDetailResVo {

    @ApiModelProperty("流程定义id")
    private String processId;

    @ApiModelProperty("流程环节明细")
    private List<FeignWorkflowStepDetails> taskNodes;

    @ApiModelProperty(value = "抄送人明细")
    private List<FeignWorkflowUserDetails> ccOrder;

    @ApiModelProperty("是否可以撤销 true 可以撤销  flase 不可以撤销")
    private Boolean cancelBtn;


}
