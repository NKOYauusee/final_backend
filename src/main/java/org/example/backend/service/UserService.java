package org.example.backend.service;


import org.example.backend.entity.po.User;
import org.example.backend.exception.BusinessException;

public interface UserService {
    void login(User user) throws BusinessException;

    void register(User user) throws BusinessException;

    void update(String username, String oldPwd, String newPwd) throws BusinessException;
}
