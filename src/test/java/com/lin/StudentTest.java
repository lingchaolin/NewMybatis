package com.lin;

import com.lin.dao.StudentMapper;
import com.lin.model.Student;
import com.lin.util.Dbutil;
import org.apache.ibatis.session.SqlSession;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(Arquillian.class)
public class StudentTest {
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(Student.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }
    SqlSession sqlSession;
    StudentMapper mapper;
    @Before
    public void setUp() throws Exception {
        sqlSession= Dbutil.openSession();
    }

    @After
    public void tearDown() throws Exception {
    }
    @Test
    public void insertOne(){
        mapper=sqlSession.getMapper(StudentMapper.class);//通过接口名找方法
//        Student student=mapper.getMess(125);//调用方法，接收返回值
    }
}
