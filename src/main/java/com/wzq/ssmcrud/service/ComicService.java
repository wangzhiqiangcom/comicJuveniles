package com.wzq.ssmcrud.service;

import com.wzq.ssmcrud.bean.Comic;
import com.wzq.ssmcrud.dao.ComicMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComicService {

    @Autowired
    ComicMapper comicMapper;

    public List<Comic> selectComicNames() {

        return comicMapper.selectByExample(null);
    }
}
