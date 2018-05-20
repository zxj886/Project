package com.zx.dao;

import com.zx.bean.Student;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface StudentDao {
    /**
     * 新增
     * @param student
     */
    void addStudent(Student student);

    /**
     * 新增后获得id
     * @param student
     */
    void addStudentByCache(Student student);
    /**

     * 删除

     */

    void deleteStudent(Serializable id);
    /*
    修改
     */
    void updateStudent(Student student);

    /*
   查询所有
    */
  List<Student> SelectAllStudent();

   /*
   查询所有返回Map集合
    */
   Map<String ,Object> selectAllStudents();
   /*
   根据id查询
    */
   Student findById(Serializable id);
   /*
   根据姓名模糊查询
    */
   List<Student> selectByName(String name);
}
