package myProxy.staticProxy;

/**
 * 静态代理模式的缺点：
 * 1、假设一个系统中有100个Service，则需要创建100个代理对象
 * 2、如果一个Service中有很多方法需要事务（增强动作），发现代理对象的方法中还是有很多重复的代码
 * 3、由第一点和第二点可以得出：静态代理的重用性不强
 */
public class Run {
    public static void main(String[] args) {
        PersonServiceProxy personServiceProxy = new PersonServiceProxy();
        personServiceProxy.savePerson();
    }
}
