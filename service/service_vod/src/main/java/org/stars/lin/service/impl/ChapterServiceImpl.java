package org.stars.lin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.stars.entity.model.vod.Chapter;
import org.stars.entity.model.vod.Video;
import org.stars.entity.vo.vod.ChapterVo;
import org.stars.entity.vo.vod.VideoVo;
import org.stars.lin.mapper.ChapterMapper;
import org.stars.lin.service.ChapterService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.stars.lin.service.VideoService;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 课程 服务实现类
 * </p>
 *
 * @author stars
 * @since 2023-01-24
 */
@Service
public class ChapterServiceImpl extends ServiceImpl<ChapterMapper, Chapter> implements ChapterService {

    @Autowired
    private VideoService videoService;

    @Override
    public List<ChapterVo> getTreeList(Long courseId) {
        List<ChapterVo> finalChapterList = new ArrayList<>();
        QueryWrapper<Chapter> wrapper = new QueryWrapper<>();
        wrapper.eq("course_id",courseId);
        List<Chapter> chapterList = baseMapper.selectList(wrapper);
        LambdaQueryWrapper<Video> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Video::getCourseId,courseId);
        List<Video> videoList = videoService.list(lambdaQueryWrapper);
        for (Chapter chapter : chapterList) {
            ChapterVo chapterVo = new ChapterVo();
            BeanUtils.copyProperties(chapter,chapterVo);
            finalChapterList.add(chapterVo);

            List<VideoVo> videoVoList = new ArrayList<>();
            for (Video video : videoList) {
                if (chapter.getId().equals(video.getChapterId())) {
                    VideoVo videoVo = new VideoVo();
                    BeanUtils.copyProperties(video,videoVo);
                    videoVoList.add(videoVo);
                }
            }
            chapterVo.setChildren(videoVoList);
        }
        return finalChapterList;
    }
}
