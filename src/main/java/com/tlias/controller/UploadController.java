package com.tlias.controller;

import com.tlias.pojo.Result;
import com.tlias.utils.AliyunOSSUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
@RequestMapping("/upload")
public class UploadController {
    @Autowired
    private AliyunOSSUtils aliyunOSSUtils;


    /**
     * 文件保存在本地
     * @param username
     * @param age
     * @param file
     * @return
     * @throws Exception
     */
    // @PostMapping("/local")
    // public Result upload(String username, Integer age, MultipartFile file) throws Exception {
    //     log.info("文件上传，用户名：{}, 年龄：{}, 文件：{}", username, age, file);
    //     //获取文件名
    //     String originalFilename = file.getOriginalFilename();
    //     //获取文件后缀名
    //     String substring = originalFilename.substring(originalFilename.lastIndexOf("."));
    //     //文件保存到本地
    //     file.transferTo(new File("/Users/apple/Desktop/" + UUID.randomUUID().toString() + substring));
    //     return Result.success();
    // }

    /**
     * 文件保存到alioss
     * @param file
     * @return
     * @throws Exception
     */
    @PostMapping
    public Result upload(MultipartFile file) throws Exception {
        log.info("文件上传，用户名：{}, 年龄：{}, 文件：{}", file);
        //获取文件名
        String originalFilename = file.getOriginalFilename();
        //获取文件后缀名
        String substring = originalFilename.substring(originalFilename.lastIndexOf("."));
        //文件保存到alioss
        String url = aliyunOSSUtils.upload(file.getBytes(), substring);
        return Result.success(url);
    }


}
