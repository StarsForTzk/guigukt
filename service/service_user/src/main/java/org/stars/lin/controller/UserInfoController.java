package org.stars.lin.controller;


import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.stars.entity.model.user.UserInfo;
import org.stars.lin.service.UserInfoService;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author stars
 * @since 2023-01-26
 */
@RestController
@RequestMapping("/user/user-info")
public class UserInfoController {

    @Autowired
    private UserInfoService userService;

    @GetMapping("inner/getById/{id}")
    public UserInfo getById(@PathVariable Long id) {
        return userService.getById(id);
    }
}

