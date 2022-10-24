package be.abis.exercise.aspect;

import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

public class MyPointcut {
// could be like an "overviez" of all pointcuts -> useful if you want to combine
// pointcuts

    @Pointcut("execution(public * be.abis.exercise.service.*.*Person(..))")
    public void doSomethingPointcut(){}

}
