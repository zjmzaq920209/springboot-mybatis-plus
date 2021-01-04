package com.example.springboottest.test;

import com.example.springboottest.entity.Student;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * @PackageName: com.example.springboottest.test
 * @className: Student
 * @Description:
 * @Author: Jingmeng
 * @Date: 2020/10/29 13:18
 **/
public class StudentTest {

  public static void main(String[] args) {
    List<Student> list = new ArrayList<>();
    Student s1 = new Student();
    s1.setName("张一一");
    s1.setGrade(1);
    s1.setClazz(1);
    Student s2 = new Student();
    s2.setName("张erer");
    s2.setGrade(1);
    s2.setClazz(1);
    Student s3 = new Student();
    s3.setName("张三毛");
    s3.setGrade(2);
    s3.setClazz(2);
    Student s4 = new Student();
    s4.setName("张小小");
    s4.setGrade(3);
    s4.setClazz(3);
    list.add(s1);
    list.add(s2);
    list.add(s3);
    list.add(s4);

    System.out.println(list);

    list =
        list.stream().collect(Collectors.collectingAndThen(Collectors.toCollection(() ->
            new TreeSet<>(Comparator.comparing(o -> o.getClazz() + ";" + o.getGrade()))), ArrayList::new));

    System.out.println(list);





  }

}
