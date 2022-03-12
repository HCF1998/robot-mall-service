package com.h2.robotmallservice.controller.admin;

import com.h2.robotmallservice.common.ResponseResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminIndexController {

    @GetMapping("/index")
    public ResponseResult index(){
        return ResponseResult.success();
    }
}
