package com.ysy.config;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

/**
 * @author shanyangyang
 * @date 2020/5/27
 */
public class MyTypeFilter implements TypeFilter {
	/**
	 * @param metadataReader        读取到的当前正在扫描的类的信息
	 * @param metadataReaderFactory  可以获取其他任何类信息
	 *                              for other classes (such as superclasses and interfaces)
	 * @return
	 */
	@Override public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) {
		//获取当前类的注解信息
		AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
		//获取当前类的类信息
		ClassMetadata classMetadata = metadataReader.getClassMetadata();
		//获取类的资源信息
		Resource resource = metadataReader.getResource();

		String className = classMetadata.getClassName();

		if (className.contains("er")){
			return true;
		}
		System.out.println(className);
		return false;
	}
}
