package org.example.backend.entity.po;

import lombok.Data;

import java.util.Date;

@Data
public class Retailer {
    Integer id;
    String name;
    String phone;
    String address;
    // 0 停用  1 启用
    Integer status;
    Date create_time;
}
