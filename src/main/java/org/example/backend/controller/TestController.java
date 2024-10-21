package org.example.backend.controller;

import jakarta.annotation.Resource;
import org.example.backend.annotation.FucLogger;
import org.example.backend.entity.vo.ResponseVo;
import org.example.backend.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin("*")
@RestController
public class TestController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @Resource
    UserMapper userMapper;

    //@RepeatSubmit
    @FucLogger("TestController")
    @RequestMapping("/test")
    public ResponseVo test() {
        return resSuccess();
    }
}
