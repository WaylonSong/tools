package com.cputech.annotation.demo.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by song on 2017/9/27.
 */
@Entity
@Data
public class Test {
    @Id
    Long id;
}
