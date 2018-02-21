package com.cncnc.service;

import com.cncnc.api.DubboInterface;


/**
 * @author tukangzheng
 */
public class DubboInterfaceImpl implements DubboInterface{

    @Override
    public String getInterData(String name) {
        return "Hello " + name + ", Dubbo Spring Test!";
    }
}
