package com.example.springboottest.test;

import java.util.*;


public class CodeTest {
    public static void main(String[] args) {
        int[] a = {3,4,1,2,5,7,9,6,8};
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1 - i ; j++) {
                if(a[j] > a[j + 1]) {
                    int flag;
                    flag = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] =flag;
                }
            }
        }
        System.out.println(Arrays.toString(a));
       Arrays.sort(a);
       System.out.println(Arrays.toString(a));

        //构造user
        User han = new User("韩成志","123456",24,"15000000000");
        User zhang = new User("张三","123456",18,"15000000000");
        User wang = new User("王五","123456",32,"15000000000");
        User li = new User("李四","123456",27,"15000000000");
        List<User> userList = new ArrayList<>();
        userList.add(han);
        userList.add(zhang);
        userList.add(wang);
        userList.add(li);

        //按照年龄给userList排序,使用JDK8特性，lambda表达式
        userList.sort(Comparator.comparing(User::getAge).reversed())    ;

        userList.subList( 0 , userList.size() ).forEach(user -> {
            System.out.println(user.toString());
        });
        String string = userList.toString();
        System.out.println(string);

        for (;;) {
            Scanner scanner = new Scanner(System.in);
            String s = scanner.next();
            System.out.println(s);
        }



    }
}
