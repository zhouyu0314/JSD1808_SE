package annotataion;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

import static java.lang.annotation.ElementType.*;

/**
 * 自定义注解 参照@SuppressWarnings定义
 * 1.注解声明为@interface
 * 2.内部定义成员，通常使用value表示
 * 3.可以指定成员的默认值，使用default定义
 * 4.如果自定义注解没有成员，表明和是一个标识作用
 * <p>
 * 如果注解有成员，在使用注解时，需要指定成员的值
 * 通常会指明两个元注解：Retention、Target
 * <p>
 * jdk提供的4种元注解
 * Retention:指定所修饰的注解的生命周期 SOURCE/CLASS(默认)/RUNTIME
 * Target:用于指定被修饰的注解能用于修饰哪些程序元素
 * Documented：表示所修饰的注解在被javadoc解析时，保留下来
 */

public class Demo {
    public static void main(String[] args) {
        Class clazz = Demo.class;
        Method[] ms = clazz.getMethods();
        for (Method m : ms) {
            if (m.isAnnotationPresent(MyAnnotation.class)) {//如果此方法上有注解
                String value = m.getAnnotation(MyAnnotation.class).value();
                String name = m.getAnnotation(MyAnnotation.class).name();
                System.out.println(m.getName() + "\tvalue:" + value);
                System.out.println(m.getName() + "\tname:" + name);
            }
        }
    }

    @MyAnnotation
    public static void test1() {

    }

    @MyAnnotation(value = "world", name = "张三")
    public static void test2() {

    }

    @MyTest
    public static void test3() {
        System.out.println("test3执行了");
    }

    public static void test4() {
        System.out.println("test4执行了");
    }
}

class MyJunitRunner {
    public static void main(String[] args) throws Exception {
        //取得类的字节码
        Class clazz = Demo.class;
        //反射其中的成员，此处就是方法成员
        Method methods[] = clazz.getMethods();//得到DemoTest1中的所有公有的方法
        //看谁的上面有MyTest注解
        for (Method m : methods) {
            //谁有，就执行谁
            boolean b = m.isAnnotationPresent(MyTest.class);
            System.out.println(b + "===" + m.getName());
            if (b) {
                m.invoke(clazz.newInstance(), null);
            }
        }
    }
}


@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation {
    //String是类型，value是名字 默认值为hello
    String value() default "hello";

    String name() default "zhangsan";
}

@Target(METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface MyTest {

}
