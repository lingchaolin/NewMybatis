package com.lin.dao.run;

import com.lin.dao.StudentMapper;
import com.lin.model.Student;
import com.lin.util.Dbutil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class StudentImpl {
    SqlSession session= Dbutil.openSession();
    StudentMapper mapper=session.getMapper(StudentMapper.class);
    public void insert(Student student){
        mapper.insert(student);
        session.commit();
        System.out.println(student);
    }

    public void delete(Map map){
        mapper.delete(map);
    }

    public Student select(String studentId) {
       return  mapper.select(studentId);

    }

    public List<Student> selectSelective(){
        return mapper.selectSelective();
    }

    public Map<String,Object> selectMulti(){
        return mapper.selectMulti();
    }

    public List<Map<String,Object>> selectMultiList(){
        return mapper.selectMultiList();
    }

}
