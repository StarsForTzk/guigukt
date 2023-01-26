package org.stars.lin.user;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.stars.entity.model.user.UserInfo;

@FeignClient(value = "service-user")
@Repository
public interface UserInfoFeignClient {

    @GetMapping("/admin/user/userInfo/inner/getById/{id}")
    public UserInfo getById(@PathVariable Long id);
}
