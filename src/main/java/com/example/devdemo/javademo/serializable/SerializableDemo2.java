package com.example.devdemo.javademo.serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.devdemo.common.bean.UserBean;
import com.example.devdemo.javademo.anoncation.Apple;

/**
 * @Author: bi
 * @createTime: 2024年03月12日 23:27:52
 * @version: 1.0
 * @Description: 序列化和反序列化
 */
public class SerializableDemo2 {
    private static final Logger logger = LoggerFactory.getLogger(SerializableDemo2.class);

    public static void main(String[] args) throws Exception {
        //序列化数据到磁盘
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("E:\\workspace\\15学习项目\\DevDemo\\devDemo\\src\\main\\resources\\write.out");
            ObjectOutputStream objectOutputStream = null;
            objectOutputStream = new ObjectOutputStream(fos);
            UserBean user = new UserBean();
            user.setName("张三");
            user.setAge(18);
            objectOutputStream.writeObject(user);
            objectOutputStream.flush();
            objectOutputStream.close();

            //反序列化磁盘数据并解析
            FileInputStream fileInputStream = new FileInputStream("E:\\workspace\\15学习项目\\DevDemo\\devDemo\\src\\main\\resources\\write.out");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            UserBean o = (UserBean)objectInputStream.readObject();
            System.out.println(o.getName());
        } catch (Exception e) {
            logger.error("出错");
        }


    }
}