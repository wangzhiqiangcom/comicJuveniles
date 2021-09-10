package com.wzq.ssmcrud.dao;

import com.wzq.ssmcrud.bean.Comic;
import com.wzq.ssmcrud.bean.ComicExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ComicMapper {
    long countByExample(ComicExample example);

    int deleteByExample(ComicExample example);

    int deleteByPrimaryKey(Integer comicId);

    int insert(Comic record);

    int insertSelective(Comic record);

    List<Comic> selectByExample(ComicExample example);

    Comic selectByPrimaryKey(Integer comicId);



    int updateByExampleSelective(@Param("record") Comic record, @Param("example") ComicExample example);

    int updateByExample(@Param("record") Comic record, @Param("example") ComicExample example);

    int updateByPrimaryKeySelective(Comic record);

    int updateByPrimaryKey(Comic record);
}