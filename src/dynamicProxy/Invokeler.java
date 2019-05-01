package dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @description: 代理类
 * @author: wginin
 * @date: 2019-04-23 00:24
 **/

public class Invokeler implements InvocationHandler {
    private Object target;




    public Invokeler(Object target) {
       super();
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //此处的三个参数:第一个proxy指的是生成的动态代理对象
        //第二个参数method是被调用的方法
        //第三个参数是调用该方法传入的参数
        String methodName = method.getName();
        if ("happyWithMan".equals(methodName)) {
            openHours();
            method.invoke(target, args);
            return null;
        } else if ("collect".equals(methodName)){
            //如果方法是collect(),则扣除40%的手续费
            double money = (double) method.invoke(target, args);
            System.out.println("平台收取40%的手续费，共计:"+money*0.4+"元");
            return money*0.6;
        }

        return method.invoke(target, args);

    }

    public void openHours(){

        System.out.println("以做衣服的名义把两人安排到已开好的房间里。。。");
    }
}
