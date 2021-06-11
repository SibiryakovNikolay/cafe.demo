package project.restoran2.demo.restoran.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Aspect
@Component
public class LoggingAspect {

    @Around("execution(* project.restoran2.demo.restoran.service.*.*(..))")
    public Object aroundAllMethods(ProceedingJoinPoint proceedingJoinPoint)  {
        Path directory = Paths.get("log");
        try {
            if (Files.notExists(directory)){
                Files.createDirectory(directory);}
        } catch (IOException exception) {
            System.out.println("error creating directory");
        }
        String fileLog = "log/cafe_log.txt";
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy MM dd, hh:mm:ss");
        Object methodResault = null;
        try (FileWriter writer = new FileWriter(fileLog, true)) {
            MethodSignature methodSignature =
                    (MethodSignature) proceedingJoinPoint.getSignature();
            String nameMethod = methodSignature.getName();
            writer.write(date.format(dtf) + " : " + "Begin of" + methodSignature + "\n");
            try {
                methodResault = proceedingJoinPoint.proceed();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
            writer.write(date.format(dtf) + " : " + "End of" + methodSignature + "\n");
            return methodResault;
        } catch (IOException exception) {
            System.out.println("logging error");
            return alterMethod(proceedingJoinPoint);
        }
    }


    public Object alterMethod(ProceedingJoinPoint proceedingJoinPoint) {
        MethodSignature methodSignature =
                (MethodSignature) proceedingJoinPoint.getSignature();
        String nameMethod = methodSignature.getName();
        System.out.println("Begin of" + methodSignature);
        Object methodResault = null;
        try {
            methodResault = proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("End of" + methodSignature);
        return methodResault;
    }

}






