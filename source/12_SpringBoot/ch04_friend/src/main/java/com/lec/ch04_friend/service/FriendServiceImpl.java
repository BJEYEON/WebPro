package com.lec.ch04_friend.service;

import com.lec.ch04_friend.domain.Friend;
import com.lec.ch04_friend.repository.FriendRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
//@Service
@Slf4j
public class FriendServiceImpl implements FriendService{
    //테스트 로직 생성 :ctrl + shift + t
    private FriendRepository repository;
    //@Autowired //생성자 단축키 :alt+insert
    public FriendServiceImpl(FriendRepository repository) {
        this.repository = repository;
    }

    @Override
    public void join(Friend friend) { //중복된 전화번호는 저장이 안되도록
        validateDuplicateFriendTel(friend);
        repository.save(friend); //중복된 전화번호가 아닐떄만save
    }
    private void validateDuplicateFriendTel(Friend friend){ //전화번호 중복체크
        Optional<Friend> result = repository.finalByTel(friend.getTel());
        result.ifPresent(friend1 -> {
            //중복된 전화번호일경우 예외발생
            throw new IllegalStateException("이미 존재하는 친구입니다.");
        });
    }
    @Override
    public Optional<Friend> findOne(long id) {
        return repository.findById(id);
    }

    @Override
    public List<Friend> findFriends() {
        return repository.findAll();
    }
}
