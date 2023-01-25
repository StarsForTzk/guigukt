package org.stars.lin.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;
import org.stars.entity.model.vod.Subject;
import org.stars.lin.result.Result;
import org.stars.lin.service.SubjectService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * <p>
 * 课程科目 前端控制器
 * </p>
 *
 * @author stars
 * @since 2023-01-23
 */
@RestController
@RequestMapping("/vod/subject")
@CrossOrigin
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    //懒加载,只查询一层数据
    @GetMapping("getChildrenSubject/{id}")
    public Result getChildrenSubject(@PathVariable Long id) {
        List<Subject> list = subjectService.selectSubjectList(id);
        return Result.ok(list);
    }

    @GetMapping("exportExcel")
    public void export(HttpServletResponse response) {
        subjectService.export(response);
    }

    @GetMapping("import")
    public Result importData(MultipartFile file) {
        subjectService.importData(file);
        return Result.ok();
    }
}

