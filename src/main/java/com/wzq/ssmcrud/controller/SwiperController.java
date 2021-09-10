package com.wzq.ssmcrud.controller;

import com.wzq.ssmcrud.bean.Swiper;
import com.wzq.ssmcrud.service.SwiperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class SwiperController {

    @Autowired
    SwiperService swiperService;

    @RequestMapping("/getSwipers")
    //@ResponseBody
    public String getSwipers(Model model){

        List<Swiper> swipers = swiperService.selectForSwiper();
        model.addAttribute("swipers",swipers);

        List<Swiper> hots = swiperService.selectHot();
        model.addAttribute("hots",hots);
        return "welcome";
    }


}
