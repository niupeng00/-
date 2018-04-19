package com.qingmei.dao;

import com.qingmei.entity.Archive;
import com.qingmei.entity.ArchiveExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ArchiveMapper {
    int countByExample(ArchiveExample example);

    int deleteByExample(ArchiveExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Archive record);

    int insertSelective(Archive record);

    List<Archive> selectByExample(ArchiveExample example);

    Archive selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Archive record, @Param("example") ArchiveExample example);

    int updateByExample(@Param("record") Archive record, @Param("example") ArchiveExample example);

    int updateByPrimaryKeySelective(Archive record);

    int updateByPrimaryKey(Archive record);
}