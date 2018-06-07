package com.zx;

import com.zx.bean.Student;
import com.zx.service.StudentService;
import com.zx.service.StudentServiceImp;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class test {
    ApplicationContext context=null;
    StudentService services=null;
    @Before
    public void before(){
        context=new ClassPathXmlApplicationContext("spring.xml");
        services=context.getBean("studentService", StudentServiceImp.class);
    }
    //添加
@Test
     public void before1(){
    Student student=new Student();
    student.setName("kouuuo");
    student.setAge(45);
        services.add(student);

}
//删除
    @Test
    public void del(){

        services.del(1);

    }


    //修改
    @Test
    public void update(){
Student student=new Student();
student.setName("rr");
student.setAge(0);
student.setId(4);
services.update(student);

    }


    //修改
    @Test
    public void selectAll(){
        List<Student> stu=services.selectAll();
        for (Student student:stu){
            System.out.println(student);
        }

    }
}
