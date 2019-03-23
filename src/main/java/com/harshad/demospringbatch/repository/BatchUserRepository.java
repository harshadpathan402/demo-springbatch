package com.harshad.demospringbatch.repository;

import com.harshad.demospringbatch.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;



public interface BatchUserRepository extends JpaRepository<User,Integer> {

}
