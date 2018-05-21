package com.zx;

import com.zx.bean.Student;
import com.zx.dao.StudentDao;
import com.zx.util.SessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;


public class TestStudent {
StudentDao dao=null;
SqlSession session=null;
Logger log= Logger.getLogger(TestStudent.class);
@Before
    public void before(){
    session= SessionFactoryUtil.getSession();//获取session
    dao=session.getMapper(StudentDao.class);//获取执行的类对象
}
@After
    public void after(){
        if (session==null){
            session.close();
        }
}
@Test
    public void addStudent(){
    Student student=new Student();
    student.setName("mm");
    student.setAge(2);
    dao.addStudent(student);
    session.commit();

}


    //新增信息id
    @Test
    public void ByCache(){
        Student st=new Student();
        st.setName("pp");
        st.setAge(8);
        dao.addStudentByCache(st);
        session.commit();
        log.debug("新增后的学生id"+st.getId());
    }

    /**
     * 删除
     */
    @Test
    public void delete(){
        //  Student st=new Student();

        dao.deleteStudent(3);
        session.commit();


    }
    /**
     * 修改
     */
    @Test
    public void update(){
        Student st=new Student(1,"kk",6);

        dao.updateStudent(st);
        session.commit();

        log.debug(st);
    }

    /**
     *查询所有
     */
    @Test
    public void selectAll(){
        List<Student> student= dao.SelectAllStudent();
        log.debug(student);
        session.commit();
    }

    /**
     *查询所有Map
     */
    @Test
    public void Map(){
       List<Map<String,Object>>  student=dao.selectAllStudents();
        log.debug(student);
        session.commit();
    }



}
