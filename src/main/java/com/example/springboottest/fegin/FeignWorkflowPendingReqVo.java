package com.example.springboottest.fegin;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhanxin
 * @description:
 * @date 2021-03-22 16:41:06
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("我的待办请求参数")
public class FeignWorkflowPendingReqVo {

    @ApiModelProperty("用户标识")
    private Long actorId;

    @ApiModelProperty("当前页")
    private Integer pageNo = 1;

    @ApiModelProperty("每页大小")
    private Integer pageSize = 10;

    @ApiModelProperty("审批申请时间起")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startTime;

    @ApiModelProperty("审批申请时间止")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endTime;

    @ApiModelProperty("精准搜索内容")
    private RiskQueryParam searchAccurate;

    @ApiModelProperty("模糊搜索内容")
    private String searchVague;

}
