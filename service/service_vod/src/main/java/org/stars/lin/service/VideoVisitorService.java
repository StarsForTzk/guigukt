package org.stars.lin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.stars.entity.model.vod.VideoVisitor;

import java.util.Map;

/**
 * <p>
 * 视频来访者记录表 服务类
 * </p>
 *
 * @author stars
 * @since 2023-01-26
 */
public interface VideoVisitorService extends IService<VideoVisitor> {

    Map<String, Object> findCount(Long courseId, String startDate, String endDate);
}
