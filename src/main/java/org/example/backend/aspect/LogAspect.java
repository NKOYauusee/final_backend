package org.example.backend.aspect;

import com.alibaba.fastjson2.JSONObject;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.example.backend.annotation.FucLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LogAspect {
    private final Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Before(value = "@annotation(org.example.backend.annotation.FucLogger)")
    public void before(JoinPoint point) {
        MethodSignature methodSignature = (MethodSignature) point.getSignature();
        FucLogger fucLogger = methodSignature.getMethod().getAnnotation(FucLogger.class);

        logger.info("{} -> {}", fucLogger.value(), JSONObject.toJSONString(point.getArgs()));
    }
}
