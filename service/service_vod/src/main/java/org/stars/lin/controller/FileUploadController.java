package org.stars.lin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.stars.lin.result.Result;
import org.stars.lin.service.FileService;

/**
 * @author stars-lin
 * @description
 * @date 2023/1/23 18:19
 */

@RestController
@RequestMapping("/admin/vod/file")
public class FileUploadController {

    @Autowired
    private FileService fileService;

    @PostMapping("upload")
    public Result uploadFile(MultipartFile file) {
        String url = fileService.upload(file);
        return Result.ok(url).message("上传文件成功");
    }

}
