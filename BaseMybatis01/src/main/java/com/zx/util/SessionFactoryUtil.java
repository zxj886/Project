package com.zx.util;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SessionFactoryUtil {

    //01.创建需要单例的对象实例

    private  static SqlSessionFactory sessionFactory;



    //02.私有化构造

    private SessionFactoryUtil(){}





    public   static  synchronized SqlSession getSession(){

        //给我一个文件 返回一个输入流 到 内存中

        try {

            InputStream stream = Resources.getResourceAsStream("mybatis.xml");

            //判断SqlSessionFactory是否为空

            if (sessionFactory==null){

                sessionFactory=new SqlSessionFactoryBuilder().build(stream);

            }

        } catch (IOException e) {

            e.printStackTrace();

        }


        return  sessionFactory.openSession();  //创建session返回

    }



}