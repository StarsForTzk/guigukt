package org.stars.lin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.stars.entity.model.vod.Chapter;
import org.stars.entity.vo.vod.ChapterVo;

import java.util.List;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author stars
 * @since 2023-01-24
 */
public interface ChapterService extends IService<Chapter> {

    List<ChapterVo> getTreeList(Long courseId);

    void removeChapterByCourseId(Long id);
}
