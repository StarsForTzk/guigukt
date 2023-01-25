package org.stars.lin.controller;


import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.stars.entity.model.vod.Video;
import org.stars.lin.result.Result;
import org.stars.lin.service.VideoService;

/**
 * <p>
 * 课程视频 前端控制器
 * </p>
 *
 * @author stars
 * @since 2023-01-24
 */
@RestController
@RequestMapping("/vod/video")
public class VideoController {

    @Autowired
    private VideoService videoService;

    @GetMapping("get/{id}")
    public Result get(@PathVariable Long id) {
        Video video = videoService.getById(id);
        return Result.ok(video);
    }

    @PostMapping("save")
    public Result save(@RequestBody Video video) {
        videoService.save(video);
        return Result.ok(null);
    }

    @PutMapping("update")
    public Result updateById(@RequestBody Video video) {
        videoService.updateById(video);
        return Result.ok(null);
    }

    @DeleteMapping("remove/{id}")
    public Result remove(@PathVariable Long id) {
        videoService.removeById(id);
        return Result.ok(null);
    }
}

