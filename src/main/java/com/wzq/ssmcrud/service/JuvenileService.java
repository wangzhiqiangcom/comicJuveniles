package com.wzq.ssmcrud.service;

import com.wzq.ssmcrud.bean.Juvenile;
import com.wzq.ssmcrud.bean.JuvenileExample;
import com.wzq.ssmcrud.dao.JuvenileMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JuvenileService {

    @Autowired
    JuvenileMapper juvenileMapper;

    /**
     * 获取所有juvenile
     * @return
     */
    public List<Juvenile> getAll() {

        return juvenileMapper.selectByExampleWithComic(null);
    }

    /**
     * 实现模糊查询（根据用户的输入查询各字段是否有相关的字符串）
     * @param text
     * @return
     */
    public List<Juvenile> selectByVague(String text) {
        //JuvenileExample example = new JuvenileExample();
        //JuvenileExample.Criteria criteria = example.createCriteria();
        //criteria.andJNameLike("%" + text + "%");
        List<Juvenile> juveniles = juvenileMapper.selectByVagueWithComic(text);
        return  juveniles;
    }


    /**
     * 插入新的juvenile
     * @param juvenile
     * @return
     */
    public int insertJuvenile(Juvenile juvenile) {
        System.out.println("经过了service-------saveJuvenile");

        try {

            juvenileMapper.insertSelective(juvenile);
            System.out.println("service层插入成功");
            return 1;
        } catch (Exception e) {
            System.out.println("service层插入为空-异常被处理");
            return -1;
        }
    }


    /**
     * 单个删除人物
     * @param id
     */
    public void delJvn(Integer id) {
        juvenileMapper.deleteByPrimaryKey(id);
    }

    /**
     * 批量多个或者单个删除
     * @param delIds
     */
    public void delMoreJuvenile(List<Integer> delIds) {
        JuvenileExample example = new JuvenileExample();
        JuvenileExample.Criteria criteria = example.createCriteria();
        criteria.andJuvenileIdIn(delIds);

        juvenileMapper.deleteByExample(example);
    }

    /**
     * 更新时获取单个人物的信息
     * @param id
     */
    public Juvenile getOne(Integer id) {
        Juvenile juvenile = juvenileMapper.selectByPrimaryKeyWithComic(id);
        return juvenile;
    }

    /**
     * 更新人物，并返回更新后的信息
     * @param juvenile
     * @return
     */
    public Juvenile updateJuvenileById(Juvenile juvenile) {
        //Juvenile jvn = new Juvenile();
        //JuvenileExample example = new JuvenileExample();
        //JuvenileExample.Criteria criteria = example.createCriteria();
        //criteria.andJNameEqualTo(juvenile.getjName());
        //criteria.andGenderEqualTo(juvenile.getGender());
        //criteria.andWeaponEqualTo(juvenile.getWeapon());
        //criteria.andSectEqualTo(juvenile.getSect());
        //criteria.andPortraitUrlEqualTo(juvenile.getPortraitUrl());
        //criteria.andCIdEqualTo(juvenile.getcId());
        //juvenileMapper.updateByExampleSelective(jvn,example);
        //JuvenileExample jvnEpl = new JuvenileExample();
        //JuvenileExample.Criteria criteriaJvnEpl = jvnEpl.createCriteria();
        //criteriaJvnEpl.andJNameEqualTo(juvenile.getjName());
        //criteriaJvnEpl.andGenderEqualTo(juvenile.getGender());
        //criteriaJvnEpl.andWeaponEqualTo(juvenile.getWeapon());
        //criteriaJvnEpl.andSectEqualTo(juvenile.getSect());
        //criteriaJvnEpl.andPortraitUrlEqualTo(juvenile.getPortraitUrl());
        //System.out.println(jvnEpl);
        //List<Juvenile> jvnList = juvenileMapper.selectByExampleWithComic(jvnEpl);
        //System.out.println(jvnList);
        //Juvenile jvn = jvnList.get(0);
        //Integer id = jvn.getJuvenileId();
        //juvenile.setJuvenileId(id);
        //System.out.println(juvenile);
        //juvenileMapper.updateByPrimaryKeySelective(juvenile);
        //Juvenile newJvn = juvenileMapper.selectByPrimaryKeyWithComic(id);
        juvenileMapper.updateByPrimaryKeySelective(juvenile);
        Juvenile newJvn = juvenileMapper.selectByPrimaryKeyWithComic(juvenile.getJuvenileId());
        System.out.println(newJvn);

        return newJvn;
    }





}
