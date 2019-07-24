package com.example.springboottest.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springboottest.entity.DataTransaction;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * (DataTransaction)表数据库访问层
 *
 * @author makejava
 * @since 2019-07-23 15:44:03
 */
@Repository
public interface DataTransactionDao extends BaseMapper<DataTransaction> {

    /**
     * 通过ID查询单条数据
     *
     * @param netno 主键
     * @return 实例对象
     */
    DataTransaction queryById(String netno);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<DataTransaction> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param dataTransaction 实例对象
     * @return 对象列表
     */
    List<DataTransaction> queryAll(DataTransaction dataTransaction);

    /**
     * 新增数据
     *
     * @param dataTransaction 实例对象
     * @return 影响行数
     */
    Integer insert(DataTransaction dataTransaction);

    /**
     * 修改数据
     *
     * @param dataTransaction 实例对象
     * @return 影响行数
     */
    int update(DataTransaction dataTransaction);

    /**
     * 通过主键删除数据
     *
     * @param netno 主键
     * @return 影响行数
     */
    int deleteById(String netno);
}