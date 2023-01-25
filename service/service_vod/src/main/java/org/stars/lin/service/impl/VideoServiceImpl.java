package org.stars.lin.service.impl;

import org.stars.entity.model.vod.Video;
import org.stars.lin.mapper.VideoMapper;
import org.stars.lin.service.VideoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 课程视频 服务实现类
 * </p>
 *
 * @author stars
 * @since 2023-01-24
 */
@Service
public class VideoServiceImpl extends ServiceImpl<VideoMapper, Video> implements VideoService {

}
