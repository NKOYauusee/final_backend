package org.example.backend.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.backend.entity.po.Fruit;

import java.util.List;

@Mapper
public interface FruitMapper {
    int insert(Fruit fruit);

    int delete(Fruit fruit);

    List<Fruit> selectAll();

    int update(Fruit fruit);
}
