package annotataion;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * target 设置注解的目标：类，成员变量，方法，参数。。。
 * @Target({}) 设置多个
 *
 * @Retention保留范围 源码 字节码文件 运行期内存
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface TestAnnotation {
    //属性如果不指定默认值，使用时，就必须赋值
    int id() default 0;
    String title() default "";
    /*
    有一个特殊的属性名value，它有特殊待遇，
    单独赋值时，可以只写值，不用写value=

    经常设置value作为其他属性的别名，
    这里把value当作title的别名来使用。
     */
    String value() default "";


}
