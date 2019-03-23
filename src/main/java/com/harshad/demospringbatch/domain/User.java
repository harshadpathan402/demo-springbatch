package com.harshad.demospringbatch.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "batch_user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    private Integer id;
    private String firstName;
    private String address;
    private Integer age;


}
