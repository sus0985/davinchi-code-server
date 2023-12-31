package com.perfectdk.davinci.controller;

import com.perfectdk.davinci.model.DavinciResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class DavinciLoginController {

    @GetMapping("/login")
    public DavinciResponse login(@RequestParam String id) {
        log.info("logged in with id: [{}]", id);
        return new DavinciResponse(200, "Login success");
    }
}
