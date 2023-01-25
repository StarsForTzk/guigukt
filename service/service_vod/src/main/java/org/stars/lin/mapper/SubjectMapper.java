package org.stars.lin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.stars.entity.model.vod.Subject;

/**
 * <p>
 * 课程科目 Mapper 接口
 * </p>
 *
 * @author stars
 * @since 2023-01-23
 */
@Repository
public interface SubjectMapper extends BaseMapper<Subject> {

}
