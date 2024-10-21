package org.example.backend.service;

import org.example.backend.entity.po.Fruit;

import java.util.List;

public interface GoodsService {
    List<Fruit> selectAll(int page);

    void update(Fruit fruit);

    void delete(Fruit fruit);

    void insert(Fruit fruit);
}
