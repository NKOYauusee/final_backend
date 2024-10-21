package org.example.backend.controller.goods;

import jakarta.annotation.Resource;
import org.example.backend.annotation.FucLogger;
import org.example.backend.controller.BaseController;
import org.example.backend.entity.po.Fruit;
import org.example.backend.entity.vo.ResponseVo;
import org.example.backend.service.GoodsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/goods")
public class GoodsController extends BaseController {
    @Resource
    GoodsService goodsService;

    @FucLogger("查看商品，页数")
    @RequestMapping("/all")
    public ResponseVo selectAll(int page) {
        List<Fruit> res = goodsService.selectAll(page);
        return resFail("商品查询成功", res);
    }

    @FucLogger("修改商品")
    @RequestMapping("/update")
    public ResponseVo update(@RequestBody Fruit fruit) {
        goodsService.update(fruit);
        return resFail("修改成功", null);
    }

    @FucLogger("添加商品")
    @RequestMapping("/update")
    public ResponseVo insert(@RequestBody Fruit fruit) {
        goodsService.insert(fruit);
        return resFail("修改成功", null);
    }

    @FucLogger("删除商品")
    @RequestMapping("/update")
    public ResponseVo delete(@RequestBody Fruit fruit) {
        goodsService.delete(fruit);
        return resFail("修改成功", null);
    }
}
