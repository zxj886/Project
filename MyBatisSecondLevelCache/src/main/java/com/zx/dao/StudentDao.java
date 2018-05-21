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

    /*
    根据id查询 缓存二级
     */
    Student findById(Serializable id);






}
