package com.nf147.controller;

import com.nf147.dao.OrderMapper;
import com.nf147.dao.PetMapper;
import com.nf147.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@RequestMapping("/store")
public class StoreController {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private PetMapper petMapper;

    @RequestMapping(method = RequestMethod.GET)
    public String home(){
        return "home";
    }

    @RequestMapping(value = "/find/status", method = RequestMethod.GET)
    public String findByStatus(@RequestParam("status") String status){
        petMapper.fingBystatus(status);
        return "redirect:/store";
    }

    @RequestMapping(value = "/orderpet", method = RequestMethod.POST)
    public String orderPet(@Valid Order order){
        orderMapper.insert(order);
        return "redirect:/store";
    }

    @RequestMapping(value = "/find/id", method = RequestMethod.GET)
    public String fingOrderById(@RequestParam("id") int id){
        orderMapper.selectByPrimaryKey(id);
        return "redirect:/store";
    }

    @RequestMapping(value = "/del/id", method = RequestMethod.DELETE)
    public String delById(@RequestParam("id") int id){
        orderMapper.deleteByPrimaryKey(id);
        return "redirect:/store";
    }

}
