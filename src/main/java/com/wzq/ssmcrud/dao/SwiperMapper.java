package com.wzq.ssmcrud.dao;

import com.wzq.ssmcrud.bean.Comic;
import com.wzq.ssmcrud.bean.Swiper;
import com.wzq.ssmcrud.bean.SwiperExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SwiperMapper {
    long countByExample(SwiperExample example);

    int deleteByExample(SwiperExample example);

    int deleteByPrimaryKey(Integer swiperId);

    int insert(Swiper record);

    int insertSelective(Swiper record);

    List<Swiper> selectByExample(SwiperExample example);

    Swiper selectByPrimaryKey(Integer swiperId);

    //自定义给轮播图的方法
    List<Swiper> selectForSwiper();


    int updateByExampleSelective(@Param("record") Swiper record, @Param("example") SwiperExample example);

    int updateByExample(@Param("record") Swiper record, @Param("example") SwiperExample example);

    int updateByPrimaryKeySelective(Swiper record);

    int updateByPrimaryKey(Swiper record);
}