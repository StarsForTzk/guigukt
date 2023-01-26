package org.stars.lin.service;

import java.io.InputStream;

public interface VodService {

    //上传视频
    String uploadVideo(InputStream inputStream, String originalFilename);
    //删除视频
    void removeVideo(String videoSourceId);
}
