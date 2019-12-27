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
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.support.SpringFactoriesLoader;

/**
 *
 * 启用Spring Application Context的自动配置,尝试猜测和配置应用可能需要的bean.
 * 通常根据应用的类路径和定义的bean来应用自动配置类.
 * 例如,如果应用的类路径中有{@code tomcat-embedded.jar},
 * 那么应用可能需要一个{@link TomcatServletWebServerFactory}(除非你自己已经定义了自己的{@link ServletWebServerFactory} bean).
 *
 * <p>在使用{@link SpringBootApplication}时,上下文的自动配置是自动启用的,因此添加这个注解不会产生额外的影响.
 *
 * <p>自动配置试图尽可能地智能化,并且在发现应用已经定义了自己的配置时,将会撤出自动配置.
 * 你总是可以手动{@link #exclude()}你不希望使用的任何配置(如果你没有访问它们的权限,则使用{@link #excludeName()}).
 * 您还可以通过{@code spring.autoconfigure.exclude}属性排除它们.
 * 自动配置始终在注册用户定义的bean之后应用.
 *
 * <p>使用{@code @EnableAutoConfiguration}注解的类包(通常通过{@code @SpringBootApplication})具有特定的意义,通常用作'default'.
 * 例如,它将在扫描{@code @Entity}类时使用.
 * 通常建议将{@code @EnableAutoConfiguration}(如果不使用{@code @SpringBootApplication})放在根包中,以便搜索所有子包和类.
 *
 * <p>自动配置类是常规的Spring{@link Configuration}bean,比如:{@link org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration}.
 * 它们使用{@link SpringFactoriesLoader}机制定位(针对此类).
 * 通常,自动配置bean是{@link Conditional @Conditional} bean
 * (通常使用{@link ConditionalOnClass @ConditionalOnClass}和{@link ConditionalOnMissingBean @ConditionalOnMissingBean}注解).
 *
 * @author Phillip Webb
 * @author Stephane Nicoll
 * @since 1.0.0
 * @see ConditionalOnBean
 * @see ConditionalOnMissingBean
 * @see ConditionalOnClass
 * @see AutoConfigureAfter
 * @see SpringBootApplication
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@AutoConfigurationPackage
@Import(AutoConfigurationImportSelector.class)
public @interface EnableAutoConfiguration {

	String ENABLED_OVERRIDE_PROPERTY = "spring.boot.enableautoconfiguration";

	/**
	 * Exclude specific auto-configuration classes such that they will never be applied.
	 * @return the classes to exclude
	 */
	Class<?>[] exclude() default {};

	/**
	 * Exclude specific auto-configuration class names such that they will never be
	 * applied.
	 * @return the class names to exclude
	 * @since 1.3.0
	 */
	String[] excludeName() default {};

}
