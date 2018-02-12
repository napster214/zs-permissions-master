package cn.com.zs.permissions.code.log;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Arrays;

/**
 * 标题: 访问日志
 * <p>
 * 描述: 利用aop打印访问日志
 * <p>
 * 版权: Copyright (c) 2018
 * <p>
 *
 * @author 张顺
 * @version 1.0
 * @created 2018/2/3-22:49
 */
@Aspect
@Slf4j
public class AccessLogAspect {


    @Pointcut("within(@org.springframework.web.bind.annotation.RestController *)")
    public void springBeanPointcut(){}

    public void permissionsPointcut(){}

    @AfterThrowing(pointcut = "springBeanPointcut()",throwing = "throwable")
    public void logAfterThrowing(JoinPoint joinPoint,Throwable throwable){
        log.error("Exception in {} with cause = ",joinPoint.getSignature().getDeclaringTypeName(),
            joinPoint.getSignature().getName(), throwable.getCause() != null ? throwable.getCause() : "NULL", throwable.getMessage(),throwable);
    }

    @Around("springBeanPointcut()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        if (log.isDebugEnabled()){
            log.debug("Enter:{}.{}() with argument[s] = {}",joinPoint.getSignature().getDeclaringTypeName(),
                    joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()));
        }
        try {
            Object result = joinPoint.proceed();
            if (log.isDebugEnabled()){
                log.debug("Enter:{}.{}() with result = {}",joinPoint.getSignature().getDeclaringTypeName(),
                        joinPoint.getSignature().getName(),result);
            }
            return result;
        } catch (Throwable throwable) {
            throw throwable;
        }
    }
}
