package com.qingmei.dao;

import com.qingmei.entity.DicSite;
import com.qingmei.entity.DicSiteExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DicSiteMapper {
    int countByExample(DicSiteExample example);

    int deleteByExample(DicSiteExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DicSite record);

    int insertSelective(DicSite record);

    List<DicSite> selectByExample(DicSiteExample example);

    DicSite selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DicSite record, @Param("example") DicSiteExample example);

    int updateByExample(@Param("record") DicSite record, @Param("example") DicSiteExample example);

    int updateByPrimaryKeySelective(DicSite record);

    int updateByPrimaryKey(DicSite record);
}