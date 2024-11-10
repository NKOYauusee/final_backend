package org.example.backend.controller.retailer;

import jakarta.annotation.Resource;
import org.example.backend.annotation.FucLogger;
import org.example.backend.controller.BaseController;
import org.example.backend.entity.po.Retailer;
import org.example.backend.entity.vo.ResponseVo;
import org.example.backend.service.RetailerService;
import org.springframework.web.bind.annotation.*;

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
    @RequestMapping("/update")
    public ResponseVo update(@RequestBody Retailer retailer) {
        retailerService.update(retailer);
        return resSuccess("修改成功", null);
    }

    @FucLogger("批量修改零售商")
    @RequestMapping("/batchUpdate")
    public ResponseVo batchUpdate(@RequestBody List<Retailer> retailer) {
        retailerService.batchUpdate(retailer);
        return resSuccess("批量修改成功", null);
    }


    @FucLogger("查询零售商")
    @RequestMapping("/all")
    public ResponseVo selectAll(@RequestParam(value = "goodsId", required = false) Integer id) {
        List<Retailer> res;
        if (id == null) {
            res = retailerService.selectHasSelected();
        } else {
            res = retailerService.selectAll(id);
        }

        return resSuccess("查询成功", res);
    }
}
