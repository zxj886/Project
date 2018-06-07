package com.zx.service;

import com.zx.bean.Student;
import com.zx.dao.StudentDao;

import java.io.Serializable;
import java.util.List;

public class StudentServiceImp implements StudentService {
    //实例化dao对象交给Spring容器
    private StudentDao dao;

  public StudentDao getDao(){
      return  dao;
  }


    public void setDao(com.zx.dao.StudentDao dao) {
        this.dao = dao;
    }
    public void add(Student student) {

         dao.add(student);
    }

//    public int add(Student student) {
//
//        return dao.add(student);
//    }

    public int del(Serializable id) {
        return dao.del(id);
    }

    public int update(Student student) {
        return dao.update(student);
    }

    public List<Student> selectAll() {
        return dao.selectAll();
    }

}
