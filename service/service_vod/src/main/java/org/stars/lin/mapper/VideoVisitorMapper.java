package org.stars.lin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.stars.entity.model.vod.VideoVisitor;
import org.stars.entity.vo.vod.VideoVisitorCountVo;
import org.stars.entity.vo.vod.VideoVisitorVo;

import java.util.List;

/**
 * <p>
 * 视频来访者记录表 Mapper 接口
 * </p>
 *
 * @author stars
 * @since 2023-01-26
 */
public interface VideoVisitorMapper extends BaseMapper<VideoVisitor> {

    List<VideoVisitorCountVo> findCount(Long courseId, String startDate, String endDate);
}
