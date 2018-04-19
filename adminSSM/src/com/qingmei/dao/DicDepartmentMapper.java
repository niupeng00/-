package com.qingmei.dao;

import com.qingmei.entity.DicDepartment;
import com.qingmei.entity.DicDepartmentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DicDepartmentMapper {
    int countByExample(DicDepartmentExample example);

    int deleteByExample(DicDepartmentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DicDepartment record);

    int insertSelective(DicDepartment record);

    List<DicDepartment> selectByExample(DicDepartmentExample example);

    DicDepartment selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DicDepartment record, @Param("example") DicDepartmentExample example);

    int updateByExample(@Param("record") DicDepartment record, @Param("example") DicDepartmentExample example);

    int updateByPrimaryKeySelective(DicDepartment record);

    int updateByPrimaryKey(DicDepartment record);
}