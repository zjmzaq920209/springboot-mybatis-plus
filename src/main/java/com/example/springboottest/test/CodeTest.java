package com.example.springboottest.test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.MonthDay;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;


public class CodeTest {
/*    public static void main(String[] args) {
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



    }*/

  public static void main(String[] args) {
    LocalDate today = LocalDate.now();
    System.out.println("Today's date = "+ today);
    System.out.println(today.getMonth());
    System.out.println(today.getMonthValue());




    LocalDate aWeekLater=today.plus(1, ChronoUnit.WEEKS);
    System.out.println("A week later="+aWeekLater);


    LocalDate aYearBefore=today.plus(-1, ChronoUnit.YEARS);
    System.out.println("A Year before="+aYearBefore);

    // 日期比较
    LocalDate longAgo=LocalDate.of(2000, 1, 1);
    if(longAgo.isBefore(aYearBefore)) {
      System.out.println(longAgo+" is before "+aYearBefore);
    }



    // 当前时间
    LocalTime currTime=LocalTime.now();
    System.out.println("Current time="+currTime);

    LocalDateTime currDateTime = LocalDateTime.now();
    System.out.println(currDateTime);

    ZonedDateTime currZoneDateTime = ZonedDateTime.now();

    System.out.println(currZoneDateTime);







    LocalDate dateOfBirth = LocalDate.of(2010,04,20);

    MonthDay birthday = MonthDay.of(dateOfBirth.getMonth(), dateOfBirth.getDayOfMonth());

    MonthDay currentMonthDay = MonthDay.from(today);








    if(currentMonthDay.equals(birthday)){

      System.out.println("Many Many happy returns of the day !!");

    }else{

      System.out.println("Sorry, today is not your birthday");

    }




  }
}
