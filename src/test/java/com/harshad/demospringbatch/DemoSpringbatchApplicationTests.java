package com.harshad.demospringbatch;

import com.harshad.demospringbatch.domain.User;
import com.harshad.demospringbatch.repository.BatchUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class DemoSpringbatchApplicationTests {

    @Autowired
    BatchUserRepository batchUserRepository;

    @Test
    @DirtiesContext
    public void contextLoads() {

        User  user =new User(1,"Harshad","pune",29);
        User save = batchUserRepository.save(user);
        log.info("user object inserted with values : {}", save);
        log.info("fetching all values {}",batchUserRepository.findAll());

    }

}
