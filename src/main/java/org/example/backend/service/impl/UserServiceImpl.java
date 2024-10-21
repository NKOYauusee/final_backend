package org.example.backend.service.impl;

import jakarta.annotation.Resource;
import org.example.backend.entity.po.User;
import org.example.backend.exception.BusinessException;
import org.example.backend.mapper.UserMapper;
import org.example.backend.service.UserService;
import org.springframework.stereotype.Service;

@Service("UserServiceImpl")
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;

    @Override
    public void login(User user) throws BusinessException {
        if (user.getUsername().isEmpty() || user.getPassword().isEmpty()) {
            throw new BusinessException("账户名或密码不能为空");
        }

        User u = userMapper.selectByUsername(user.getUsername());
        if (u == null)
            throw new BusinessException("用户不存在");

        if (!u.getPassword().equals(user.getPassword()))
            throw new BusinessException("密码错误");
    }

    @Override
    public void register(User user) throws BusinessException {
        if (user.getUsername().isEmpty() || user.getPassword().isEmpty())
            throw new BusinessException("账户名或密码不能为空");

        User u = userMapper.selectByUsername(user.getUsername());
        if (u != null)
            throw new BusinessException("该用户已注册");

        userMapper.insert(user);
    }

    @Override
    public void update(String username, String oldPwd, String newPwd) throws BusinessException {
        User u = userMapper.selectByUsername(username);

        if (!u.getPassword().equals(oldPwd))
            throw new BusinessException("原始密码输入错误");


        u.setPassword(newPwd);

        userMapper.update(u);
    }
}
