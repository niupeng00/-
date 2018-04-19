package com.qingmei.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qingmei.entity.AdminModule;
import com.qingmei.entity.AdminRoleModule;
import com.qingmei.entity.AdminRoleModuleExample;

public interface AdminRoleModuleMapper {
	
	List<AdminModule> selectModualByUserId(Integer uid);
	
    int countByExample(AdminRoleModuleExample example);

    int deleteByExample(AdminRoleModuleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AdminRoleModule record);

    int insertSelective(AdminRoleModule record);

    List<AdminRoleModule> selectByExample(AdminRoleModuleExample example);

    AdminRoleModule selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AdminRoleModule record, @Param("example") AdminRoleModuleExample example);

    int updateByExample(@Param("record") AdminRoleModule record, @Param("example") AdminRoleModuleExample example);

    int updateByPrimaryKeySelective(AdminRoleModule record);

    int updateByPrimaryKey(AdminRoleModule record);
}