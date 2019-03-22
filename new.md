
@toc
### \pom.xml
```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.lin.plan</groupId>
    <artifactId>NewMybatis</artifactId>
    <version>1.0-SNAPSHOT</version>
    <dependencies>
        <!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>5.1.6</version>
        </dependency>
        <!-- https://mvnrepository.com/artifact/org.mybatis/mybatis -->
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis</artifactId>
            <version>3.4.6</version>
        </dependency>
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.12</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>antlr</groupId>
            <artifactId>antlr</artifactId>
            <version>2.7.7</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter-api</artifactId>
            <version>RELEASE</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>RELEASE</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>RELEASE</version>
            <scope>test</scope>
        </dependency>
    </dependencies>


</project>
```

@toc
### \src\main\java\com\lin\dao\CourseMapper.java
```java
package com.lin.dao;

public interface CourseMapper {
}

```

@toc
### \src\main\java\com\lin\dao\ScoreMapper.java
```java
package com.lin.dao;

public interface ScoreMapper {
}

```

@toc
### \src\main\java\com\lin\dao\StudentMapper.java
```java
package com.lin.dao;

import com.lin.model.Student;
import java.util.List;
import java.util.Map;

public interface StudentMapper {
    /**
     * 演示mybatis的基本用法
     * 增删改查，输入类型，输出类型
     */
    void insert(Student student);//传入类型为实体

    void delete(Map map);//k-v:参数名及对应的值

//    void update(@Param("studentId") String studentId, @Param("studentName") String studentName );//注解传参，相当于map的键值对

    Student select(String studentId);//字符串传参，返回值为实体类型

    List<Student> selectSelective();//返回值类型为List--每一个元素都是一个实体对象

    Map<String,Object> selectMulti();//返回值为多个字段，且不属于同一个实体

    List<Map<String,Object>> selectMultiList();//返回值为多条数据，每条数据包含多个字段，且这些字段不属于同一实体
}

```

@toc
### \src\main\java\com\lin\dao\TeacherMapper.java
```java
package com.lin.dao;

public interface TeacherMapper {
}

```

@toc
### \src\main\java\com\lin\model\Course.java
```java
package com.lin.model;

public class Course {

    private String courseId;

    private String courseName;

    private String teacherId;

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }
}

```

@toc
### \src\main\java\com\lin\model\Score.java
```java
package com.lin.model;

public class Score {
    private String scoreId;

    private String courseId;

    private double score;

    public String getScoreId() {
        return scoreId;
    }

    public void setScoreId(String scoreId) {
        this.scoreId = scoreId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}

```

@toc
### \src\main\java\com\lin\model\Student.java
```java
package com.lin.model;

import java.util.Date;

public class Student {
    private String studentId;

    private String studentName;

    private Date studentAge;

    private String studentSex;

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Date getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(Date studentAge) {
        this.studentAge = studentAge;
    }

    public String getStudentSex() {
        return studentSex;
    }

    public void setStudentSex(String studentSex) {
        this.studentSex = studentSex;
    }
}

```

@toc
### \src\main\java\com\lin\model\Teacher.java
```java
package com.lin.model;

public class Teacher {
    private String teacherId;

    private String teacherName;

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
}

```

@toc
### \src\main\java\com\lin\util\Dbutil.java
```java
package com.lin.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

public class Dbutil {
    private static SqlSessionFactory sqlSessionFactory;
    static {
        Resources.setCharset(Charset.forName("utf-8"));
        InputStream inputStream;
        try {
            inputStream=Resources.getResourceAsStream("Mybatis.xml");
            sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static SqlSession openSession() {
        return sqlSessionFactory.openSession();
    }
    public static void closeSession(SqlSession sqlSession) {
        if(sqlSession!=null) {
            sqlSession.close();
        }
    }
}
```

@toc
### \src\main\resources\jdbc.properties
```General
driver=com.mysql.jdbc.Driver
url=jdbc:mysql://localhost:3306/naruto?useUnicode=true&characterEncoding=utf8
username=hinata
password=123456
```

@toc
### \src\main\resources\mybatis.xml
```xml
<?xml version="1.0" encoding="UTF-8" ?>
        <!DOCTYPE configuration PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
                "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
<properties resource="jdbc.properties"/>
<environments default="development">
    <environment id="development">
        <transactionManager type="JDBC"/>
        <dataSource type="POOLED">
            <property name="driver" value="${driver}"></property>
            <property name="url" value="${url}"></property>
            <property name="username" value="${username}"></property>
            <property name="password" value="${password}"></property>
        </dataSource>
    </environment>
</environments>
<mappers>
    <mapper class="com.lin.dao.StudentMapper" />
</mappers>
</configuration>
```

@toc
### \src\main\resources\com\lin\newmybatis\CourseMapper.xml
```xml

```

@toc
### \src\main\resources\com\lin\newmybatis\ScoreMapper.xml
```xml

```

@toc
### \src\main\resources\com\lin\newmybatis\StudentMapper.xml
```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.aowin.dao.EmpMapper">
    <insert id="insert" parameterType="com.lin.model.Student">
        insert into student (student_id,student_name,student_age,student_sex)
        values('09' , '赵云' , '1990-01-01' , '男')
    </insert>


<!--    <insert id="insertOracleUser" parameterType="com.aowin.model.Person" flushCache="true">
        <selectKey order="BEFORE" resultType="java.lang.Integer" keyProperty="id">
            select personidseq.nextval from dual
        </selectKey>
        insert into person (id,name,sex,department,salary)
        values (#{id},#{name},#{sex},#{depart},#{salary})
    </insert>
    &lt;!&ndash;调用存储函数，更新指定id账户的姓名  &ndash;&gt;
    <update id="uptName" parameterType="java.util.Map" statementType="CALLABLE">
		{call personupdate(#{id,mode=INOUT,jdbcType=NUMERIC},#{name,mode=IN,jdbcType=VARCHAR,javaType=java.lang.String})}
	</update>
    &lt;!&ndash;oracle数据库  查询账户信息  &ndash;&gt;
    <select id="selectOraUser" parameterType="java.lang.Integer" resultType="com.aowin.model.Person">
        select * from person
        <where>
            <if test="id!=null">
                and id>#{id}
            </if>
        </where>
    </select>-->
</mapper>
```

@toc
### \src\main\resources\com\lin\newmybatis\TeacherMapper.xml
```xml

```
