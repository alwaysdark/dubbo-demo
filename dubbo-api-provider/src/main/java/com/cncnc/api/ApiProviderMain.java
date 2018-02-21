package com.cncnc.api;


import com.cncnc.api.provider.ApiProviderService;

/**
 * @author tukangzheng
 */
public class ApiProviderMain {


    public static void main(String[] args) {
        // 双重检锁  单例模式
        ApiProviderService.getInstance();
    }
}
