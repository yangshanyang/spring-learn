package com.ysy.condition;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author shanyangyang
 * @date 2020/5/29
 * 自定义逻辑，返回需要导入的组件
 */
public class
MyImportSelector implements ImportSelector {
	//返回值就是导入到容器中的组件全类名
	//AnnotationMetadata：当前标注@Import注解的类的所有注解信息
	//方法不要返回null
	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {

		return new String[]{"com.ysy.Bean.Blue","com.ysy.Bean.Yellow"};
	}
}
