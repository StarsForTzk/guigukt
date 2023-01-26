package org.stars.lin.controller;


import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.stars.lin.result.Result;
import org.stars.lin.service.VideoVisitorService;

import java.util.Map;

/**
 * <p>
 * 视频来访者记录表 前端控制器
 * </p>
 *
 * @author stars
 * @since 2023-01-26
 */
@RestController
@RequestMapping("/vod/video-visitor")
public class VideoVisitorController {

    @Autowired
    private VideoVisitorService videoVisitorService;

    @GetMapping("findCount/{courseId}/{startDate}/{endDate}")
    public Result showChart(@PathVariable Long courseId,
                            @PathVariable String startDate,
                            @PathVariable String endDate) {

        Map<String, Object> map = videoVisitorService.findCount(courseId, startDate, endDate);
        return Result.ok(map);
    }
}

