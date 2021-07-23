package com.example.springboottest.fegin;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel("实例id查询待办任务 请求入参")
public class FeignWorkflowGetWorkItemsReqVo {

    @ApiModelProperty("流程实例ID 集合")
    private List<String> orderIds;

    @ApiModelProperty("当前页")
    private Integer pageNo;

    @ApiModelProperty("每页大小")
    private Integer pageSize;


}
