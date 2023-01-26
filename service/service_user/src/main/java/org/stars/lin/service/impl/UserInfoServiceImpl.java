package org.stars.lin.service.impl;

import org.stars.entity.model.user.UserInfo;
import org.stars.lin.mapper.UserInfoMapper;
import org.stars.lin.service.UserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author stars
 * @since 2023-01-26
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {

}
