package org.example.backend.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.example.backend.entity.po.Retailer;
import org.example.backend.mapper.RetailerMapper;
import org.example.backend.service.RetailerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("RetailerServiceImpl")
public class RetailerServiceImpl implements RetailerService {
    @Resource
    RetailerMapper retailerMapper;


    @Override
    public void insert(Retailer retailer) {
        retailerMapper.insert(retailer);
    }

    @Override
    public void update(Retailer retailer) {
        retailerMapper.update(retailer);
    }

    @Override
    public List<Retailer> selectAll(int page) {
        PageHelper.startPage(page, 10);
        List<Retailer> res = retailerMapper.selectAll();
        return new PageInfo<Retailer>().getList();
    }
}
