package com.example.firstproject.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.hibernate.loader.collection.OneToManyJoinWalker;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
@Slf4j
public class performanceAspect {

    //특정 어노테이션 대상 지정
    @Pointcut("@annotation(com.example.firstproject.annotation.RunningTime)")
    private void enableRunningTime(){}

    //기본 패캐지의 모든 메소드
    @Pointcut("execution(* com.example.firstproject..*.*(..))")
    private void cut(){}

    //실행 시점 설정 : 두 조건을 모두 만족하는 대상을 전후로 부가기능 삽입
    @Around("cut() && enableRunningTime()")
    public void loggingRunningTime(ProceedingJoinPoint joinPoint) throws Throwable {

        //메소드 수행 전
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        //메소드 수행
        Object returningObj = joinPoint.proceed();
        //메소드 수행 후
        stopWatch.stop();

        //메소드명
        String methodName = joinPoint.getSignature().getName();
        log.info("{}의 총 수행 시간  {} sec",methodName,stopWatch.getTotalTimeSeconds());
    }
}
