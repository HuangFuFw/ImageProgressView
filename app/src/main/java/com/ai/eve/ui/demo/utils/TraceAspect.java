package com.ai.eve.ui.demo.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

/**
 * Created by huangfu on 2016/8/30 17.:03
 */
@Aspect
public class TraceAspect {
    private static final String POINTCUT_METHOD =
            "execution(@com.ai.eve.ui.demo.utils.TimeTrace * *(..))";

    private static final String POINTCUT_CONSTRUCTOR =
            "execution(@com.ai.eve.ui.demo.utils.TimeTrace *.new(..))";

    @Pointcut(POINTCUT_METHOD)
    public void methodAnnotatedWithTimeTrace() {
    }


    @Pointcut(POINTCUT_CONSTRUCTOR)
    public void constructorAnnotatedWithTimeTrace() {
    }

    @Around("methodAnnotatedWithTimeTrace()||constructorAnnotatedWithTimeTrace()")
    public Object weaveJointPoint(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String className = signature.getDeclaringType().getSimpleName();
        String metnodName = signature.getName();

        TimeWatcher timeWatcher = new TimeWatcher();
        timeWatcher.star();
        Object result = joinPoint.proceed();
        timeWatcher.end();

//        Log.d(className, "==========" + metnodName + "时间==========" + timeWatcher.getTotalTimeMillis());
        System.out.println(className+"==========" + metnodName + "==========" + timeWatcher.getTotalTimeMillis());
        return result;
    }

}
