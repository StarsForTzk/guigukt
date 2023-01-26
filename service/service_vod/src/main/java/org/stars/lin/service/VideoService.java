package org.stars.lin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.stars.entity.model.vod.Video;

/**
 * <p>
 * 课程视频 服务类
 * </p>
 *
 * @author stars
 * @since 2023-01-24
 */
public interface VideoService extends IService<Video> {

    void removeVideoByCourseId(Long id);
}
