package com.example.springboottest.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springboottest.entity.DataTransaction;
import com.example.springboottest.dao.DataTransactionDao;
import com.example.springboottest.service.DataTransactionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * (DataTransaction)表服务实现类
 *
 * @author makejava
 * @since 2019-07-23 15:44:07
 */
@Service("dataTransactionService")
public class DataTransactionServiceImpl implements DataTransactionService {
    @Resource
    private DataTransactionDao dataTransactionDao;

    /**
     * 通过ID查询单条数据
     *
     * @param netno 主键
     * @return 实例对象
     */
    @Override
    public DataTransaction queryById(String netno) {
        return this.dataTransactionDao.queryById(netno);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<DataTransaction> queryAllByLimit(int offset, int limit) {
        return this.dataTransactionDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param dataTransaction 实例对象
     * @return 实例对象
     */
    @Override
    public DataTransaction insert(DataTransaction dataTransaction) {
        this.dataTransactionDao.insert(dataTransaction);
        return dataTransaction;
    }

    /**
     * 修改数据
     *
     * @param dataTransaction 实例对象
     * @return 实例对象
     */
    @Override
    public DataTransaction update(DataTransaction dataTransaction) {
        this.dataTransactionDao.update(dataTransaction);
        return this.queryById(dataTransaction.getNetno());
    }

    /**
     * 通过主键删除数据
     *
     * @param netno 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String netno) {
        return this.dataTransactionDao.deleteById(netno) > 0;
    }

    /**
     * 分页查询
     * @param page
     * @param page
     * @return
     */
    @Override
    public IPage<DataTransaction> selectDataTransactionPage(IPage<DataTransaction> page, QueryWrapper<DataTransaction> wrapper) {
        return dataTransactionDao.selectPage(page, wrapper);
    }


}