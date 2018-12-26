package com.jay.user.ribbon.client.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;
import java.util.Collections;

/**
 * 〈 编码形式的 Hystrix command 〉
 *
 * @author xsh
 * @date 2018/10/22
 * @since 1.0.0
 */
public class UserRibbonClientHystrixCommand extends HystrixCommand<Object> {

    private final String providerServiceName;

    private final RestTemplate restTemplate;

    public UserRibbonClientHystrixCommand(String providerServiceName, RestTemplate restTemplate) {
        super(HystrixCommandGroupKey.Factory.asKey(
                "User-Ribbon-Client"),
                100);
        this.providerServiceName = providerServiceName;
        this.restTemplate = restTemplate;
    }

    @Override
    protected Object run() throws Exception {
        return restTemplate.getForObject("http://" + providerServiceName + "/user/list", Collection.class);
    }

    /**
     * Fallback 实现
     *
     * @return 空集合
     */
    @Override
    protected Object getFallback() {
        return Collections.emptyList();
    }

}