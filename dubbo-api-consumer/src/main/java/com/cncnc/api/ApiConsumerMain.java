package com.cncnc.api;


import com.cncnc.api.consumer.ApiConsumerService;

/**
 * @author tukangzheng
 */
public class ApiConsumerMain {

    public static void main(String[] args) {
        String str = ApiConsumerService.getInstance().dubboInterface.getInterData("lisi");
        System.out.println(str);
    }
}
