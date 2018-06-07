package com.zx.dao;

import com.zx.bean.Student;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class StudentDaoImp extends JdbcDaoSupport implements  StudentDao {
        public void add(Student student) {//添加学生
        String sql="INSERT INTO student1(NAME,age) VALUES(?,?)";

        getJdbcTemplate().update(sql,student.getName(),student.getAge());
    }

//    public int add(Student student) {//添加学生
//        String sql="INSERT INTO student1(NAME,age) VALUES(?,?)";
//
//        return getJdbcTemplate().update(sql,student.getName(),student.getAge());
//    }

    public int del(Serializable id) {
            String sql="DELETE FROM student1 WHERE id=?";
        return getJdbcTemplate().update(sql,id);
    }

    public int update(Student student) {
            String sql="UPDATE student1 SET NAME=?,age=? WHERE id=?";
        return getJdbcTemplate().update(sql,student.getName(),student.getAge(),student.getId());
    }

    public List<Student> selectAll() {
            String sql="select * from student1";
        return getJdbcTemplate().query(sql,new RowMapper<Student>(){

            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                //创建对象一次
                Student student=new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setAge(rs.getInt("age"));
                return student;
            }
        });


    }
}
