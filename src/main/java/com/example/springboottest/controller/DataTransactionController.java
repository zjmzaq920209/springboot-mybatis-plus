package com.example.springboottest.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springboottest.entity.DataTransaction;
import com.example.springboottest.service.DataTransactionService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (DataTransaction)表控制层
 *
 * @author makejava
 * @since 2019-07-23 15:44:09
 */
@RestController
@RequestMapping("dataTransaction")
public class DataTransactionController {
    /**
     * 服务对象
     */
    @Resource
    private DataTransactionService dataTransactionService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public DataTransaction selectOne(String id) {
        return this.dataTransactionService.queryById(id);
    }

    @GetMapping("queryAllByLimit")
    public IPage<DataTransaction> queryAllByLimit(Map<String, String> map) {
        Integer pageNo = Integer.valueOf(2);
        Integer pageSize = Integer.valueOf(10);
        IPage<DataTransaction> page = new Page<>(pageNo, pageSize);
        QueryWrapper<DataTransaction> wrapper = new QueryWrapper<>();
        DataTransaction dataTransaction = new DataTransaction();
        dataTransaction.setLaneno("X03");
        wrapper.setEntity(dataTransaction);
        return dataTransactionService.selectDataTransactionPage(page, wrapper);
    }



}