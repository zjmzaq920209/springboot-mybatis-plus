package com.example.springboottest.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springboottest.entity.DataTransaction;
import java.util.List;
import java.util.Map;

/**
 * (DataTransaction)表服务接口
 *
 * @author makejava
 * @since 2019-07-23 15:44:06
 */
public interface DataTransactionService {

    /**
     * 通过ID查询单条数据
     *
     * @param netno 主键
     * @return 实例对象
     */
    DataTransaction queryById(String netno);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<DataTransaction> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param dataTransaction 实例对象
     * @return 实例对象
     */
    DataTransaction insert(DataTransaction dataTransaction);

    /**
     * 修改数据
     *
     * @param dataTransaction 实例对象
     * @return 实例对象
     */
    DataTransaction update(DataTransaction dataTransaction);

    /**
     * 通过主键删除数据
     *
     * @param netno 主键
     * @return 是否成功
     */
    boolean deleteById(String netno);

    /**
     * 分页查询
     * @param page
     * @param map
     * @return
     */
    IPage<DataTransaction> selectDataTransactionPage(IPage<DataTransaction> page, QueryWrapper<DataTransaction> wrapper);
}