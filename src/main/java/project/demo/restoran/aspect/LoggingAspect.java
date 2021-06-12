package project.demo.restoran.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import project.demo.restoran.model.Tables;


@Aspect
@Component
public class LoggingAspect {
    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Around("execution(* project.demo.restoran.controller.*.*(..))")
    public Object aroundAllMethods(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        Object methodResault = null;
        MethodSignature methodSignature =
                (MethodSignature) proceedingJoinPoint.getSignature();
        String nameMethod = methodSignature.getName();
        logger.info("start " + nameMethod );
        try {
            methodResault = proceedingJoinPoint.proceed();
        }
        catch (Throwable exception) {
            System.out.println("catch exception aroundAllMethods " + exception);
            throw exception;
        }
        if(methodSignature.getName().equals("newReserve")){
            Object[] arguments = proceedingJoinPoint.getArgs();
            for(Object obj : arguments){
                if(obj instanceof Tables){
                    logger.info("arg name " + ((Tables) obj).getName() + " arg number " + ((Tables) obj).getPhoneNumber());}
            }}
        logger.info("end " + nameMethod);
        return methodResault;
    }
}






