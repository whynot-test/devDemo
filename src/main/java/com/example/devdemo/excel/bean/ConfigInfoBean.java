package com.example.devdemo.excel.bean;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author: bi
 * @createTime: 2024年03月11日 16:45:08
 * @version: 1.0
 * @Description: 配置信息实体
 */
@Getter
@Setter
@AllArgsConstructor
@Builder
public class ConfigInfoBean {

    /**
     * 主键编号
     */
    private String cBh;
    /**
     * 系统编号
     */
    private String cBhSystem;
    /**
     *系统名称
     */
    private  String cMcSystem;
    /**
     * 子系统编号
     */
    private String cXtbh;
    /**
     * 子系统名称
     */
    private  String cMcApp;
    /**
     * 分组编号
     */
    private String cFzbh;
    /**
     * 分组名称
     */
    private String cFzmc;
    /**
     * 配置名称
     */
    private String cMc;
    /**
     * 配置关键字
     */
    private String cKey;
    /**
     * 默认值
     */
    private String cMrz;
    /**
     * 单值/多值代码，翻译名称
     */
    private String cMrzMc;
    /**
     * 配置信息分组共享范围
     */
    private String cGroupScope;
    /**
     * 说明
     */
    private String cSm;
    /**
     * 是否可维护，数字，1是2否
     */
    private Integer nWh;
    /**
     * 是否有效，数字，1是2否
     */
    private Integer nYx;
    /**
     * 显示类型，数字，0字符串、1是否、2单值代码、3多值代码
     */
    private Integer nXslx;
    /**
     * 修改时间
     */
    private Timestamp dXgsj;
    /**
     * 分组内显示顺序
     */
    private Integer nXssx;
    /**
     * 范围，global：全局、system：系统、app：子系统
     */
    private String cScope;
    /**
     * 涉及系统
     */
    private String cSjxt;
    /**
     * 原始需求
     */
    private String cXq;
    /**
     * 功能影响
     */
    private String cGnyx;
    /**
     * 配置代码
     */
    private String cPzdm;
    /**
     * 提出地区
     */
    private String cDq;

    /**
     * 提出地区
     */
    private String cParent;

}