package annotataion;

import org.omg.SendingContext.RunTime;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.LOCAL_VARIABLE;

/**
 * 自定义注解 参照@SuppressWarnings定义
 * 1.注解声明为@interface
 * 2.内部定义成员，通常使用value表示
 * 3.可以指定成员的默认值，使用default定义
 * 4.如果自定义注解没有成员，表明和是一个标识作用
 *
 * 如果注解有成员，在使用注解时，需要指定成员的值
 * 通常会指明两个元注解：Retention、Target
 *
 * jdk提供的4种元注解
 * Retention:指定所修饰的注解的生命周期 SOURCE/CLASS(默认)/RUNTIME
 * Target:用于指定被修饰的注解能用于修饰哪些程序元素
 * Documented：表示所修饰的注解在被javadoc解析时，保留下来
 *
 */
@MyAnnotation()
public class Demo {
    public static void main(String[] args) {

    }
}

@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation{
    //String是类型，value是名字 默认值为hello
    String value() default "hello";
}
