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

package org.springframework.boot.autoconfigure.condition;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.Conditional;

/**
 * 当给定的在bean存在时,则实例化当前Bean.
 * <p>
 * 只有当满足所有指定要求的bean已经包含在{@link BeanFactory}中时,才匹配该{@link Conditional}.
 * 为了匹配条件,必须满足所有的要求,但是它们不需要由同一个bean来满足.
 * <p>
 * 当放置在{@code @Bean}方法上时,bean类默认为工厂方法的返回类型:
 *
 * <pre class="code">
 * &#064;Configuration
 * public class MyAutoConfiguration {
 *
 *     &#064;ConditionalOnBean
 *     &#064;Bean
 *     public MyService myService() {
 *         ...
 *     }
 * }</pre>
 * <p>
 * 在上面的示例中,如果{@link BeanFactory}中已经包含{@code MyService}类型的Bean,则条件将匹配.
 * <p>
 * 该条件只能匹配到目前为止应用程序上下文处理过的bean定义,因此,强烈建议仅在自动配置类上使用该条件.
 * 如果另一个自动配置可以创建一个候选bean,请确保使用此条件的bean在其后运行.
 *
 * @author Phillip Webb
 * @since 1.0.0
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Conditional(OnBeanCondition.class)
public @interface ConditionalOnBean {

	/**
	 * The class types of beans that should be checked. The condition matches when beans
	 * of all classes specified are contained in the {@link BeanFactory}.
	 *
	 * @return the class types of beans to check
	 */
	Class<?>[] value() default {};

	/**
	 * The class type names of beans that should be checked. The condition matches when
	 * beans of all classes specified are contained in the {@link BeanFactory}.
	 *
	 * @return the class type names of beans to check
	 */
	String[] type() default {};

	/**
	 * The annotation type decorating a bean that should be checked. The condition matches
	 * when all of the annotations specified are defined on beans in the
	 * {@link BeanFactory}.
	 *
	 * @return the class-level annotation types to check
	 */
	Class<? extends Annotation>[] annotation() default {};

	/**
	 * The names of beans to check. The condition matches when all of the bean names
	 * specified are contained in the {@link BeanFactory}.
	 *
	 * @return the names of beans to check
	 */
	String[] name() default {};

	/**
	 * Strategy to decide if the application context hierarchy (parent contexts) should be
	 * considered.
	 *
	 * @return the search strategy
	 */
	SearchStrategy search() default SearchStrategy.ALL;

	/**
	 * Additional classes that may contain the specified bean types within their generic
	 * parameters. For example, an annotation declaring {@code value=Name.class} and
	 * {@code parameterizedContainer=NameRegistration.class} would detect both
	 * {@code Name} and {@code NameRegistration<Name>}.
	 *
	 * @return the container types
	 * @since 2.1.0
	 */
	Class<?>[] parameterizedContainer() default {};

}
