package org.example.backend.controller;


import jakarta.annotation.Resource;
import org.example.backend.annotation.FucLogger;
import org.example.backend.entity.po.Contract;
import org.example.backend.entity.vo.ResponseVo;
import org.example.backend.service.ContractService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RequestMapping("/contract")
@RestController
public class ContractController extends BaseController {

    @Resource
    ContractService contractService;

    @FucLogger("添加合同")
    @RequestMapping("/add")
    public ResponseVo insert(@RequestBody Contract contract) {
        contractService.insert(contract);
        return resSuccess("添加成功",null );
    }


    @FucLogger("删除合同")
    @RequestMapping("/delete")
    public ResponseVo delete(@RequestBody Contract contract) {
        contractService.delete(contract);
        return resSuccess("删除成功",null );
    }

    @FucLogger("修改合同")
    @RequestMapping("/update")
    public ResponseVo update(@RequestBody Contract contract) {
        contractService.update(contract);
        return resSuccess("添加成功",null );
    }

    @FucLogger("查询所有合同")
    @RequestMapping("/all")
    public ResponseVo insert(int page) {
        List<Contract> res = contractService.selectAll(page);
        return resSuccess("查询成功",res );
    }
}
