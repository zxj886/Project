package com.zx.dao;

import com.zx.bean.Student;
import com.zx.util.SessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class StudentDaoImp implements StudentDao {

    @Override
    public void addStudent(Student student) {
        SqlSession session=null;
        try{
            session= SessionFactoryUtil.getSession();
            session.insert("addStudent",student);
            //提交事务
            session.commit();
        }catch (Exception e){

            e.printStackTrace();

        }finally {

            //务必要关闭session

            session.close();

        }



    }

    @Override
    public void addStudentByCache(Student student) {
        SqlSession session=null;
        try{
            session= SessionFactoryUtil.getSession();
            session.insert("addStudentByCache",student);
            //提交事务
            session.commit();
        }catch (Exception e){

            e.printStackTrace();

        }finally {

            //务必要关闭session

            session.close();

        }


    }

    @Override
    public void deleteStudent(Serializable id) {
        SqlSession session=null;
        try{
            session= SessionFactoryUtil.getSession();
            session.delete("deleteStudent",id);
            //提交事务

            session.commit();
        }catch (Exception e){

            e.printStackTrace();

        }finally {

            //务必要关闭session

            session.close();

        }
    }

    @Override
    public void updateStudent(Student student) {
        SqlSession session=null;
        try{
            session= SessionFactoryUtil.getSession();
            session.update("updateStudent",student);
            //提交事务

            session.commit();
        }catch (Exception e){

            e.printStackTrace();

        }finally {

            //务必要关闭session

            session.close();

        }
    }

    /*
    查询所有学生
     */
    @Override
    public List<Student> SelectAllStudent() {
        SqlSession session=null;
        List<Student> student=null;
        try{
            session= SessionFactoryUtil.getSession();
      student=session.selectList("SelectAllStudent");

            //提交事务

            session.commit();
        }catch (Exception e){

            e.printStackTrace();

        }finally {

            //务必要关闭session

            session.close();

        }
        return student;
    }
    /*
     查询所有返回Map集合
      */
    @Override
    public Map<String, Object> selectAllStudents() {
        SqlSession session=null;
        Map<String,Object> students=null;
        try{

            session=SessionFactoryUtil.getSession();
            students=session.selectMap("selectAllStudents","name");
        }catch (Exception e){

            e.printStackTrace();

        }finally {

            //务必要关闭session

            session.close();

        }
      return students;
  }
/*
根据id查询指定信息
 */
    @Override
    public Student findById(Serializable id) {
        SqlSession session=null;
        Student student=null;
        try{
            session= SessionFactoryUtil.getSession();
            student=session.selectOne("findById",id );
            //提交事务

            session.commit();
        }catch (Exception e){

            e.printStackTrace();

        }finally {

            //务必要关闭session

            session.close();

        }
        return student;
    }

    @Override
    public List<Student> selectByName(String name) {
        SqlSession session=null;
      List<Student> student=null;
        try{
            session= SessionFactoryUtil.getSession();
            student=session.selectList("selectByName",name);
            //提交事务

            session.commit();
        }catch (Exception e){

            e.printStackTrace();

        }finally {

            //务必要关闭session

            session.close();

        }
        return student;
    }
}
