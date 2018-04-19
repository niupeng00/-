package com.qingmei.dao;

import com.qingmei.entity.AdminModule;
import com.qingmei.entity.AdminModuleExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface AdminModuleMapper {
    int countByExample(AdminModuleExample example);

    int deleteByExample(AdminModuleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AdminModule record);

    int insertSelective(AdminModule record);

    List<AdminModule> selectByExample(AdminModuleExample example);

    AdminModule selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AdminModule record, @Param("example") AdminModuleExample example);

    int updateByExample(@Param("record") AdminModule record, @Param("example") AdminModuleExample example);

    int updateByPrimaryKeySelective(AdminModule record);

    int updateByPrimaryKey(AdminModule record);

	List<AdminModule> getAllList(String string);
}