package com.demoboot.configs;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnJava;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnResource;
import org.springframework.boot.system.JavaVersion;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import com.demoboot.conditional.ConditionOnProfile;
import com.demoboot.conditional.ForConditionDev;
import com.demoboot.conditional.ForConditionTest;
import com.demoboot.conditions.CustomCondition;
import com.demoboot.entities.Greeting;
import com.demoboot.entities.Welcome;

@Configuration
@ConditionalOnClass(lombok.Lombok.class)
@ConditionalOnJava(value = JavaVersion.SEVENTEEN)
public class SpringBeansConfig {

	@Bean
	@Conditional(CustomCondition.class)
	@ConditionalOnBean(Welcome.class)
	@ConditionalOnResource(resources = "/newFile.txt")
	@ConditionalOnProperty(value = "custom.enabled", havingValue = "true", matchIfMissing = true)
	Greeting greeting() {
		return new Greeting();
	}

	@Bean
	@ConditionOnProfile("dev")
	ForConditionDev forConditionDev() {
		return new ForConditionDev();
	}

	@Bean
	@ConditionOnProfile("test")
	ForConditionTest forConditionTest() {
		return new ForConditionTest();
	}
	
}
