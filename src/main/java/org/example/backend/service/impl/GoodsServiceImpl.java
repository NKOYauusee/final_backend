package org.example.backend.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.example.backend.entity.po.Fruit;
import org.example.backend.mapper.FruitMapper;
import org.example.backend.service.GoodsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("GoodsServiceImpl")
public class GoodsServiceImpl implements GoodsService {
    @Resource
    FruitMapper fruitMapper;

    @Override
    public List<Fruit> selectAll(int page) {
        PageHelper.startPage(page, 10);
        List<Fruit> goods = fruitMapper.selectAll();

        return new PageInfo<>(goods).getList();
    }

    @Override
    public void update(Fruit fruit) {
        fruitMapper.update(fruit);
    }

    @Override
    public void delete(Fruit fruit) {
        fruitMapper.delete(fruit);
    }

    @Override
    public void insert(Fruit fruit) {
        fruitMapper.insert(fruit);
    }
}
