package dynamicProxy;

import java.lang.reflect.Proxy;

/**
 * @description:
 * @author: wginin
 * @date: 2019-04-23 00:43
 **/

public class QingXImen {
    public static void main(String[] args) {
        JinlianPan pan = new JinlianPan();

        Invokeler ik = new Invokeler(pan);
        //调用newProxyInstance()方法动态创建代理对象，代理对象类必定跟委托类实现了相同的接口
        //该方法第一个参数是类加载器,第二个参数是委托类实现的所有接口(使用委托类的字节码文件对象.getInterfaces()方法获取)
        KindWoman women = (KindWoman) Proxy.newProxyInstance(QingXImen.class.getClassLoader(), JinlianPan.class.getInterfaces(), ik);
        //代理对象调用任意方法，都会调用到InvocationHandler的实现类对象的invoke方法

        //通过代理对象调用金莲的happyWithMan()方法
         women.happyWithMan();
        double collect = women.collect(2000);
        System.out.println("金莲拿到啦"+collect);
    }

}
