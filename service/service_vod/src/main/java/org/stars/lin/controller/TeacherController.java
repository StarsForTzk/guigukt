package org.stars.lin.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.stars.entity.model.vod.Teacher;
import org.stars.lin.result.Result;
import org.stars.lin.service.TeacherService;
import org.stars.lin.vo.TeacherQueryVo;
import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author stars
 * @since 2022-12-03
 */
@RestController
@RequestMapping("/admin/vod/teacher")
@CrossOrigin
public class TeacherController {

    @Autowired
    private TeacherService teacherService;


    @GetMapping("/findAllTeacher")
    public Result findAllTeacher() {
        List<Teacher> list = teacherService.list();
        return Result.ok(list).message("查询所有讲师成功");
    }

    @DeleteMapping("/remove/{id}")
    public Result removeById(@PathVariable Long id) {
        boolean result = teacherService.removeById(id);
        if (result) {
            return Result.ok().message("删除讲师成功" + id);
        } else {
            return Result.fail();
        }
    }

    @PostMapping("findQueryPage/{nom}/{limit}")
    public Result findQueuePage(@PathVariable long nom,
                                @PathVariable long limit,
                                @RequestBody(required = false) TeacherQueryVo teacherQueryVo) {
        Page<Teacher> page = new Page<>(nom, limit);

        if (teacherQueryVo == null) {
            IPage<Teacher> pageModel = teacherService.page(page, null);
            return Result.ok(pageModel).message("分页查询条件为空,即为查询全部");
        } else {
            String name = teacherQueryVo.getName();
            Integer level = teacherQueryVo.getLevel();
            String joinDateBegin = teacherQueryVo.getJoinDateBegin();
            String joinDateEnd = teacherQueryVo.getJoinDateEnd();
            QueryWrapper<Teacher> wrapper = new QueryWrapper<>();

            if (!StringUtils.isEmpty(name)) {
                wrapper.like("name", name);
            }
            if (!StringUtils.isEmpty(level)) {
                wrapper.eq("level", level);
            }
            if (!StringUtils.isEmpty(joinDateBegin)) {
                wrapper.ge("join_date", joinDateBegin);
            }
            if (!StringUtils.isEmpty(joinDateEnd)) {
                wrapper.le("join_date", joinDateEnd);
            }

            IPage<Teacher> pageModel = teacherService.page(page, wrapper);
            return Result.ok(pageModel).code(20000);
        }
    }


    @PostMapping("saveTeacher")
    public Result saveTeacher(@RequestBody Teacher teacher) {
        boolean result = teacherService.save(teacher);
        if (result) {
            return Result.ok().message("添加讲师成功");
        } else {
            return Result.fail().message("添加讲师失败");
        }
    }

    @GetMapping("getTeacher/{id}")
    public Result getTeacherById(@PathVariable Long id) {
        Teacher teacher = teacherService.getById(id);
        return Result.ok(teacher);
    }

    @PostMapping("updateTeacher")
    public Result updateTeacher(@RequestBody Teacher teacher) {
        boolean result = teacherService.updateById(teacher);
        if (result == false) {
            return Result.fail().message("修改失败");
        } else {
            return Result.ok(result).message("修改成功");
        }
    }

    @DeleteMapping("removeBatch")
    public Result removeBatch(@RequestBody List<Long> idList) {
        boolean result = teacherService.removeByIds(idList);
        if (result) {
            return Result.ok().message("批量删除成功");
        } else {
            return Result.fail().message("批量删除失败");
        }
    }


}

