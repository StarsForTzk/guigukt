package org.stars.lin.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.stars.entity.model.order.OrderInfo;
import org.stars.entity.vo.order.OrderInfoQueryVo;
import org.stars.lin.result.Result;
import org.stars.lin.service.OrderInfoService;

import java.util.Map;

/**
 * <p>
 * 订单表 订单表 前端控制器
 * </p>
 *
 * @author stars
 * @since 2023-01-26
 */
@RestController
@RequestMapping("/lin/order-info")
public class OrderInfoController {

    @Autowired
    private OrderInfoService orderInfoService;

    @GetMapping("{page}/{limit}")
    public Result index(
            @PathVariable Long page,
            @PathVariable Long limit,
                    OrderInfoQueryVo orderInfoQueryVo) {
        Page<OrderInfo> pageParam = new Page<>(page, limit);
        Map<String,Object> map = orderInfoService.findPageOrderInfo(pageParam, orderInfoQueryVo);
        return Result.ok(map);
    }
}

