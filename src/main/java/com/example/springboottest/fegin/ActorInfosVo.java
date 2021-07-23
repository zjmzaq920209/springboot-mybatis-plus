package com.example.springboottest.fegin;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author zhanxin
 * @description:
 * @date 2021-04-10 13:39:30
 */
@Data
@ApiModel("审核人 详情")
public class ActorInfosVo {

    @ApiModelProperty("")
    private String orderId;

    @ApiModelProperty("任务id")
    private String taskId;

    @ApiModelProperty("审核人")
    private String actorId;

    @ApiModelProperty("审核人详情")
    private String variable;

    @ApiModel("审核人详情")
    @Data
    public static class UserInfoVo{

        @ApiModelProperty("部门id")
        private String jobId;

        @ApiModelProperty("部门名称")
        private String jobName;

        @ApiModelProperty("机构类型")
        private String nodeType;

        @ApiModelProperty("项目id")
        private String projectId;

        @ApiModelProperty("项目名称")
        private String projectName;

        @ApiModelProperty("项目简称")
        private String projectShortName;

        @ApiModelProperty("部门id")
        private String deptId;

        @ApiModelProperty("部门名称")
        private String deptName;

        @ApiModelProperty("机构id")
        private String enterpriseId;

        @ApiModelProperty("机构名称")
        private String enterpriseName;

        @ApiModelProperty("机构简称")
        private String enterpriseShortName;

        @ApiModelProperty("人员id")
        private String personId;

        @ApiModelProperty("人员名称")
        private String personName;

    }
}
