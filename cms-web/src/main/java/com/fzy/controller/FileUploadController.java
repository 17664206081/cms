package com.fzy.controller;

import com.fzy.entity.vo.ResultVo;
import com.fzy.service.FileUploadService;
import com.fzy.utils.ResultVOUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @program: FileUploadController
 * @description: 文件上传
 * @author: fzy
 * @date: 2019-01-27 09:57
 **/
@RestController
@RequestMapping("/file")
@Api(tags = "文件上传")
@Slf4j
public class FileUploadController {

    @Autowired
    private FileUploadService fileUploadService;

    @PostMapping("/upload")
    @ApiOperation("批量导入")
    public ResultVo batchImport(@RequestParam MultipartFile file){
        try {
            fileUploadService.fileUpload(file);
            return ResultVOUtil.success();
        }catch (Exception e){
            log.error("文件上传失败 e{} msg{}",e,e.getMessage());
           return ResultVOUtil.error(600,"文件上传失败");
        }
    }

}
