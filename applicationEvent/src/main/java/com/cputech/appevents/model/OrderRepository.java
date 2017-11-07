package com.cputech.appevents.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by song on 2017/9/21.
 */
@Repository
public interface OrderRepository  extends CrudRepository<Order, Integer>{
}
