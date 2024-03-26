package com.example.devdemo.ehcache.controller;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.devdemo.ehcache.service.PersonService;

/**
 * @Author: bi
 * @createTime: 2024年03月20日 11:31:31
 * @version: 1.0
 * @Description: Ehcache缓存控制类
 */
@Controller
@RequestMapping(value = "/api/ehcache")
public class EhcacheController {

    private static final Logger log = LoggerFactory.getLogger(EhcacheController.class);

    @Autowired
    private PersonService personService;

    @RequestMapping(value = "/person")
    public void getPersonCache(@RequestParam("id") String id){
        log.info("换取id为{}的缓存：",id);
        personService.getPerson(id);
        log.info("获取结束");
    }
}