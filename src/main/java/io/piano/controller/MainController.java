package io.piano.controller;

import io.piano.configuration.QueryConfig;
import io.piano.response.StackResponse;
import io.piano.sender.RestSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

    @Autowired
    private RestSender rest;
    @Autowired
    private QueryConfig config;

    @RequestMapping(value ="/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @PostMapping("/getResult")
    public String getResult(@RequestBody String title, Model model) {
        StackResponse resp = rest.sendRequest(
                new StringBuilder().append(config.getRequestUri()).append(title).toString());
        model.addAttribute("resp", resp);
        return "result";
    }
}