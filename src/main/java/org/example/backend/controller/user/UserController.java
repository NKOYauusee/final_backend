package org.example.backend.controller.user;


import jakarta.annotation.Resource;
import jakarta.validation.constraints.NotBlank;
import org.example.backend.annotation.FucLogger;
import org.example.backend.controller.BaseController;
import org.example.backend.entity.po.User;
import org.example.backend.entity.vo.ResponseVo;
import org.example.backend.exception.BusinessException;
import org.example.backend.service.UserService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class UserController extends BaseController {

    @Resource
    UserService userService;


    @FucLogger("login")
    @RequestMapping("/login")
    public ResponseVo login(@RequestBody User user) throws BusinessException {
        userService.login(user);
        return resSuccess("登录成功", null);
    }

    @FucLogger("register")
    @RequestMapping("/register")
    public ResponseVo register(@RequestBody User user) throws BusinessException {
        userService.register(user);
        return resSuccess("注册成功", null);
    }

    @FucLogger("update")
    @RequestMapping("/update")
    public ResponseVo update(
            @NotBlank String username,
            @NotBlank String oldPwd,
            @NotBlank String newPwd) throws BusinessException {
        userService.update(username, oldPwd, newPwd);
        return resSuccess("修改成功", null);
    }

}
