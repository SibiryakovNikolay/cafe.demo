package project.restoran2.demo.restoran.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LoggingAspect {
    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Around("execution(* project.restoran2.demo.restoran.service.*.*(..))")
    public Object aroundAllMethods(ProceedingJoinPoint proceedingJoinPoint) {

        Object methodResault = null;
        MethodSignature methodSignature =
                (MethodSignature) proceedingJoinPoint.getSignature();
        String nameMethod = methodSignature.getName();
        logger.info("start " + nameMethod);
        try {
            methodResault = proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        logger.info("end " + nameMethod);
        return methodResault;

    }


}






