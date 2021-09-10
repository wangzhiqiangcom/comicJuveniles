package com.wzq.ssmcrud.controller;

import com.wzq.ssmcrud.bean.Comic;
import com.wzq.ssmcrud.bean.Msg;
import com.wzq.ssmcrud.service.ComicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ComicController {

    @Autowired
    ComicService comicService;

    @RequestMapping("/getComics")
    @ResponseBody
    public Msg getComics(Model model){

        List<Comic> comics = comicService.selectComicNames();
        model.addAttribute("comics",comics);

        return Msg.success().add("comics",comics);
    }
}
