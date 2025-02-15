package com.bipbop.manager.repository;

import com.bipbop.manager.entity.Test;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

@Repository
public class InmemTestRepository implements TestRepository {

    List<Test> tests = Collections.synchronizedList(new ArrayList<>());

    InmemTestRepository() {
        IntStream.range(0, 10).forEach(i -> tests.add(new Test(i, "Test #" + i)));
    }

    @Override
    public List<Test> findAll() {
        return Collections.unmodifiableList(tests);
    }

    @Override
    public Test save(Test test) {
        test.setId(tests.size() + 1);
        tests.add(test);
        return test;
    }

    @Override
    public Optional<Test> findById(int testId) {
        return tests.stream().filter(test -> test.getId() == testId).findFirst();
    }
}
