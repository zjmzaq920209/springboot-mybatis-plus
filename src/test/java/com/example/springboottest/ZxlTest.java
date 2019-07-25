package com.example.springboottest;

import com.example.springboottest.task.AsyncTaskService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.Future;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class ZxlTest {
    @Autowired
    private AsyncTaskService asyncTaskService;
    @Test
    public void testAsync(){
//        String msg="测试测试";
//        System.out.println(Thread.currentThread().getName()+":"+msg);
//        asyncTaskService.executeAsyncTask(msg);
        try {
            long start = System.currentTimeMillis();
            Future<Long> future = asyncTaskService.asyncInvokeReturnFuture();
            Future<Long> future2 = asyncTaskService.asyncInvokeReturnFuture2();
            Future<Long> future3 = asyncTaskService.asyncInvokeReturnFuture3();
            Long l1 = future.get();//5000
            Long l2 = future2.get();//3500
            Long l3 = future3.get();//2500
            System.out.println(Thread.currentThread().getName()+"*************************************");
            System.out.println(Thread.currentThread().getName()+(l1+l2+l3 ));
            System.out.println(Thread.currentThread().getName()+"-------------------------------------");
            System.out.println(Thread.currentThread().getName()+(System.currentTimeMillis()-start));
            System.out.println(Thread.currentThread().getName()+"+++++++++++++++++++++++++++++++++++++");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
