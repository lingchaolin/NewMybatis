package test.com.lin.dao.run;

import com.lin.dao.run.StudentImpl;
import com.lin.model.Student;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;

/** 
* StudentImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>03/23/2019</pre> 
* @version 1.0 
*/ 
public class StudentImplTest {
    StudentImpl studentImpl=new StudentImpl();
    SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd hh:mm:ss");
@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception {
    System.out.println("finish******");
} 

/** 
* 
* Method: insert(Student student) 
* 
*/ 
@Test
public void testInsert() throws Exception {
    Student student=new Student();
    student.setStudentId("100001");
    student.setStudentAge(sdf.parse(sdf.format(System.currentTimeMillis())));
    student.setStudentName("张三");
    student.setStudentSex("nan");
    System.out.println(student);
    studentImpl.insert(student);
} 

/** 
* 
* Method: delete(Map map) 
* 
*/ 
@Test
public void testDelete() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: select(String studentId) 
* 
*/ 
@Test
public void testSelect() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: selectSelective() 
* 
*/ 
@Test
public void testSelectSelective() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: selectMulti() 
* 
*/ 
@Test
public void testSelectMulti() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: selectMultiList() 
* 
*/ 
@Test
public void testSelectMultiList() throws Exception { 
//TODO: Test goes here... 
} 


} 
