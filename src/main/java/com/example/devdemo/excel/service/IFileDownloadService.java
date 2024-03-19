/**
 * @projectName devDemo
 * @package com.example.devdemo.excel.service
 * @className com.example.devdemo.excel.service.IFileDownloadService
 * @copyright Copyright 2024 Thunisoft, Inc All rights reserved.
 */
package com.example.devdemo.excel.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * IFileDownloadService
 * @description 文件下载接口
 * @author Administrator
 * @date 2024/3/12 9:23
 * @version TODO
 */
public interface IFileDownloadService {

    void excelTemplateExport(HttpServletRequest request, HttpServletResponse response) throws IOException;
}