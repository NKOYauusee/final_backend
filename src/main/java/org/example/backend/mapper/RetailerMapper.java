package org.example.backend.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.example.backend.entity.po.Retailer;

import java.util.List;

@Mapper
public interface RetailerMapper {
    void insert(Retailer retailer);

    void update(Retailer retailer);

    List<Retailer> selectAll();

}
