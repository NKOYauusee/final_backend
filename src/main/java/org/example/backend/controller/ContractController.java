package org.example.backend.controller;


import jakarta.annotation.Resource;
import org.example.backend.annotation.FucLogger;
import org.example.backend.entity.po.Contract;
import org.example.backend.entity.vo.ResponseVo;
import org.example.backend.service.ContractService;
import org.springframework.data.util.Pair;
import org.springframework.web.bind.annotation.*;

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
        return resSuccess("添加成功", null);
    }

    @FucLogger("批量添加合同")
    @RequestMapping("/add_batch")
    public ResponseVo batchInsert(@RequestBody List<Integer> retailer_ids) {
        contractService.batchInsert(0, retailer_ids);
        return resSuccess("添加成功", null);
    }


    @FucLogger("删除合同")
    @RequestMapping("/delete")
    public ResponseVo delete(@RequestBody Contract contract) {
        contractService.delete(contract);
        return resSuccess("删除成功", null);
    }

    @FucLogger("修改合同")
    @RequestMapping("/update")
    public ResponseVo update(@RequestBody Contract contract) {
        contractService.update(contract);
        return resSuccess("修改成功", null);
    }

    @FucLogger("查询所有合同")
    @RequestMapping("/all")
    public ResponseVo insert(@RequestParam("page") int page) {
        List<Contract> res = contractService.selectAll(page);
        return resSuccess("查询成功", res);
    }

    @FucLogger("查询合同总页数")
    @RequestMapping("/getPage")
    public ResponseVo getPage() {
        return resSuccess("查询合同总页数成功", contractService.getPageSize());
    }
}
