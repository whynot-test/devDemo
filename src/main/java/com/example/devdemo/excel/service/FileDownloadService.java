package com.example.devdemo.excel.service;

/**
 * @Author: bi
 * @createTime: 2024年03月12日 09:22:32
 * @version: 1.0
 * @Description:
 */

/**
 *
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

@Service
public class FileDownloadService implements IFileDownloadService{

    private static Logger logger = LoggerFactory.getLogger(FileDownloadService.class);

    private static final String TEMP_EXCEL_PATH = "/templatefiles/organExcel.xlsx";

    /**
     * excel文件模板下载
     * @param request
     * @param response
     */
    @Override
    public void excelTemplateExport(HttpServletRequest request, HttpServletResponse response) throws IOException {
        logger.info("导出excel模板开始");
        OutputStream out = null;
        response.reset();
        String fileName = "UIM组织机构模板";

        //设置导出excel的名称
        ClassPathResource classPathResource = new ClassPathResource(TEMP_EXCEL_PATH);
        InputStream inputStream = classPathResource.getInputStream();
        //创建工作簿
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        response.setHeader("Content-Disposition", "attachment; filename=" + fileName + ".xlsx");
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
    }

    private String encodeFileName(HttpServletRequest request,String filename) throws UnsupportedEncodingException {
        String userAgent = request.getHeader("USER-AGENT").toLowerCase();
        //设置编码格式
        if(userAgent.contains("mise") || userAgent.contains("like gecko")){
            filename = URLEncoder.encode(filename,"UTF-8");
        }else {
            filename = new String(filename.getBytes("UTF-8"),"ISO8859-1");
        }
        return filename;
    }
}