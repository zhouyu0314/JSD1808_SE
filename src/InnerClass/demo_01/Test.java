package InnerClass.demo_01;

/**
 * 每个内部类都能独立地继承一个（接口的）实现，
 * 所以无论外围类是否已经继承了某个（接口的）实现，对于内部类都没有影响。
 */
public class Test extends F1 {

    @Override
    public void a1() {

    }


    class Test01 extends F2{

        @Override
        public void a2() {

        }
    }
}
