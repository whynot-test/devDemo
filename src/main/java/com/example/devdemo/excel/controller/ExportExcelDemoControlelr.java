package com.example.devdemo.excel.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.devdemo.excel.service.ExportExcelService;


/**
 * @Author: bi
 * @createTime: 2024年03月11日 11:29:21
 * @version: 1.0
 * @Description:
 */
@Controller
@RequestMapping(value="/api/excel")
public class ExportExcelDemoControlelr {

    private static final Logger logger = LoggerFactory.getLogger(ExportExcelDemoControlelr.class);

    @Autowired
    private ExportExcelService exportExcelService;

    @GetMapping(value = "exportexcel")
    public void exportConfig2Excel(HttpServletResponse response) throws IOException {
        exportExcelService.exportConfigInfo2Excel(response);
    }
}