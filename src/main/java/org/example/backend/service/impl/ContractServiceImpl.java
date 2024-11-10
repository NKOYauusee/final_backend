package org.example.backend.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.example.backend.entity.po.Contract;
import org.example.backend.entity.po.Retailer;
import org.example.backend.mapper.ContractMapper;
import org.example.backend.mapper.RetailerMapper;
import org.example.backend.service.ContractService;
import org.example.backend.service.RetailerService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;


@Service("ContractServiceImpl")
public class ContractServiceImpl implements ContractService {
    @Resource
    ContractMapper contractMapper;

//    @Resource
//    RetailerService retailerService;

    @Override
    public void insert(Contract contract) {
        contract.setCode(UUID.randomUUID().toString());
        contract.setCreate_time(new Date());
        contractMapper.insert(contract);
    }

    @Override
    public void batchInsert(int type, List<Integer> retailer_ids) {
        Contract contract = new Contract();
        contract.setCode(UUID.randomUUID().toString());
        for (int id : retailer_ids) {
            contract.setId(id);
            contractMapper.insert(contract);
        }
    }

    @Resource
    RetailerMapper retailerMapper;

    @Override
    public void delete(Contract contract) {
        contractMapper.delete(contract);

        Retailer r = new Retailer();
        r.setId(contract.getRetailer_id());
        r.setGoodsId(contract.getGoodsId());
        r.setStatus(0);

        retailerMapper.update(r);
    }

    @Override
    public void update(Contract contract) {
        contractMapper.update(contract);
    }

    @Override
    public void updateByCode(Contract contract) {

    }

    @Override
    public List<Contract> selectAll(int page) {
        PageHelper.startPage(0, 10);
        List<Contract> res = contractMapper.selectAll();

        return new PageInfo<Contract>(res).getList();
    }

    @Override
    public int getPageSize() {

        return contractMapper.selectAll().size() / 10 + 1;
    }
}
