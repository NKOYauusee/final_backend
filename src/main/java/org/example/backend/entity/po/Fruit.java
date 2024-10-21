package org.example.backend.entity.po;

import lombok.Data;

import java.util.Date;

@Data
public class Fruit {
    Integer id;
    String name;
    Double price;
    String locality;
    Date create_time;
}
