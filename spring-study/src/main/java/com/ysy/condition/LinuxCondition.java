package com.ysy.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author shanyangyang
 * @date 2020/5/28
 */
public class LinuxCondition  implements Condition
{
	@Override public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		return context.getEnvironment().getProperty("os.name").contains("linux");
	}
}
