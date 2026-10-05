package com.itheima.controller;

import com.itheima.pojo.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
public class UploadController {

    @PostMapping("/upload")
    public Result upload(MultipartFile file) throws IOException {
        // ① MultipartFile:Spring 把表单里的文件封装成这个对象,参数名 file 和表单字段名对应

        // ② 原始文件名可能重名(张三和李四都传 avatar.png 会互相覆盖),
        //    所以用 UUID 改名,但保留扩展名
        String originalFilename = file.getOriginalFilename();          // 头像.png
        String extName = originalFilename.substring(originalFilename.lastIndexOf("."));  // .png
        String newFileName = UUID.randomUUID().toString() + extName;   // 3f8a...c2.png

        // ③ transferTo:把文件从请求里"搬"到磁盘上(目录我已经帮你建好 F:/upload)
        file.transferTo(new File("F:/upload/" + newFileName));

        return Result.success(newFileName);   // 返回新文件名,前端拿它去填 emp.image
    }
}
