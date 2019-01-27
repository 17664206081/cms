package com.fzy.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @program: FileUploadService
 * @description:
 * @author: fzy
 * @date: 2019-01-27 13:30
 **/
public interface FileUploadService {

    void fileUpload(MultipartFile file) throws Exception;
}
