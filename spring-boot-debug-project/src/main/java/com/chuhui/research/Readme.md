## 重写RequestMappingHandlerMapping

在spring-framework 5.x中,自定义RequestHandleMapping,需要继承`WebMvcConfigurationSupport`,
然后重写`requestMappingHandlerMapping`方法.

在Spring Boot的`org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration.EnableWebMvcConfiguration`中,示例是这样的:
```java
@Bean
@Primary
@Override
public RequestMappingHandlerMapping requestMappingHandlerMapping() {
    // Must be @Primary for MvcUriComponentsBuilder to work
    return super.requestMappingHandlerMapping();
}   
```
从上面的这两个注解,可以得出结论,如果按照下面这种格式:

```java
@Bean
public RequestMappingHandlerMapping requestMappingHandlerMapping() {
        		 
	return new CustomizeRequestMapping();
}   
```
是无法完成取代自动配置的`RequestMappingHandlerMapping`.

除非,继承`WebMvcConfigurationSupport`,重写`requestMappingHandlerMapping`方法.

## 探究``

