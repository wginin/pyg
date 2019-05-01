package dynamicProxy;

/**
 * @description: 金莲类
 * @author: wginin
 * @date: 2019-04-23 00:22
 **/

public class JinlianPan implements KindWoman {
    @Override
    public void happyWithMan() {
        System.out.println("金莲正在happy....");
    }

    @Override
    public double collect(double money) {
        return money;
    }
}
