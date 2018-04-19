package com.qingmei.dao;

import com.qingmei.entity.DicSystem;
import com.qingmei.entity.DicSystemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DicSystemMapper {
    int countByExample(DicSystemExample example);

    int deleteByExample(DicSystemExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DicSystem record);

    int insertSelective(DicSystem record);

    List<DicSystem> selectByExample(DicSystemExample example);

    DicSystem selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DicSystem record, @Param("example") DicSystemExample example);

    int updateByExample(@Param("record") DicSystem record, @Param("example") DicSystemExample example);

    int updateByPrimaryKeySelective(DicSystem record);

    int updateByPrimaryKey(DicSystem record);
}