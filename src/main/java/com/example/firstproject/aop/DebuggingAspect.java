package com.example.firstproject.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.sql.rowset.JoinRowSet;

@Aspect
@Component
@Slf4j
public class DebuggingAspect {
    // 대상 메소드 선택
    @Pointcut("execution(* com.example.firstproject.service.CommentService.create(..))")
    private void cut(){

    }

    //실행시점 설정
    @Before("cut()") //cut()의 대상이 수행되기 이전에 실행된다.
    public void loggingArgs(JoinPoint joinPoint){ //cut의 대상 메소드
        // 입력값 가져오기

        //클래스명

        //메소드명

        //입력값 로깅하기

    }
}
