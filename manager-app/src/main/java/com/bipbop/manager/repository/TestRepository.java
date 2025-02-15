package com.bipbop.manager.repository;

import com.bipbop.manager.entity.Test;

import java.util.List;
import java.util.Optional;

public interface TestRepository {


    List<Test> findAll();

    Test save(Test test);

    Optional<Test> findById(int testId);
}
