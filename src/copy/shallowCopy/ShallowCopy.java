package copy.shallowCopy;

/**
 * 浅拷贝就是将源对象的属性值的精确拷贝一份
 * 如果属性是基本类型，拷贝的就是基本类型的值；如果属性是内存地址（引用类型），拷贝的就是内存地址
 * 对象拷贝没有生成新的对象，二者的对象地址是一样的；而浅拷贝的对象地址是不一样的,浅拷贝会生成对象。
 */
public class ShallowCopy {
    public static void main(String[] args) {
        Subject subject = new Subject("yuwen");
        Student studentA = new Student();
        studentA.setSubject(subject);
        studentA.setName("Lynn");
        studentA.setAge(20);
        Student studentB = (Student) studentA.clone();
        studentB.setName("Lily");
        studentB.setAge(18);
        System.out.println("studentA:" + studentA.toString());//studentA:[Student: 460141958,subject:[Subject: 1163157884,name:yuwen],name:Lynn,age:20]
        System.out.println("studentB:" + studentB.toString());//studentB:[Student: 1956725890,subject:[Subject: 1163157884,name:yuwen],name:Lily,age:18]
        /*
        当对象的属性中的引用类型发生改变，因为是内存地址，所以源对象的引用类型属性也会发生改变
         */
        Subject subjectB = studentB.getSubject();
        subjectB.setName("lishi");
        System.out.println("studentA:" + studentA.toString());//studentA:[Student: 460141958,subject:[Subject: 1163157884,name:lishi],name:Lynn,age:20]
        System.out.println("studentB:" + studentB.toString());//studentB:[Student: 1956725890,subject:[Subject: 1163157884,name:lishi],name:Lily,age:18]

    }
}