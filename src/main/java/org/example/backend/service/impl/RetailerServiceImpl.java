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

@Service("RetailerServiceImpl")
public class RetailerServiceImpl implements RetailerService {
    @Resource
    RetailerMapper retailerMapper;


    @Override
    public void insert(Retailer retailer) {
        retailer.setCreate_time(new Date());
        retailerMapper.insert(retailer);
    }

    @Resource
    ContractService contractService;

    @Override
    public void update(Retailer retailer) {
        retailerMapper.update(retailer);
    }

    @Resource
    ContractMapper contractMapper;

    @Override
    public void batchUpdate(List<Retailer> retailer) {
        for (var r :
                retailer) {
            retailerMapper.update(r);

            if (r.getStatus() == 0) {
                Contract contract = new Contract();
                contract.setRetailer_id(r.getId());
                contract.setGoodsId(r.getGoodsId());

                contractService.delete(contract);
            } else if (r.getStatus() == 1) {

                Contract contract = new Contract();
                contract.setRetailer_id(r.getId());
                contract.setGoodsId(r.getGoodsId());
                // TODO 查重
                Contract c = contractMapper.selectByRetailAndGoodsId(contract);
                if (c == null) {
                    contractService.insert(contract);
                }

            }
        }
    }

    @Override
    public List<Retailer> selectAll(int id) {
        //PageHelper.startPage(page, 10);
        List<Retailer> res = retailerMapper.selectAll(id);
        //return new PageInfo<>(res).getList();

        return res;
    }

    @Override
    public List<Retailer> selectHasSelected() {
        return retailerMapper.selectHasSelected();
    }

    @Override
    public int getPageSize() {
        return retailerMapper.selectAll(0).size() / 10 + 1;
    }
}
