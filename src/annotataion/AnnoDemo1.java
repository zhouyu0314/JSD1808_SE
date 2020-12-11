package annotataion;

import java.lang.annotation.Annotation;

@TestAnnotation(id = 1,title = "测试注解",value = "测试值")
public class AnnoDemo1 {
    public static void main(String[] args) {
        //判断它是否应用了TestAnnotation注解
        if (AnnoDemo1.class.isAnnotationPresent(TestAnnotation.class)) {
            //获取此注解对象
            TestAnnotation annotation = AnnoDemo1.class.getAnnotation(TestAnnotation.class);
            System.out.println(annotation.id());//1
            System.out.println(annotation.title());//测试注解
            System.out.println(annotation.value());//测试值

            //获取此类上的所有注解
            Annotation[] annotations = AnnoDemo1.class.getAnnotations();

        }
    }
}
