package com.example.concurrentlearn.config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Author: wangyu
 * @Date: Created 2020-02-29 16:44
 * @Description:
 * @Modified By:
 */
@Aspect
@Component
public class NotVeryUsefulAspect {


    @Pointcut("execution(* com.example.concurrentlearn.dao..*(..))")
    public void  anyOldTransfer(){

    }

    @Before("anyOldTransfer()")
    public void  advice(){
        System.out.println("========aspect test before ========");
    }


}
