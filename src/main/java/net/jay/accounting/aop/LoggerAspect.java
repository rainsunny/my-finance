package net.jay.accounting.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author wangjie
 * @date 6/19/14
 */
@Aspect
@Component
public class LoggerAspect {

    private Logger logger = Logger.getLogger(LoggerAspect.class);

    @Pointcut("execution(* update*(..))")
    private void anyUpdate(){}

    @Pointcut("@annotation(net.jay.accounting.Update)")
    private void annotatedUpdate(){}


    @AfterReturning(pointcut = "annotatedUpdate()", returning = "retVal")
    public void doCheck(JoinPoint joinPoint, int retVal) {
        logger.info("--- aop --- " + joinPoint.toString() + ", return val: " + retVal);
    }

}
