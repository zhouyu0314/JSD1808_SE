package myProxy.jdkDynamicProxy;

import java.lang.reflect.Proxy;

public class Run {
    public static void main(String[] args) {
        Object target = new PersonServiceImpl();
        MyTransaction myTransaction = new MyTransaction();
        PersonServiceInterceptor interceptor = new PersonServiceInterceptor(target, myTransaction);
        PersonService personService = (PersonService) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),interceptor);
        String returnValue = personService.savePerson();
        System.out.println(returnValue);
    }

}
