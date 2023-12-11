package com.lec.ch04_friend.repository;

import com.lec.ch04_friend.domain.Friend;
import org.springframework.stereotype.Repository;

import java.util.*;

//@Repository
public class FriendRepositoryImpl implements FriendRepository{
    private static Map<Long, Friend> store = new HashMap<>();
    private static long sequence = 0;
    @Override
    public Friend save(Friend friend) {
        friend.setId(++sequence);
        store.put(sequence, friend);
        return friend;
    }

    @Override
    public Optional<Friend> findById(Long id) {
        return Optional.ofNullable(store.get(id)); //id가 null이면nulㅣ을 리턴하기때문에 옵셔널로감쌈
    }

    @Override
    public Optional<Friend> finalByTel(String tel) {
        Iterator<Long> iterator = store.keySet().iterator();
        while(iterator.hasNext()){
            Long id = iterator.next();
            Friend friend = store.get(id);
            if(tel.equals(friend.getTel())){
                return Optional.ofNullable(friend);
            }//if
        }//while
        return Optional.empty();
    }

    @Override
    public List<Friend> findAll() {
        return new ArrayList<>(store.values()); //hashMap을 arrayList로
    }

    @Override
    public void deleteAll() {
        store.clear();
    }
}
