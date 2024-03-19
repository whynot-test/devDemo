package com.example.devdemo.excel.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.devdemo.excel.service.FileDownloadService;

/**
 * @Author: bi
 * @createTime: 2024年03月12日 09:20:53
 * @version: 1.0
 * @Description: 用于文件下载的测试类
 *
 */
@Controller
@RequestMapping(value="/api/file")
public class FileDownloadController {

    @Autowired
    private FileDownloadService downloadService;


    @RequestMapping(value = "doenloadtemp")
    public void excelTemplateExport(HttpServletRequest request, HttpServletResponse response) throws IOException {
        downloadService.excelTemplateExport(request,response);
    }
}