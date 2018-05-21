package com.zx;
import com.zx.bean.Student;
import com.zx.dao.StudentDao;
import com.zx.util.SessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;

import org.apache.log4j.Logger;

import org.junit.After;

import org.junit.Before;

import org.junit.Test;



public class TeacherTest {



    StudentDao dao=null;

    SqlSession session=null;

    Logger log=Logger.getLogger(TeacherTest.class);



    /**

     * 在所有的test测试方法执行之前 都要执行的操作

     */

    @Before

    public void before(){

        //获取session

        session= SessionFactoryUtil.getSession();

        dao=session.getMapper(StudentDao.class); //获取执行的类对象

    }



    @After

    public  void after(){

        if (session!=null){

            session.close();

        }

    }





    /**

     * mybatis的二级缓存的配置：

     * 01.引入jar包  和  ehcache.xml文件

     * 02.在ehcache.xml文件去书写对应的配置

     * 03.需要缓存的类 需要实现序列化接口

     * 04. 在对应的mapper文件中设置  <cache/>

     */



    /**

     *


     步骤：

     01.当我们查询id=1的老师信息时

     02.先从一级缓存中查询，没有，之后 如果我们配置了2级缓存，就去2级缓存中查询！

     03.如果2级缓存也没有，就回去数据库中查询！  所以得到了

     [DEBUG] com.xdf.TeacherTest 46 第一次从数据库中获取数据===》Teacher{tid=1, tName='导师1'}

     04.第2次查询的时候先从一级缓存中查询，

     一级缓存中存在数据，直接使用！

     所以2级缓存的命中率是0.0！

     */

    @Test

    public  void  testSelectBySid(){

        Student student = dao.findById(1);

        log.debug("第一次从数据库中获取数据===》"+student);

        //再次查询id=1的老师信息

        student = dao.findById(1);

        log.debug("第二次从一级缓存中获取数据===》"+student);   // 只有一条sql语句产生

    }



    /**

     * 验证2级缓存配置成功

     */






    @Test

    public  void  testSelectBySid2(){

        Student student = dao.findById(1);

        log.debug("第一次从数据库中获取数据===》"+student);

        //关闭session    一级缓存中的数据被清空

        session.close();

        //再次获取session

        session=SessionFactoryUtil.getSession();

        dao=session.getMapper(StudentDao.class); //获取执行的类对象

        //再次查询id=1的老师信息

        student = dao.findById(1);

        log.debug("第二次从二级缓存中获取数据===》"+student);

        student = dao.findById(2);

        log.debug("第三次从二级缓存中获取数据===》"+student);

    }



    /**

     * 2级缓存的局部关闭

     *  在对应的mappper文件中的节点中  增加 useCache=false

     */

    @Test

    public  void  testSelectByClose(){

        Student student = dao.findById(1);

        log.debug("第一次从数据库中获取数据===》"+student);

        //关闭session    一级缓存中的数据被清空

        session.close();

        //再次获取session

        session=SessionFactoryUtil.getSession();

        dao=session.getMapper(StudentDao.class); //获取执行的类对象

        //再次查询id=1的老师信息

        student = dao.findById(1);

        log.debug("第二次从二级缓存中获取数据===》"+student);

    }
/*
新增设置flushCache="false" 对缓存没有影响
 */

    @Test

    public  void  addStudent(){

        Student student = dao.findById(1);

        log.debug("第一次从数据库中获取数据===》"+student);

        //关闭session    一级缓存中的数据被清空

        session.close();

        //再次获取session

        session=SessionFactoryUtil.getSession();

        dao=session.getMapper(StudentDao.class); //获取执行的类对象

        //再次查询id=1的老师信息

      dao.addStudent(new Student(20,"kk",80));//新增数据
         student=dao.findById(1);
        log.debug("第二次从二级缓存中获取数据===》"+student);

    }






    /**

     * 增删改  也是 清空 2级缓存！

     */

}