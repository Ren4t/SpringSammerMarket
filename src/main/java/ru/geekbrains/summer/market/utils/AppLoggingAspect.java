package ru.geekbrains.summer.market.utils;


import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
@RequiredArgsConstructor
public class AppLoggingAspect {
    private final Statistic statistic;

    @Around("execution(public * ru.geekbrains.summer.market.services.*Service.*(..))")
    public Object methodProfilingOrderService(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("start profiling");
        long begin = System.currentTimeMillis();
        Object out = proceedingJoinPoint.proceed();
        long end = System.currentTimeMillis();
        long duration = end - begin;
        System.out.println((MethodSignature) proceedingJoinPoint.getSignature() + " duration: " + duration);
        System.out.println("end profiling");
        statistic.buildStatistic(proceedingJoinPoint.getSignature().getName(),duration);
        return out;
    }

//    @Around("execution(public * ru.geekbrains.summer.market.services.UserService.*(..))")
//    public Object methodProfilingUserService(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
//        System.out.println("start profiling");
//        long begin = System.currentTimeMillis();
//        Object out = proceedingJoinPoint.proceed();
//        long end = System.currentTimeMillis();
//        long duration = end - begin;
//        System.out.println((MethodSignature) proceedingJoinPoint.getSignature() + " duration: " + duration);
//        System.out.println("end profiling");
//        statistic.buildStatistic("UserService",duration);
//        return out;
//    }
}
