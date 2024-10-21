package org.example.backend.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.backend.entity.po.User;

@Mapper
public interface UserMapper {

    int insert(User user);

    int delete(User user);

    User selectByUsername(String username);

    int update(User user);
}
