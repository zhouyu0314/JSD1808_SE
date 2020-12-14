package enumDemo;

import java.util.stream.Stream;

/**
 * 一、枚举类的使用
 * 1.枚举类的理解：类的对象只有有限个，确定的。我们称此类为枚举类
 * 2.当需要定义一组常量时，强烈建议使用枚举类
 * 3.如果枚举类中只有一个对象，则可以作为单例模式的实现方式
 * <p>
 * <p>
 * 二、如何定义枚举类
 * 方式一：jdk5.0之前，自定义枚举类
 * 方式二：jdk5.0，可以使用enum关键字定义枚举类
 * 使用enum定义的枚举类默认继承自java.lang.Enum
 * <p>
 * 三、Enum类中的常用方法
 * values():返回枚举类型的对象数组。该方法可以很方便的遍历所有的枚举值。
 * valuesOf(String str):可以把一个字符串转为对应的枚举类对象。要求字符串必须是枚举类对象的“名字”。若不是，会有运行时异常IllegalArgumentException
 * toString():返回当前枚举类对象常量的名称
 * 四、使用enum关键字定义的枚举类实现接口的情况
 * 情况一：实现接口，在enum类中实现抽象方法
 * 情况二：让枚举类的对象分别实现接口中的抽象方法
 */
public class Demo01 {
    public static void main(String[] args) {
        //测试自定义枚举类
        System.out.println("**********测试自定义枚举类*********");
        System.out.println(Season.SPRING.getSeasonName());//春天


        System.out.println("**********enum---toString()*********");
        //测试使用enum关键字创建的枚举类
        System.out.println(SeasonEnum.SPRING.toString());//SPRING
        /*
        values()
        SPRING
        SUMMER
        AUTUMN
        WINTER
         */
        System.out.println("**********enum---values()*********");
        Stream.of(SeasonEnum.values()).forEach(val -> System.out.println(val));


        //valueOf(String name)
        System.out.println("**********enum---valueOf(String name)*********");
        System.out.println(SeasonEnum.valueOf("SPRING"));//SPRING


        System.out.println("**********enum---getter/setter*********");
        System.out.println(SeasonEnum.SPRING.getSeasonName());//春天


        /**
         * 所有的枚举对象重写的方法都一样
         */
        System.out.println("**********enum---关于实现接口的情况一*********");
        SeasonEnum.SPRING.show();//这是一个美好的季节
        SeasonEnum.SUMMER.show();//这是一个美好的季节
        SeasonEnum.AUTUMN.show();//这是一个美好的季节
        SeasonEnum.WINTER.show();//这是一个美好的季节

        /**
         * 所有的枚举对象各自重写方法
         */
        System.out.println("**********enum---关于实现接口的情况二*********");
        SeasonEnum.SPRING.show();//春天是个美好的季节
        SeasonEnum.SUMMER.show();//夏天是个美好的季节
        SeasonEnum.AUTUMN.show();//秋天是个美好的季节
        SeasonEnum.WINTER.show();//冬天是个美好的季节
    }

}

interface Info {
    void show();
}

//使用enum关键字定义枚举类
enum SeasonEnum implements Info {

    //1.提供当前枚举类的对象，多个对象之间用逗号隔开末尾用分号结束
    SPRING("春天", "春暖花开") {
        @Override
        public void show() {
            System.out.println("春天是个美好的季节");
        }
    },

    SUMMER("夏天", "夏日炎炎") {
        @Override
        public void show() {
            System.out.println("夏天是个美好的季节");
        }
    },
    AUTUMN("秋天", "秋高气爽") {
        @Override
        public void show() {
            System.out.println("秋天是个美好的季节");
        }
    },
    WINTER("冬天", "银装素裹") {
        @Override
        public void show() {
            System.out.println("冬天是个美好的季节");
        }
    };


    //2.声明对象属性
    private final String seasonName;
    private final String seasonDesc;

    //3.私有化类的构造器，并给对象赋值
    private SeasonEnum(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    /**
     * 情况一：实现接口，在enum类中实现抽象方法
     */
    @Override
    public void show() {
        System.out.println("这是一个美好的季节");
    }
}


//自定义枚举类
class Season {
    //1.声明对象属性
    private final String seasonName;
    private final String seasonDesc;

    //2.私有化类的构造器，并给对象赋值
    private Season(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    //3.提供当前枚举类的多个对象
    public static final Season SPRING = new Season("春天", "春暖花开");
    public static final Season SUMMER = new Season("夏天", "夏日炎炎");
    public static final Season AUTUMN = new Season("秋天", "秋高气爽");
    public static final Season WINTER = new Season("冬天", "银装素裹");

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    @Override
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }
}
