package com.example.devdemo.excel.service;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.stereotype.Service;

import com.example.devdemo.excel.bean.ConfigInfoBean;


/**
 * @Author:
 * @createTime: 2024年03月11日 11:34:12
 * @version:
 * @Description:
 */
@Service
public class ExportExcelService {

    private final static String[] FIXED_COLUMN_ARRAY = {"分组名称", "配置项key", "配置项名称", "可维护", "是否有效", "默认值"};


    /**
     * 导出配置信息
     * @param response
     * @throws IOException
     */
    public void exportConfigInfo2Excel(HttpServletResponse response) throws IOException {
        StringBuilder exportNameSb = new StringBuilder();
        exportNameSb.append("测试导出配置信息");
        exportNameSb.append(".xlsx");
        buildResponseStreamHeader(response, exportNameSb.toString());


        //创建sheet页
        SXSSFWorkbook workbook = new SXSSFWorkbook(1000);
        SXSSFSheet sheet = workbook.createSheet("配置值列表");
        sheet.setDefaultColumnWidth(25);
        sheet.protectSheet("12345678Aa");

        //创建excel的表头
        buildExcelHeader(workbook,sheet);

        //获去导出数据
        List<ConfigInfoBean> configInfoList = buildConfigInfo();
        //往excel 表中插入数据
        buildExcel(workbook,sheet,configInfoList);
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);

    }


    private void buildExcelHeader(SXSSFWorkbook sxssfWorkbook,SXSSFSheet sheet){
        //设置表头格式
        CellStyle headerStyle = setUpHeaderCellStyle(sxssfWorkbook);
        //创建表头行
        SXSSFRow headerRow = sheet.createRow(0);
        //创建冻结隔窗
        sheet.createFreezePane(0,1);
        //固定列数量
        int fixedColumnNum = FIXED_COLUMN_ARRAY.length;
        for (int i = 0; i < fixedColumnNum; i++) {
            headerRow.createCell(i).setCellValue(FIXED_COLUMN_ARRAY[i]);
            headerRow.getCell(i).setCellStyle(headerStyle);
        }

    }
    private void buildExcel(SXSSFWorkbook workbook, SXSSFSheet sheet, List<ConfigInfoBean> configInfoList){
        //非表头列样式
        CellStyle cellStyle = setUpCellStype(workbook);
        //固定列数
        int fixedColumnNum = FIXED_COLUMN_ARRAY.length;
        for (int i = 0; i < configInfoList.size(); i++) {
            ConfigInfoBean configInfoBean = configInfoList.get(i);
            SXSSFRow row = sheet.createRow(i + 1);
            row.createCell(0).setCellValue(configInfoBean.getCFzmc());
            row.createCell(1).setCellValue(configInfoBean.getCKey());
            row.createCell(2).setCellValue(configInfoBean.getCMc());
            row.createCell(3).setCellValue(configInfoBean.getNWh());
            row.createCell(4).setCellValue(configInfoBean.getNYx());
            sheet.setColumnWidth(3, 2000);
            sheet.setColumnWidth(4, 2000);
            row.createCell(5).setCellValue(configInfoBean.getCMrz());
        }
        
    }

    /**
     * 设置表头样式
     * @param workbook
     * @return
     */
    private CellStyle setUpHeaderCellStyle(SXSSFWorkbook workbook){
        //表头样式
        CellStyle headerStyle = workbook.createCellStyle();
        //设置颜色
        headerStyle.setFillBackgroundColor(HSSFColor.BLUE.index);
        headerStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

        //设置边框
        headerStyle.setBorderTop(CellStyle.BORDER_THIN);
        headerStyle.setBorderRight(CellStyle.BORDER_THIN);
        headerStyle.setBorderBottom(CellStyle.BORDER_THIN);
        headerStyle.setBorderLeft(CellStyle.BORDER_THIN);
        return headerStyle;
    }

    /**
     * 设置非表头列的样式
     * @param workbook
     * @return
     */
    private CellStyle setUpCellStype(SXSSFWorkbook workbook){
        //设置样式
        CellStyle cellStyle = workbook.createCellStyle();
        //设置边框
        cellStyle.setBorderTop(CellStyle.BORDER_THIN);
        cellStyle.setBorderRight(CellStyle.BORDER_THIN);
        cellStyle.setBorderBottom(CellStyle.BORDER_THIN);
        cellStyle.setBorderLeft(CellStyle.BORDER_THIN);
        return cellStyle;
    }

    /**
     * 构建导出数据：正常需要查询
     * @return
     */
    private List<ConfigInfoBean> buildConfigInfo (){
        List<ConfigInfoBean> configInfoList = new ArrayList<>();

        ConfigInfoBean config1 = ConfigInfoBean.builder().cFzmc("redis哨兵集群相关设置").cKey("sso.redis.mastername").cMc("单点登录redis主节点名称").nWh(1).nYx(1).cMrz("false").build();
        ConfigInfoBean config2 = ConfigInfoBean.builder().cFzmc("单点登录cocall相关设置").cKey("cmpt.sso.login.ssotype.cocallOrYy").cMc("是否开启CoCall验证方式").nWh(1).nYx(1).cMrz("true").build();
        configInfoList.add(config1);
        configInfoList.add(config2);
        return configInfoList;
    }

    /**
     * 设置编码、下载文件类型
     */
    public void buildResponseStreamHeader(HttpServletResponse response, String fileName) throws UnsupportedEncodingException {
        response.setStatus(200);
        response.setContentType("application/octet-stream");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
        response.setHeader("Access-Control-Expose-Headers", "Content-Disposition");
    }
}