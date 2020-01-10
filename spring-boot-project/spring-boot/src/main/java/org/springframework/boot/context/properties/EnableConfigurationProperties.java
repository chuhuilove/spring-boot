/*
 * Copyright 2012-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.boot.context.properties;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

/**
 * 启用被{@link ConfigurationProperties}注解的bean的支持.
 * 可以用标准的方式注册{@link ConfigurationProperties} bean(例如使用{@link Bean @Bean}方法),
 * 或者,为了方便起见,可以直接在这个注解上指定.
 * 例如,{@link org.springframework.boot.autoconfigure.thymeleaf.ThymeleafAutoConfiguration},
 * {@code ThymeleafAutoConfiguration}需要自动注入{@link org.springframework.boot.autoconfigure.thymeleaf.ThymeleafProperties}属性类,
 * 就直接使用了本注解.
 *
 * <p>若是自己自定义spring boot的starter,在自动配置的时候,就需要用到这个注解了.
 *
 * @author Dave Syer
 * @since 1.0.0
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(EnableConfigurationPropertiesImportSelector.class)
public @interface EnableConfigurationProperties {

	/**
	 * Convenient way to quickly register {@link ConfigurationProperties} annotated beans
	 * with Spring. Standard Spring Beans will also be scanned regardless of this value.
	 *
	 * @return {@link ConfigurationProperties} annotated beans to register
	 */
	Class<?>[] value() default {};

}
