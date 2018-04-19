package com.qingmei.dao;

import com.qingmei.entity.DicHelpCategory;
import com.qingmei.entity.DicHelpCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DicHelpCategoryMapper {
    int countByExample(DicHelpCategoryExample example);

    int deleteByExample(DicHelpCategoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DicHelpCategory record);

    int insertSelective(DicHelpCategory record);

    List<DicHelpCategory> selectByExample(DicHelpCategoryExample example);

    DicHelpCategory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DicHelpCategory record, @Param("example") DicHelpCategoryExample example);

    int updateByExample(@Param("record") DicHelpCategory record, @Param("example") DicHelpCategoryExample example);

    int updateByPrimaryKeySelective(DicHelpCategory record);

    int updateByPrimaryKey(DicHelpCategory record);
}