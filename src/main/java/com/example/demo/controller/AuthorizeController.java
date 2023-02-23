package com.example.demo.controller;

import com.example.demo.dto.AccessTokenDto;
import com.example.demo.dto.GithubUser;
import com.example.demo.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

//注解为controller将当前的类自动识别为一个容器交给springBoot管理，并且识别为
//controller,允许这个类去接受前端的一个请求,作为路由api的一个承载着
@Controller
public class AuthorizeController {

    //通过autowired注解自动把spring容器中实例化后的对象加载到当前的上下文
    @Autowired
    private GithubProvider githubProvider;
    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state) {
        AccessTokenDto accessTokenDto = new AccessTokenDto();
        accessTokenDto.setClient_id("7de8babd6ff94940e71b");
        accessTokenDto.setClient_secret("3323440942cc2822ebdda362f278a47e61c342c9");
        accessTokenDto.setCode(code);
        System.out.println(code);
        accessTokenDto.setRedirect_uri("http://localhost:8887/callback");
        accessTokenDto.setState(state);
        String accessToken = githubProvider.getAccessToken(accessTokenDto);
        GithubUser user = githubProvider.getUser(accessToken);
        System.out.println(user.getName());
        return  "index";
    }
}
