package com.nf147.controller;

import com.nf147.dao.PetMapper;
import com.nf147.entity.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/")
public class PetController {

    @Autowired
    private PetMapper petMapper;

    @RequestMapping(method = RequestMethod.GET)
    public String home (Model model){
        List<Pet> pets = petMapper.selectAll();
        model.addAttribute("pets", pets);
        return "home";
    }

    @RequestMapping(value = ("/add"), method = RequestMethod.POST)
    public String add (Pet pet){
        petMapper.insert(pet);
        return "redirect:/";
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public String update(@Valid Pet pet) {
        petMapper.updateByPrimaryKey(pet);
        return "redirect:/";
    }

    @RequestMapping(value = "/find/status", method = RequestMethod.GET)
    public String fingBystatus(@RequestParam("status") String status){
        petMapper.fingBystatus(status);
        return "redirect:/";
    }

    @RequestMapping(value = "/find/id", method = RequestMethod.GET)
    public String findById(@RequestParam("id") int id){
        petMapper.selectByPrimaryKey(id);
        return "redirect:/";
    }

    @RequestMapping(value = "/update/form", method = RequestMethod.POST)
    public String updateForm(@Valid Pet pet){
        petMapper.updateByPrimaryKey(pet);
        return "redirect:/";
    }

    @RequestMapping(value = "/del/{id}", method = RequestMethod.DELETE)
    public String del(@PathVariable("id") int id){
        petMapper.deleteByPrimaryKey(id);
        return "redirect:/";
    }



}
