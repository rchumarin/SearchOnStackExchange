package io.piano.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.piano.configuration.QueryConfig;
import io.piano.sender.RestSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    @Autowired
    private RestSender rest;
    @Autowired
    private QueryConfig config;

    private ObjectMapper objectMapper = new ObjectMapper();

    @RequestMapping(value ="/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @PostMapping("/getResult")
    @ResponseBody
    public String getResult(@RequestBody String title) {
        String json = rest.sendRequest(
                new StringBuilder().append(config.getRequestUri()).append(title).toString());
        return json;
    }
}