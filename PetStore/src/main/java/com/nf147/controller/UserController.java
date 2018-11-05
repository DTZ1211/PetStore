package com.nf147.controller;

import com.nf147.dao.UserMapper;
import com.nf147.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping(method = RequestMethod.GET)
    public String home(){
        return "home";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addUser(@Valid User user){
        userMapper.insert(user);
        return "redirect:/user";
    }

    @RequestMapping(value = "/array", method = RequestMethod.GET)
    public String insertUserArray(@RequestParam("arrayList") ArrayList<User> arrayList){
        for (int i = 0; i < arrayList.size(); i++) {
            User users = arrayList.get(i);
            userMapper.insert(users);
        }
        return "redirect:/user";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String insertUserList(@RequestParam("list") List<User> list){
        for (int i = 0; i < list.size(); i++) {
            User users = list.get(i);
            userMapper.insert(users);
        }
        return "redirect:/user";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(@RequestParam("username") String username, @RequestParam("password") String password){
        List<User> users = userMapper.selectAll();
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            if (user.getUsername() == username && user.getPassword() == password){
                return "/mainpage";
            }
        }
        return "/loginpage";
    }

    @RequestMapping(value = "/clearlogin", method = RequestMethod.GET)
    public String clearlogin(@RequestParam("username") String username){
        return "";
    }

    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public String updateuser(@RequestParam("id") int id){
        User user = userMapper.selectByPrimaryKey(id);
        userMapper.updateByPrimaryKey(user);
        return "redirect:/user";
    }

    @RequestMapping(value = "/deluser", method = RequestMethod.DELETE)
    public String deluser(@RequestParam("id") int id){
        userMapper.deleteByPrimaryKey(id);
        return "redirect:/user";
    }

}
