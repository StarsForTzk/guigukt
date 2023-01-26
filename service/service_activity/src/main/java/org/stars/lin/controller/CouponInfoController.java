package org.stars.lin.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.stars.entity.model.activity.CouponInfo;
import org.stars.entity.model.activity.CouponUse;
import org.stars.entity.vo.activity.CouponUseQueryVo;
import org.stars.lin.result.Result;
import org.stars.lin.service.CouponInfoService;

import java.util.List;

/**
 * <p>
 * 优惠券信息 前端控制器
 * </p>
 *
 * @author stars
 * @since 2023-01-26
 */
@RestController
@RequestMapping("/activity/coupon-info")
public class CouponInfoController {
    @Autowired
    private CouponInfoService couponInfoService;

    @GetMapping("{page}/{limit}")
    public Result index(
            @PathVariable Long page,
            @PathVariable Long limit) {
        Page<CouponInfo> pageParam = new Page<>(page, limit);
        IPage<CouponInfo> pageModel = couponInfoService.page(pageParam);
        return Result.ok(pageModel);
    }

    @GetMapping("get/{id}")
    public Result get(@PathVariable String id) {
        CouponInfo couponInfo = couponInfoService.getById(id);
        return Result.ok(couponInfo);
    }

    @PostMapping("save")
    public Result save(@RequestBody CouponInfo couponInfo) {
        couponInfoService.save(couponInfo);
        return Result.ok();
    }

    @ApiOperation(value = "修改优惠券")
    @PutMapping("update")
    public Result updateById(@RequestBody CouponInfo couponInfo) {
        couponInfoService.updateById(couponInfo);
        return Result.ok();
    }

    @DeleteMapping("remove/{id}")
    public Result remove(@PathVariable String id) {
        couponInfoService.removeById(id);
        return Result.ok();
    }

    @DeleteMapping("batchRemove")
    public Result batchRemove(@RequestBody List<String> idList){
        couponInfoService.removeByIds(idList);
        return Result.ok();
    }

    @GetMapping("couponUse/{page}/{limit}")
    public Result index(
            @PathVariable Long page,

            @PathVariable Long limit,
                    CouponUseQueryVo couponUseQueryVo) {
        Page<CouponUse> pageParam = new Page<>(page, limit);
        IPage<CouponUse> pageModel = couponInfoService.selectCouponUsePage(pageParam, couponUseQueryVo);
        return Result.ok(pageModel);
    }
}

