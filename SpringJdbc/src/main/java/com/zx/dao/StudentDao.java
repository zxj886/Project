package com.zx.dao;

import com.zx.bean.Student;

import java.io.Serializable;
import java.util.List;

public interface StudentDao {
   // int add(Student student);//添加学生
  void add(Student student);//添加学生
    int del(Serializable id);//删除学生
    int update(Student  student);//修改
    List<Student> selectAll();//查询多有
}
