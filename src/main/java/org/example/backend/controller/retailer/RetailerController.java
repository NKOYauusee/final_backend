package org.example.backend.controller.retailer;

import jakarta.annotation.Resource;
import org.example.backend.annotation.FucLogger;
import org.example.backend.controller.BaseController;
import org.example.backend.entity.po.Retailer;
import org.example.backend.entity.vo.ResponseVo;
import org.example.backend.service.RetailerService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RequestMapping("/retailer")
@RestController
public class RetailerController extends BaseController {
    @Resource
    RetailerService retailerService;

    @RequestMapping("/add")
    public ResponseVo insert(@RequestBody Retailer retailer) {
        retailerService.insert(retailer);
        return resSuccess("添加成功", null);
    }

    @FucLogger("修改零售商")
    @RequestMapping("/add")
    public ResponseVo update(@RequestBody Retailer retailer) {
        retailerService.update(retailer);
        return resSuccess("修改成功", null);
    }

    @FucLogger("查询零售商")
    @RequestMapping("/all")
    public ResponseVo selectAll(int page) {
        List<Retailer> res = retailerService.selectAll(page);
        return resSuccess("查询成功", res);
    }
}
