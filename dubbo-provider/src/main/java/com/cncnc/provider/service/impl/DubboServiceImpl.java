package com.cncnc.provider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.cncnc.api.DubboInterface;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2018/2/12.
 */
@Component
@Service(interfaceClass = DubboInterface.class)
public class DubboServiceImpl implements DubboInterface{

    @Override
    public String getInterData(String name) {
        return "Hello " + name;
    }
}
