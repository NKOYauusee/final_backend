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

    public Date getCreate_time() {
        return create_time;
    }

    public Double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getLocality() {
        return locality;
    }

    public Integer getId() {
        return id;
    }
}
