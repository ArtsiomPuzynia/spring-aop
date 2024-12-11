package title;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Aspect
@Component
public class LogAspect {

    @Pointcut("@annotation(title.Log) && execution(public !static * *(..))")
    public void logMethods() {}

    @Before("logMethods()")
    public void logBefore(JoinPoint jp) {
        System.out.println("Logging before" + jp.getSignature().toShortString());
    }

    @AfterReturning(pointcut = "logMethods()", returning = "retVal")
    public void logAfterReturning(JoinPoint jp,Object retVal) {
        System.out.println("Logging after : " + jp.getTarget() + " : " + retVal);

    }
    @AfterThrowing(pointcut = "logMethods()", throwing = "ex")
    public void logAfterThrowing(RuntimeException ex) {

    }

    @After("logMethods()")
    public void logAfterFinal() {}

    @Around("logMethods()")
    public Object logAround(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("Logging around" + pjp.getSignature().toShortString());
        return pjp.proceed();
    }
}


