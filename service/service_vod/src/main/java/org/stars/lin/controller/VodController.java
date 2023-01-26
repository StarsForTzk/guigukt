package org.stars.lin.controller;

import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.stars.lin.result.Result;
import org.stars.lin.service.VodService;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author stars-lin
 * @description
 * @date 2023/1/26 15:53
 */

@RestController
@RequestMapping("/admin/vod/vod")
@CrossOrigin
public class VodController {

    @Autowired
    private VodService vodService;

    //上传视频
    @PostMapping("upload")
    public Result uploadVideo(
            @RequestParam("file") MultipartFile file) throws IOException {
        InputStream inputStream = file.getInputStream();
        String originalFilename = file.getOriginalFilename();
        String videoId = vodService.uploadVideo(inputStream, originalFilename);
        return Result.ok(videoId);
    }

    //删除视频
    @DeleteMapping("remove/{videoSourceId}")
    public Result removeVideo(@PathVariable String videoSourceId) {
        vodService.removeVideo(videoSourceId);
        return Result.ok();
    }
}
