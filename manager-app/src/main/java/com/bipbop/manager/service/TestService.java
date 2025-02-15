package com.bipbop.manager.service;

import com.bipbop.manager.entity.Test;
import com.bipbop.manager.repository.TestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TestService {

    private final TestRepository testRepository;

    public List<Test> findAllTests() {
        return testRepository.findAll();
    }

    public Test createTest(String name) {
        return testRepository.save(new Test(null, name));
    }

    public Optional<Test> findTest(int testId) {
        return testRepository.findById(testId);
    }
}
