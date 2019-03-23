package com.harshad.demospringbatch.config;

import com.harshad.demospringbatch.domain.User;
import com.harshad.demospringbatch.repository.BatchUserRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserItemWriter implements ItemWriter<User> {

    @Autowired
    private BatchUserRepository batchUserRepository;

    @Override
    public void write(List<? extends User> list) throws Exception {

        batchUserRepository.saveAll(list);
/*
        for (User user: list) {
            batchUserRepository.save(user);
        }*/

    }
}
