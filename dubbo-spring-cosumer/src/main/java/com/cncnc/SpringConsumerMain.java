package com.cncnc;


import com.cncnc.api.DubboInterface;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author tukangzheng
 */
public class SpringConsumerMain {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"consumer.xml"});

        context.start();

        DubboInterface dubboInterface = (DubboInterface)context.getBean("dubboInterface");

        System.out.println(dubboInterface.getInterData("dubbo-spring"));
    }
}
