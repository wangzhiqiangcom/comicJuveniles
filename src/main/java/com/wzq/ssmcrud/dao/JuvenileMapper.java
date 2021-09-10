package com.wzq.ssmcrud.dao;

import com.wzq.ssmcrud.bean.Juvenile;
import com.wzq.ssmcrud.bean.JuvenileExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JuvenileMapper {
    long countByExample(JuvenileExample example);

    int deleteByExample(JuvenileExample example);

    int deleteByPrimaryKey(Integer juvenileId);

    int insert(Juvenile record);

    int insertSelective(Juvenile record);

    List<Juvenile> selectByExample(JuvenileExample example);

    Juvenile selectByPrimaryKey(Integer juvenileId);

    List<Juvenile> selectByExampleWithComic(JuvenileExample example);

    Juvenile selectByPrimaryKeyWithComic(Integer id);

    //模糊查询
    List<Juvenile> selectByVagueWithComic(String text);

    int updateByExampleSelective(@Param("record") Juvenile record, @Param("example") JuvenileExample example);

    int updateByExample(@Param("record") Juvenile record, @Param("example") JuvenileExample example);

    int updateByPrimaryKeySelective(Juvenile record);

    int updateByPrimaryKey(Juvenile record);
}