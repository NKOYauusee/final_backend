package org.example.backend.entity.po;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String nickname;
    private String username;
    private String password;
    private Integer type;
}
