package com.example.demo.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

//注解为controller将当前的类自动识别为一个容器交给springBoot管理，并且识别为
//controller,允许这个类去接受前端的一个请求
@Controller
public class GreetingController {

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        //接收传输过来的name值，并返回前端
        model.addAttribute("name", name);
        //去templates里面找greeting文件
        return "greeting";
    }

}
