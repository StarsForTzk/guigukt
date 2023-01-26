package org.stars.lin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.stars.entity.model.activity.CouponInfo;
import org.stars.entity.model.activity.CouponUse;
import org.stars.entity.vo.activity.CouponUseQueryVo;

/**
 * <p>
 * 优惠券信息 服务类
 * </p>
 *
 * @author stars
 * @since 2023-01-26
 */
public interface CouponInfoService extends IService<CouponInfo> {

    IPage<CouponUse> selectCouponUsePage(Page<CouponUse> pageParam, CouponUseQueryVo couponUseQueryVo);

    void updateCouponInfoUseStatus(Long couponUseId, Long orderId);

}
