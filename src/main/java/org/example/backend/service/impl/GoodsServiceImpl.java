package org.example.backend.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.example.backend.entity.po.Contract;
import org.example.backend.entity.po.Fruit;
import org.example.backend.entity.po.Retailer;
import org.example.backend.mapper.ContractMapper;
import org.example.backend.mapper.FruitMapper;
import org.example.backend.mapper.RetailerMapper;
import org.example.backend.service.GoodsService;
import org.springframework.stereotype.Service;

import java.util.Date;
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
    public int getPageSize() {
        return fruitMapper.selectAll().size() / 10 + 1;
    }


    @Override
    public void update(Fruit fruit) {
        fruitMapper.update(fruit);
    }

    @Resource
    RetailerMapper retailerMapper;

    @Resource
    ContractMapper contractMapper;

    @Override
    public void delete(Fruit fruit) {
        fruitMapper.delete(fruit);

        List<Retailer> res = retailerMapper.selectAll(fruit.getId());
        for (Retailer r : res) {
            r.setStatus(0);
            retailerMapper.update(r);

            Contract contract = new Contract();
            contract.setRetailer_id(r.getId());
            contract.setGoodsId(r.getGoodsId());

            contractMapper.delete(contract);
        }
    }

    @Override
    public void insert(Fruit fruit) {
        fruit.setCreate_time(new Date());
        fruitMapper.insert(fruit);
    }
}
