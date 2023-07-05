package com.demoboot.conditional;

import java.util.Map;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class CustomOnProfileCondition implements Condition{

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		
		String property = context.getEnvironment().getProperty("spring.profiles.active", String.class, "dev");
		Map<String, Object> args = metadata.getAnnotationAttributes(ConditionOnProfile.class.getName());
//		System.out.println(property + args.get("value"));
		return property.contains(args.get("value").toString());
	}

}
