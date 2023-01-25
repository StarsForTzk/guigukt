package org.stars.lin.controller;

import org.springframework.web.bind.annotation.*;
import org.stars.lin.result.Result;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin  //跨域
@RestController
@RequestMapping("/admin/vod/user")
public class UserLoginController {

    @PostMapping("login")
    public Result login() {
        Map<String, Object> map = new HashMap<>();
        map.put("token","admin-token");
        return Result.ok(map).code(20000);
    }

    @GetMapping("info")
    public Result info() {
        Map<String, Object> map = new HashMap<>();
        map.put("roles","[admin]");
        map.put("name","stars");
        map.put("avatar","https://oss.aliyuncs.com/aliyun_id_photo_bucket/default_handsome.jpg");
        return Result.ok(map).code(20000);
    }
}
