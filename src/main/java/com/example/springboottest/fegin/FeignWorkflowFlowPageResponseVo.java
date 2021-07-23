package com.example.springboottest.fegin;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhanxin
 * @description:
 * @date 2021-03-22 17:11:47
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel("审批流分页返回")
public class FeignWorkflowFlowPageResponseVo<T> {

    @ApiModelProperty("当前页")
    private int pageNo;

    @ApiModelProperty("当前页条数")
    private int pageSize;

    @ApiModelProperty("总条数")
    private int totalCount;

    private List<T> result;

    @ApiModelProperty("总页数")
    private int totalPages;

    @ApiModelProperty("是否又下一页")
    private boolean hasNext;

    @ApiModelProperty("下一页")
    private int nextPage;

    @ApiModelProperty("是否有上一页")
    private boolean hasPre;

    @ApiModelProperty("上一页")
    private int prePage;

}
