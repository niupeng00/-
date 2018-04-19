package com.qingmei.dao;

import com.qingmei.entity.DicHelp;
import com.qingmei.entity.DicHelpExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DicHelpMapper {
    int countByExample(DicHelpExample example);

    int deleteByExample(DicHelpExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DicHelp record);

    int insertSelective(DicHelp record);

    List<DicHelp> selectByExampleWithBLOBs(DicHelpExample example);

    List<DicHelp> selectByExample(DicHelpExample example);

    DicHelp selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DicHelp record, @Param("example") DicHelpExample example);

    int updateByExampleWithBLOBs(@Param("record") DicHelp record, @Param("example") DicHelpExample example);

    int updateByExample(@Param("record") DicHelp record, @Param("example") DicHelpExample example);

    int updateByPrimaryKeySelective(DicHelp record);

    int updateByPrimaryKeyWithBLOBs(DicHelp record);

    int updateByPrimaryKey(DicHelp record);
}