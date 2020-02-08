package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class PageController {
    @RequestMapping("hello")
    public String index(){
        return "hello";
    }

    @RequestMapping("hello2")
    public String hello2(@RequestParam(value = "name", required= false, defaultValue = "Thanos") String name, Model model){
        model.addAttribute("name", name);
        return "hello2";
    }

    @RequestMapping(value = {"hello2","/hello2/{name}"})
    public String helloPath(@PathVariable Optional<String> name, Model model){
        if(name.isPresent()){
            model.addAttribute("name", name.get());
        }else{
            model.addAttribute("name","Phoenix");
        }
        return "hello2";
    }
    @RequestMapping("calcu")
    public String calcuConvert(@RequestParam(value ="a") Integer a,@RequestParam (value = "b") Integer b, Model model){
        Integer result = a + b;
        String message = a  + "+" + b + "=" + result;
        model.addAttribute("message", message );

        return "calcu";
    }
}
