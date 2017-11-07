package com.cputech.modules.usermsg.repository;

import com.cputech.modules.usermsg.model.TestModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by song on 2017/11/3.
 */

@Repository
public interface TestModelRepository extends CrudRepository<TestModel, Long> {
}
