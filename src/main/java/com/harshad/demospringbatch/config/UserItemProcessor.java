package com.harshad.demospringbatch.config;

import com.harshad.demospringbatch.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;

@Slf4j
public class UserItemProcessor implements ItemProcessor<User,User> {


    @Override
    public User process(User user) throws Exception {
    log.info("In Item processor with value {}",user);
    return user;
    }
}
