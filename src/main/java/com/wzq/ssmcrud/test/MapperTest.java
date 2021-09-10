package com.wzq.ssmcrud.test;

import com.wzq.ssmcrud.bean.*;
import com.wzq.ssmcrud.dao.JuvenileMapper;
import com.wzq.ssmcrud.dao.SwiperMapper;
import com.wzq.ssmcrud.dao.UserMapper;
import com.wzq.ssmcrud.service.JuvenileService;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MapperTest {

    @Autowired
    JuvenileService juvenileService;

    @Autowired
    JuvenileMapper juvenileMapper;

    @Autowired
    SwiperMapper swiperMapper;

    @Autowired
    SqlSession sqlSession;

    @Autowired
    private UserMapper userMapper;


    @Test
    public void testCrud(){

        //Juvenile juvenile = juvenileMapper.selectByPrimaryKeyWithComic(1);

        //JuvenileExample example = new JuvenileExample();
        //
        //JuvenileExample.Criteria criteria = example.createCriteria();
        //criteria.andJNameLike("%司空%");
        //criteria.andGenderEqualTo("女");
        //criteria.andSectLike("%雪月%");
        //JuvenileExample.Criteria criteria1 = criteria.andJuvenileIdEqualTo(5);
        //List<Juvenile> juveniles = juvenileMapper.selectByExampleWithComic(example);


        //JuvenileMapper mapper = sqlSession.getMapper(JuvenileMapper.class);
        //for(int i = 0;i < 100; i++){
        //    mapper.insertSelective(new Juvenile(null,"路人" + i,"男","未知" + i,"未知" + i,"https://ss.im5i.com/2021/08/17/VW1uS.jpg",1));
        //}

        //System.out.println(juveniles);

        //List<Juvenile> juveniles = juvenileService.selectByVague("雷");
        //
        //for(Juvenile juvenile : juveniles){
        //    System.out.println(juvenile);
        //}

        //null,"ss","d","dd","ddf","fefsdfs",2
        //int i;
        //Juvenile juvenile = new Juvenile();
        //juvenile.setjName("kobe-81points");
        //System.out.println(juvenile != null);
        //try {
        //    i = juvenileMapper.insertSelective(juvenile);
        //    System.out.println("插入成功");
        //}catch (Exception e){
        //    i = -1;
        //    System.out.println("juvenile为空，插入失败！");
        //}
        //
        //System.out.println(i);



        //int del = juvenileMapper.deleteByPrimaryKey(49);
        //System.out.println("影响了" + del + "行");
        //List<Juvenile> juveniles = juvenileMapper.selectByVagueWithComic("");
        //for(Juvenile juvenile : juveniles){
        //    System.out.println(juvenile);
        //}

        //List<User> users = userMapper.selectByExample(null);
        //for(User user : users){
        //    System.out.println(user);
        //}

        User us = new User();
        us.setEmail("347348@163.com");
        userMapper.insertSelective(us);
        UserExample example  = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUserNameEqualTo("1");
        List<User> users = userMapper.selectByExample(example);
        User user = null;
        try {
            user = users.get(0);
        } catch (Exception e) {
            user = null;
        }
        System.out.println(user);


    }
}
