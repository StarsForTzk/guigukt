package org.stars.lin.service.impl;

import org.stars.entity.model.vod.VideoVisitor;
import org.stars.entity.vo.vod.VideoVisitorCountVo;
import org.stars.entity.vo.vod.VideoVisitorVo;
import org.stars.lin.mapper.VideoVisitorMapper;
import org.stars.lin.service.VideoVisitorService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * <p>
 * 视频来访者记录表 服务实现类
 * </p>
 *
 * @author stars
 * @since 2023-01-26
 */
@Service
public class VideoVisitorServiceImpl extends ServiceImpl<VideoVisitorMapper, VideoVisitor> implements VideoVisitorService {

    @Override
    public Map<String, Object> findCount(Long courseId, String startDate, String endDate) {
        List<VideoVisitorCountVo> videoVisitorVoList = baseMapper.findCount(courseId, startDate, endDate);
        Map<String, Object> map = new HashMap<>();
        List<String> dateList = new ArrayList<>();
        List<Integer> countList = new ArrayList<>();
        dateList = videoVisitorVoList.stream().map(VideoVisitorCountVo::getJoinTime).collect(Collectors.toList());
        countList = videoVisitorVoList.stream().map(VideoVisitorCountVo::getUserCount).collect(Collectors.toList());

        map.put("xData", dateList);
        map.put("yData", countList);
        return map;
    }
}
