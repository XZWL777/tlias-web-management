package com.itheima.aop;

import com.itheima.mapper.OperateLogMapper;
import com.itheima.pojo.OperateLog;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

@Aspect
@Component
public class OperateLogAspect {
    @Autowired
    private OperateLogMapper operateLogMapper;
    @Around("execution(* com.itheima.service.impl.*.*(..))")
    public Object logAround(ProceedingJoinPoint pjp) throws Throwable{
        long start=System.currentTimeMillis();
        Object result=pjp.proceed();
        long cost=System.currentTimeMillis()-start;

        OperateLog log=new OperateLog();
        log.setOperateTime(LocalDateTime.now());
        log.setClassName(pjp.getTarget().getClass().getName());
        log.setMethodName(pjp.getSignature().getName());
        log.setMethodParams(Arrays.toString(pjp.getArgs()));
        log.setReturnValue(String.valueOf(result));
        log.setCostTime(cost);
        operateLogMapper.insert(log);
        return result;

    }
}
