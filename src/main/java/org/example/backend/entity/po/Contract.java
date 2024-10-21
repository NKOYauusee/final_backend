package org.example.backend.entity.po;

import lombok.Data;

import java.util.Date;

@Data
public class Contract {
    Integer id;
    String code;
    Integer type; // 1 省内 2 省外
    Integer retailer_id;
    Date create_time;
}
