## 49 创建自己的自动配置

### 49.1 理解自动配置Bean

在底层,自动配置是用标准的`@Configuration`类实现的.额外的`@Conditional `注解用于在应用自动配置时进行约束.通常,自动配置类使用`@ConditionalOnClass`和`@ConditionalOnMissingBean`注解.这确保了只有在找到相关类以及你没有声明自己的`@Configuration`时才会应用自动配置.

可以浏览[`spring-boot-autoconfigure`]()的源代码以查看Spring提供的`@Configuration`类(请参阅[`META-INF/spring.factories`]()文件).

### 49.2 查找自动配置候选者

在你发布的jar中,Spring Boot会自动检查是否存在`META-INF/spring.factories`文件.该文件应该在在key为`EnableAutoConfiguration`的属性下列出你的配置类,如下面的示例所示:

```properties
org.springframework.boot.autoconfigure.EnableAutoConfiguration=\
com.mycorp.libx.autoconfigure.LibXAutoConfiguration,\
com.mycorp.libx.autoconfigure.LibXWebAutoConfiguration
```
>自动配置只能以这种方式加载.确保它们是在特定的包空间中定义的,并且它们不能是组件扫描的目标.此外,自动配置类不应启用组件扫描以查找其他组件.应该使用特定的`@Imports`代替.

如果需要按特定顺序应用配置,可以使用`@AutoConfigureAfter`或`@AutoConfigureBefore`注解.例如,如果你提供了特定于web的配置,那么你的类可能需要在`WebMvcAutoConfiguration`之后应用.

如果要排序某些彼此之间不具有直接关联的自动配置,则也可以使用`@AutoConfigureOrder`.该注解与常规的`@Order`注解具有相同的语义,只是单纯的为自动配置类提供了专用的顺序.


### 49.3 Condition 注解

#### 49.3.1 Class Conditions

#### 49.3.2 Bean  Conditions

### 49.4 Testing your Auto-configuration


### 49.5 Creating Your Own Starter


一个完整的Spring Boot程序库可能包含以下组件:

- 包含自动配置代码的`autoconfigure`模块.
- 为`autoconfigure`模块提供依赖项的`starter`模块,以及常用的库和其他附加依赖项.简单的说,添加`starter`模块应提供使用该库所需的一切.








