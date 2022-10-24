package be.abis.exercise.aspect;

import be.abis.exercise.exceptions.EnrollException;
import be.abis.exercise.model.Person;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    private final Logger consoleLog = LogManager.getLogger("Console");
    private final Logger errorLog = LogManager.getLogger("exceptionLogger");

    @AfterThrowing(pointcut="execution(public * be.abis.exercise.service.*.*Session(..))", throwing = "exc")
    public void logAfterException(EnrollException exc){
        errorLog.error(exc.getMessage());
    }

    @AfterReturning(pointcut="execution(public * be.abis.exercise.service.*.*Session(..))")
    public void logAfterReturning(JoinPoint jp){
        String firstName = ((Person)jp.getArgs()[0]).getFirstName();
        consoleLog.info(firstName + " is enrolled.");
    }

}
