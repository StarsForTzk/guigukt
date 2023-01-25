package org.stars.lin.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.stars.entity.model.vod.Chapter;
import org.stars.entity.vo.vod.ChapterVo;
import org.stars.lin.result.Result;
import org.stars.lin.service.ChapterService;

import java.util.List;

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author stars
 * @since 2023-01-24
 */
@RestController
@RequestMapping("/vod/chapter")
@CrossOrigin
public class ChapterController {

    @Autowired
    private ChapterService chapterService;

    @GetMapping("getNestedTreeList/{courseId}")
    public Result getTreeList(@PathVariable Long courseId) {
        List<ChapterVo> list = chapterService.getTreeList(courseId);
        return Result.ok(list);
    }

    @PostMapping("save")
    public Result save(@RequestBody Chapter chapter) {
        chapterService.save(chapter);
        return Result.ok();
    }

    @GetMapping("get/{id}")
    public Result getById(@PathVariable Long id) {
        Chapter chapter = chapterService.getById(id);
        return Result.ok(chapter);
    }

    @PostMapping("update")
    public Result update(@RequestBody Chapter chapter) {
        chapterService.updateById(chapter);
        return Result.ok();
    }

    @DeleteMapping("remove/{id}")
    public Result removeById(@PathVariable Long id) {
        chapterService.removeById(id);
        return Result.ok();
    }


}

