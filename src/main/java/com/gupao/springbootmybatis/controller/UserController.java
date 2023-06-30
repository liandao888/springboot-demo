package com.gupao.springbootmybatis.controller;

import com.gupao.springbootmybatis.domain.User;
import com.gupao.springbootmybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/user",method = {RequestMethod.GET,RequestMethod.POST})
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/listone")
    @ResponseBody
    public User listOne(String username){
        return userService.findByUsername(username);
    }


    @RequestMapping("/list")
    @ResponseBody
    public String listAll(){
        return "hello jenkins!1111122222</br>最后一次了！";
    }

    @RequestMapping(value="/add",method = RequestMethod.POST)
    @ResponseBody
    public String add(User user){
        int result=userService.insertUser(user);
        if(result>=1){
            return "添加成功";
        }else{
            return "添加失败";
        }
    }

    @RequestMapping(value="/update",method = RequestMethod.POST)
    @ResponseBody
    public String update(User user){
        int result=userService.updateUser(user);
        if(result>=1){
            return "修改成功";
        }else{
            return "修改失败";
        }
    }

    @RequestMapping(value="/delete",method = RequestMethod.GET)
    @ResponseBody
    public String delete(int id){
        int result=userService.delete(id);
        if(result>=1){
            return "删除成功";
        }else{
            return "删除失败";
        }
    }
}
