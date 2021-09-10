package com.wzq.ssmcrud.service;

import com.wzq.ssmcrud.bean.Swiper;
import com.wzq.ssmcrud.dao.SwiperMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SwiperService {

    @Autowired
    SwiperMapper swiperMapper;

    public List<Swiper> selectForSwiper() {
        return swiperMapper.selectForSwiper();
    }

    public List<Swiper> selectHot() {
        return swiperMapper.selectByExample(null);
    }
}
