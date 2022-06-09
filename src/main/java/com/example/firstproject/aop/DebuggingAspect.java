package com.example.firstproject.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import javax.sql.rowset.JoinRowSet;

@Aspect
@Component
@Slf4j
public class DebuggingAspect {
    // 대상 메소드 선택
//    @Pointcut("execution(* com.example.firstproject.service.CommentService.create(..))")
    @Pointcut("execution(* com.example.firstproject.service.CommentService.*(..))")
    private void cut(){

    }

    //실행시점 설정
    @Before("cut()") //cut()의 대상이 수행되기 이전에 실행된다.
    public void loggingArgs(JoinPoint joinPoint){ //cut의 대상 메소드
        // 입력값 가져오기
        Object[] args = joinPoint.getArgs();

        //클래스명
        String className = joinPoint.getTarget().getClass().getSimpleName();

        //메소드명
        String methodName = joinPoint.getSignature().getName();

        //입력값 로깅하기
        for(Object obj :args){ //forEach 문
            log.info("{}#{}의 입력값 => {}",className,methodName,obj);

        }

    }

    @AfterReturning(value = "cut()",returning = "returnObj") //cut()에 지정된 대상 호출 성공후!
    public void loggingReturnValue(JoinPoint joinPoint, //cut의 대상 메소드
                                   Object returnObj){ //리턴값
        //반환값 로깅
        //CommentService#Create()의 반환값 => CommentDto(id = 10,...)

        //클래스명
        String className = joinPoint.getTarget().getClass().getSimpleName();

        //메소드명
        String methodName = joinPoint.getSignature().getName();


        log.info("{}#{}의 반환값 => {}",className,methodName,returnObj);


    }
}
