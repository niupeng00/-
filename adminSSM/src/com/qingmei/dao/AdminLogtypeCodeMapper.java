package com.qingmei.dao;

import com.qingmei.entity.AdminLogtypeCode;
import com.qingmei.entity.AdminLogtypeCodeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminLogtypeCodeMapper {
    int countByExample(AdminLogtypeCodeExample example);

    int deleteByExample(AdminLogtypeCodeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AdminLogtypeCode record);

    int insertSelective(AdminLogtypeCode record);

    List<AdminLogtypeCode> selectByExample(AdminLogtypeCodeExample example);

    AdminLogtypeCode selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AdminLogtypeCode record, @Param("example") AdminLogtypeCodeExample example);

    int updateByExample(@Param("record") AdminLogtypeCode record, @Param("example") AdminLogtypeCodeExample example);

    int updateByPrimaryKeySelective(AdminLogtypeCode record);

    int updateByPrimaryKey(AdminLogtypeCode record);
}