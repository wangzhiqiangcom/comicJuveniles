package com.wzq.ssmcrud.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wzq.ssmcrud.bean.Juvenile;
import com.wzq.ssmcrud.bean.JuvenileExample;
import com.wzq.ssmcrud.bean.Msg;
import com.wzq.ssmcrud.service.JuvenileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class JuvenileController {

    @Autowired
    JuvenileService juvenileService;

    /**
     * 更新员工信息
     * @param juvenile
     * @return
     */
    @RequestMapping(value = "/updateJuvenile",method = RequestMethod.PUT)
    @ResponseBody
    public Msg updateJuvenile(Juvenile juvenile,@RequestParam(value = "juvenileId") Integer jvenileId){
        System.out.println(juvenile);
        juvenile.setJuvenileId(jvenileId);
        System.out.println(juvenile);
        Juvenile newJvn = juvenileService.updateJuvenileById(juvenile);
        String updateResult = "更新成功！";
        return Msg.success().add("updateResult",updateResult).add("newJvn",newJvn);
    }

    /**
     * 根据id查询单个员工的信息
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/getOneJuvenile",method = RequestMethod.GET)
    @ResponseBody
    public Msg getOneJuvenile(@RequestParam(value = "id")Integer id,Model model){
        Juvenile juvenile = juvenileService.getOne(id);
        model.addAttribute("juvenile",juvenile);
        return Msg.success().add("juvenile",juvenile);
    }


    /**
     * 批量删除单个或者多个人物
     * @param ids
     * @return
     */
    @RequestMapping(value = "/delMoreJuvenile",method = RequestMethod.DELETE)
    @ResponseBody
    public Msg delMoreJuvenile(@RequestParam(value = "ids") String ids){
        //System.out.println(ids);
        if(ids.contains("-")){
            List<Integer> delIds = new ArrayList<>();
            String[] strIds = ids.split("-");
            //System.out.println(Arrays.toString(strIds));
            //组装id的集合
            for(String str : strIds){
                delIds.add(Integer.parseInt(str));
            }
            juvenileService.delMoreJuvenile(delIds);
        }else{
            Integer delIds = Integer.parseInt(ids);
            juvenileService.delJvn(delIds);
        }
        String delMoreJuvenile = "删除成功！";
        return Msg.success().add("delMoreJuvenile",delMoreJuvenile);
    }

    /**
     * 单个删除人物
     * @param id
     * @return
     */
    @RequestMapping(value = "/delJuvenile",method = RequestMethod.DELETE)
    @ResponseBody
    public Msg delJuvenile(@RequestParam(value = "id") Integer id){
        juvenileService.delJvn(id);
        String delSingleResult = "删除成功！";
        return Msg.success().add("delSingleResult",delSingleResult);
    }

    /**
     * 保存人物
     *
     * @return
     */
    @RequestMapping(value = "/saveJuvenile",method = RequestMethod.POST)
    @ResponseBody
    public Msg saveJuvenile(Juvenile juvenile){
        System.out.println(juvenile);

        System.out.println("经过了controller-------saveJuvenile");



        String saveResult;
        try {
            juvenileService.insertJuvenile(juvenile);
            System.out.println("controller层插入成功！");
            saveResult = "人物添加成功！";
            return Msg.success().add("saveResult",saveResult);
        } catch (Exception e) {

            System.out.println("controller层插入为空-异常被处理!");
            saveResult = "人物添加失败！";
            return Msg.fail().add("saveResult",saveResult);
            //e.printStackTrace();
        }





    }

    /**
     * 搜索结果
     * @param text
     * @param model
     * @return
     */
    @RequestMapping("/searchJuveniles")
    public String searchJuveniles(@RequestParam(value = "text",defaultValue = "") String text,Model model){

        List<Juvenile> juveniles = juvenileService.selectByVague(text);
        model.addAttribute("searchResult",juveniles);

        return "searchResult";
    }


    //@RequestMapping("/getJuveniles")
    //@ResponseBody
    public Msg getJuvenileWithJson(@RequestParam(value = "pn",defaultValue = "1") Integer pn, Model model){

        //引入pageHelper分页插件
        //在查询之前只需要调用，传入页码，以及每页的大小
        PageHelper.startPage(pn,6);

        List<Juvenile> juveniles = juvenileService.getAll();
        //使用pageInfo包装查询后的结果，只将pageInfo交给页面就行
        //pageInfo封装了详细分页信息，包括查询出来的数据，5表示传入连续显示的页数
        PageInfo page = new PageInfo(juveniles,5);
        model.addAttribute("pageInfo",page);
        return Msg.success().add("pageInfo",page);
    }

    /**
     * 获取所有juvenile信息，并且分页
     * @param pn
     * @param model
     * @return
     */
    @RequestMapping("/getJuveniles")
    public String getJuvenile(@RequestParam(value = "pn",defaultValue = "1") Integer pn,Model model){
        //System.out.println("经过了getJuveniles方法");

        //引入pageHelper分页插件
        //在查询之前只需要调用，传入页码，以及每页的大小
        PageHelper.startPage(pn,6);

        List<Juvenile> juveniles = juvenileService.getAll();
        //使用pageInfo包装查询后的结果，只将pageInfo交给页面就行
        //pageInfo封装了详细分页信息，包括查询出来的数据，5表示传入连续显示的页数
        PageInfo page = new PageInfo(juveniles,5);
        model.addAttribute("pageInfo",page);

        return "list";
    }

    /**
     * 回到首页
     * @return
     */
    @RequestMapping("/toHome")
    public String toHome(){

        return "Jump";
    }
}
