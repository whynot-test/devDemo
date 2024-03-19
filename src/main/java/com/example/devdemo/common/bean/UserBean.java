package com.example.devdemo.common.bean;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @Author: bi
 * @createTime: 2024年03月12日 23:31:02
 * @version: 1.0
 * @Description:
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private String name;

    private String address;

    private int age;
}