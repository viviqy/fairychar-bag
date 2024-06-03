package com.fairychar.bag.domain.conditional;

import com.fairychar.bag.domain.Singletons;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Map;
import java.util.Random;

/**
 * @author chiyo
 */
@Slf4j
class OnRandomNumberCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Map<String, Object> annotationAttributes = metadata.getAnnotationAttributes(ConditionalOnRandomNumber.class.getName());
        int end = (int) annotationAttributes.get("end");
        int number = (int) annotationAttributes.get("number");
        Random random = Singletons.RandomBean.getInstance();
        int randomNumber = random.nextInt(end);
        if (randomNumber == number) {
            return true;
        }
        return false;
    }
}
