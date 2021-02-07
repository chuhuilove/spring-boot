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

package org.springframework.boot.autoconfigure;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 提示应该在其他指定的自动配置类之前应用{@link EnableAutoConfiguration 自动配置}.
 *
 * @author Phillip Webb
 * @since 1.0.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE })
@Documented
public @interface AutoConfigureBefore {

	/**
	 * 应该还没有应用的自动配置类.
	 * @return the classes
	 */
	Class<?>[] value() default {};

	/**
	 * 应该尚未应用的自动配置类的名称.
	 * @return the class names
	 * @since 1.2.2
	 */
	String[] name() default {};

}
