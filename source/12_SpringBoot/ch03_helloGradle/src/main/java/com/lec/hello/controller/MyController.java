package com.lec.hello.controller;

import com.lec.hello.domain.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
public class MyController {
    @GetMapping("/")
    public String index(Model model){
        log.info("웹프로젝트 시작");
        model.addAttribute("greeting", "Hello,Spring");
        return "home";
    }
    @GetMapping("confirm") //confirm?name=홍길동
    @ResponseBody
    public String confirm(@RequestParam(value = "name",
                                        required = false,
                                        defaultValue = "아무개") String name){
        return name + "님 반갑습니다. 맛점하세요"; //브라우저에 문구출력
    }
    @GetMapping("json") //json?name=홍길동&age=20 두개가person으로 들어감
    @ResponseBody
    public Person json(@RequestParam(value= "name",
                                    required = false,
                                    defaultValue = "아무개")String name,
                       @RequestParam(value="age",
                                    required = false, //view단에서 입력이 없을 시
                                    defaultValue = "5")int age){
        Person person = new Person(name, age);
        return person;
    }
}
