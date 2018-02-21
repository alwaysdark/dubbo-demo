package com.cncnc.api.consumer;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.cncnc.api.DubboInterface;

/**
 * @author tukangzheng
 */
public class ApiConsumerService {

    private static volatile ApiConsumerService consumerService = null;

    public DubboInterface dubboInterface = null;

    public static ApiConsumerService getInstance(){
        if (consumerService == null){
            synchronized (ApiConsumerService.class){
                if (consumerService == null){
                    consumerService = new ApiConsumerService();
                }
            }
        }
        return consumerService;
    }

    private ApiConsumerService(){
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("dubbo-api-consumer");

        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress("127.0.0.1:2181,127.0.0.1:2182,127.0.0.1:2183");

        ReferenceConfig<DubboInterface> referenceConfig = new ReferenceConfig<>();
        referenceConfig.setApplication(applicationConfig);
        referenceConfig.setRegistry(registryConfig);
        referenceConfig.setInterface(DubboInterface.class);
        referenceConfig.setVersion("1.0.0");

        dubboInterface = referenceConfig.get();
    }
}
