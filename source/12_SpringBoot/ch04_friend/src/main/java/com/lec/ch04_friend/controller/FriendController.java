package com.lec.ch04_friend.controller;

import com.lec.ch04_friend.domain.Friend;
import com.lec.ch04_friend.service.FriendService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.URLEncoder;

@Controller
@Slf4j
@RequestMapping("friend")
public class FriendController {
    private FriendService friendService;
    @Autowired //생성자 주입
    public FriendController(FriendService friendService) { //생성자 단축키 alt+insert
        this.friendService = friendService;
    }
    @GetMapping("join")
    public String join(){
        return "friend/join";
    }
    @PostMapping("join")
    public String join(Friend friend, Model model){
        try{
            friendService.join(friend);
        }catch(IllegalStateException e){
//            log.info("친구등록 예외 매세지" + e.getMessage());
//            String errMsg = URLEncoder.encode(e.getMessage()) ; //이미 존재하는 친구입니다
//            return "redirect:join?errMsg=" + errMsg;
            model.addAttribute("errMsg", e.getMessage());
            return "friend/join";
        }
        return "forward:list";
    }
    @PostMapping("list")
    public String listPost(Model model){
        model.addAttribute("friends", friendService.findFriends());
        return "friend/list";
    }
    @GetMapping("list")
    public String listGet(Model model){
        model.addAttribute("friends", friendService.findFriends());
        return "friend/list";
    }
    @GetMapping("findOne")
    public String findOne(long id, Model model){
        model.addAttribute("friend", friendService.findOne(id).get());
        return "friend/findOne";
    }

}
