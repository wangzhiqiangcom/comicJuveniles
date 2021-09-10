package com.wzq.ssmcrud.controller;

import com.wzq.ssmcrud.bean.Msg;
import com.wzq.ssmcrud.bean.User;
import com.wzq.ssmcrud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    /**
     *
     * @return
     */
    @RequestMapping("/toWelcome")
    public String toWelcome(@RequestParam(value = "username")String username,Model model){
        model.addAttribute("username",username);
        return "Jump";
    }

    /**
     * 登录验证
     * @param user
     * @return
     */
    @RequestMapping("/loginUser")
    @ResponseBody
    public Msg loginUser(User user){
        System.out.println(user);
        String findResult;
        String loginResult;
        try {
            User findUser = userService.findUserByUsername(user.getUserName());
            findResult = "";
            String username = findUser.getUserName();
            System.out.println("用户输入密码" + user.getPassword());
            System.out.println("数据库密码" + findUser.getPassword());
            if(user.getPassword().equals(findUser.getPassword())){
                loginResult = "";
                return Msg.success().add("loginResult",loginResult).add("findResult",findResult).add("username",username);
            }else{
                loginResult = "密码错误";
                return Msg.fail().add("loginResult",loginResult).add("findResult",findResult);
            }
        } catch (Exception e) {
            findResult = "用户名不存在！";
            return Msg.fail().add("findResult",findResult);
        }


    }

    /**
     * 跳转到登录页面
     * @return
     */
    @RequestMapping("/login")
    public String login(){

        return "login";
    }

    /**
     * 跳转到注册页面
     * @return
     */
    @RequestMapping("/register")
    public String register(){

        return "register";
    }

    /**
     * 插入user
     * @param user
     * @return
     */
    @RequestMapping(value = "/insertUser",method = RequestMethod.POST)
    @ResponseBody
    public Msg insertUser(User user){
        System.out.println(user);
        User newUser = new User();
        try {
            newUser = userService.insertUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("插入后 " + newUser);
        String registerResult = "注册成功！";

        return Msg.success().add("registerResult",registerResult);
    }

    /**
     * 查询用户名是否已经存在
     * @param username
     * @return
     */
    @RequestMapping("/checkUsername")
    @ResponseBody
    public Msg checkUsername(@RequestParam("username") String username){
        System.out.println(username);
        String selectResult;
        User user = null;
        try {
            user = userService.selectUserByUsername(username);
        } catch (Exception e) {
            user = null;
        }
        if(user != null){
            selectResult = "用户名重复！";
            return Msg.fail().add("selectResult",selectResult);
        }else{
            selectResult = "";
            return Msg.success().add("selectResult",selectResult);
        }

    }
}
