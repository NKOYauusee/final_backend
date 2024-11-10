package org.example.backend.controller.goods;

import jakarta.annotation.Resource;
import org.example.backend.annotation.FucLogger;
import org.example.backend.controller.BaseController;
import org.example.backend.entity.po.Fruit;
import org.example.backend.entity.vo.ResponseVo;
import org.example.backend.service.GoodsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/goods")
public class GoodsController extends BaseController {
    @Resource
    GoodsService goodsService;

    @FucLogger("查看商品，页数")
    @RequestMapping("/all")
    public ResponseVo selectAll(@RequestParam("page") int page) {
        List<Fruit> res = goodsService.selectAll(page);

        return resSuccess("商品查询成功", res);
    }

    @FucLogger("查看商品总页数")
    @RequestMapping("/getPage")
    public ResponseVo getPage() {
        int page = goodsService.getPageSize();
        return resSuccess("商品页数查询成功", page);
    }

    @FucLogger("修改商品")
    @RequestMapping("/update")
    public ResponseVo update(@RequestBody Fruit fruit) {
        goodsService.update(fruit);
        return resSuccess("修改成功", null);
    }

    @FucLogger("添加商品")
    @RequestMapping("/insert")
    public ResponseVo insert(@RequestBody Fruit fruit) {
        goodsService.insert(fruit);
        return resSuccess("修改成功", null);
    }

    @FucLogger("删除商品")
    @RequestMapping("/delete")
    public ResponseVo delete(@RequestBody Fruit fruit) {
        goodsService.delete(fruit);
        return resSuccess("修改成功", null);
    }
}
