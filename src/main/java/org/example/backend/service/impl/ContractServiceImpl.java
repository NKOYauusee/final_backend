package org.example.backend.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.example.backend.entity.po.Contract;
import org.example.backend.mapper.ContractMapper;
import org.example.backend.service.ContractService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("ContractServiceImpl")
public class ContractServiceImpl implements ContractService {
    @Resource
    ContractMapper contractMapper;

    @Override
    public void insert(Contract contract) {
        contractMapper.insert(contract);
    }

    @Override
    public void delete(Contract contract) {
        contractMapper.delete(contract);
    }

    @Override
    public void update(Contract contract) {
        contractMapper.update(contract);
    }

    @Override
    public List<Contract> selectAll(int page) {
        PageHelper.startPage(0, 10);
        List<Contract> res = contractMapper.selectAll();

        return new PageInfo<Contract>().getList();
    }
}
