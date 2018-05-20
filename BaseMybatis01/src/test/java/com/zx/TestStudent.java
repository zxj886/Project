package com.zx;

import com.zx.bean.Student;
import com.zx.dao.StudentDao;
import com.zx.dao.StudentDaoImp;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class TestStudent {
    StudentDao dao=null;
   Logger log=Logger.getLogger(TestStudent.class);
    @Before
    public void before(){
    dao=new StudentDaoImp();
    }
//新增信息导数据库
    @Test
    public void TestAdd(){
        Student st=new Student();
        st.setName("bb");
        st.setAge(90);
         dao.addStudent(st);
      log.debug("insert之后学生的编号："+st.getId());
    }


    //新增信息id
    @Test
    public void ByCache(){
        Student st=new Student();
        st.setName("pp");
        st.setAge(8);
        dao.addStudentByCache(st);
        log.debug("insert之后学生的编号："+st.getId());
    }

    /**
     * 删除
     */
    @Test
    public void delete(){
      //  Student st=new Student();

       dao.deleteStudent(3);



    }
    /**
     * 修改
     */
    @Test
    public void update(){
        Student st=new Student(1,"kk",6);

      dao.updateStudent(st);


        log.debug("修改之后学生的编号："+st.getId());
    }

    /**
     *查询所有
     */
    @Test
    public void selectAll(){
        List<Student> student= dao.SelectAllStudent();




        log.debug(student);
    }

    /**
     *查询所有Map
     */
    @Test
    public void selectAllMap(){
        Map<String,Object> student=dao.selectAllStudents();




        log.debug(student);
    }
    /**
     *
     *查询id查询指定信息
     */
    @Test
    public void findById(){
        Student st= dao.findById(2);

       log.debug(st);

    }
    /**
     *根据姓名模糊查询
     */
    @Test
    public void selectName(){
        List<Student> student=dao.selectByName("b");
        log.debug(student);

    }
    @Test
    public void TestAdd2(){
      for (int i=1000;i<=2000;i++){
if(i%3==2&&i%5==4&&i%8==3){
System.out.println(i);
}
      }
    }
    @Test
    public void TestAdd1(){
       int h=50;
       int f=120;
       for (int x=0;x<=50;x++){
           int y=50-x;
           if(x*2+y*4==120){
               System.out.println(x);
               System.out.println(y);
           }
       }
    }


    @Test
    public void money(){

 for(int a=0;a<80/50;a++){
 for(int b=0;b<80/20;b++){
     for(int c=0;c<80/10;c++){

         for(int d=0;d<80/5;d++){


         }

     }

 }
 }
    }

}
