package com.cputech.modules.usermsg.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by song on 2017/11/3.
 */
@Entity
@Data
public class TestModel {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
}
