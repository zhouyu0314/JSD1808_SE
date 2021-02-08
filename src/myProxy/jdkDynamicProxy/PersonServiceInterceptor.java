package myProxy.jdkDynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 1、当客户端执行代理对象.方法时，进入到了拦截器的invoke方法体
 * 2、拦截器中invoke方法体的内容就是代理对象方法体的内容
 * 3、拦截器中invoke方法的method参数是在调用的时候赋值的
 */
public class PersonServiceInterceptor implements InvocationHandler {
    //目标类
    private Object target;
    //增强类
    private MyTransaction myTransaction;

    //构造函数注入目标类和增强类
	public PersonServiceInterceptor(Object target,MyTransaction myTransaction){
		this.target = target;
		this.myTransaction = myTransaction;
	}

    //代理类的每一个方法被调用的时候都会调用下边的这个invoke方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        this.myTransaction.beginTransaction();
        Object returnValue = method.invoke(this.target, args);
        this.myTransaction.commit();
        return returnValue;
    }

}