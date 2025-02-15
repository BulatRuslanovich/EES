package com.bipbop.manager.controller;

import com.bipbop.manager.controller.payload.NewTestPayload;
import com.bipbop.manager.entity.Test;
import com.bipbop.manager.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("tests")
public class TestController {

    private final TestService testService;

    @GetMapping("list")
    public String getTestList(Model model) {
        model.addAttribute("tests", testService.findAllTests());

        return "tests/list";
    }

    @GetMapping("create")
    public String getNewTest() {
        return "tests/new_test";
    }

    @PostMapping("create")
    public String createNewTest(NewTestPayload payload) {
        Test test = testService.createTest(payload.name());
        return "redirect:/tests/%d".formatted(test.getId());
    }

    @GetMapping("{testId:\\d+}")
    public String getTest(@PathVariable("testId") int testId, Model model) {
        model.addAttribute("test", testService.findTest(testId).orElseThrow());

        return "tests/test";
    }

}
