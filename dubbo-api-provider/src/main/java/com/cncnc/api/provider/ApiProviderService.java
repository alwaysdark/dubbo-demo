package com.cncnc.api.provider;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.ServiceConfig;
import com.cncnc.api.DubboInterface;

/**
 * @author tukangzheng
 */
public class ApiProviderService {

    private static volatile ApiProviderService service = null;

    /**
     * 双重检锁的单例模式（防止重复创建多个实例化对象）
     */
    public static ApiProviderService getInstance(){
        if (service == null){
            synchronized (ApiProviderService.class){
                if (service == null){
                    service = new ApiProviderService();
                }
            }
        }
        return service;
    }



    private ApiProviderService(){
        DubboInterface dubboInterface = new DubboInterfaceImpl();

        // 当前的应用配置
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("dubbo-api-provider");

        // 连接注册中心配置
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress("127.0.0.1:2181,127.0.0.1:2182,127.0.0.1:2183");

        // 服务提供者协议配置
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName("dubbo");
        protocolConfig.setPort(20880);
        protocolConfig.setThreads(10);

        // 服务提供者暴露
        ServiceConfig<DubboInterface> serviceConfig = new ServiceConfig<DubboInterface>();
        serviceConfig.setApplication(applicationConfig);
        serviceConfig.setRegistry(registryConfig);
        serviceConfig.setProtocol(protocolConfig);
        serviceConfig.setInterface(DubboInterface.class);
        serviceConfig.setRef(dubboInterface);
        serviceConfig.setVersion("1.0.0");

        // 暴露及注册服务
        serviceConfig.export();
    }
}
