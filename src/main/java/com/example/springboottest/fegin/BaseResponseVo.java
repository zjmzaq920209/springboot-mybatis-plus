package com.example.springboottest.fegin;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

/**
 * BaseResponse
 *
 * @author：zeng qingbo
 * @date： 2020/6/18
 * @description：
 * @modifyDescription：
 * @version：1.0
 */
@ApiModel(value="接口响应结果", description="")
@Data
public class BaseResponseVo<T> implements Serializable {

    @ApiModelProperty(value = "响应状态代码",notes = "")
    private Integer code;
    @ApiModelProperty(value = "响应状态msg",notes = "")
    private String msg;
    @ApiModelProperty(value = "响应时间戳",notes = "")
    private Long timestamp;
    @ApiModelProperty(value = "响应业务数据",notes = "")
    private T data;
}
