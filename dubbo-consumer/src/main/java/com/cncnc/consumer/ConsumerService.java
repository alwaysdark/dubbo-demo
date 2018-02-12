package com.cncnc.consumer;

import com.alibaba.dubbo.config.annotation.Reference;
import com.cncnc.api.DubboInterface;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2018/2/12.
 */
@Component
public class ConsumerService {

    @Reference
    public DubboInterface dubboInterface;

}
