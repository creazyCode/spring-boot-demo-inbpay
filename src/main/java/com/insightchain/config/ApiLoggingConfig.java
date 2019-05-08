package com.insightchain.config;

import com.insightchain.handler.ApiLoggingFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.ServletContextRequestLoggingFilter;

/**
*
* @description api log filter config
* @time 2019/1/21 4:18
* @author tianxiang@insightchain.io
*
*/
@Slf4j
@Configuration
public class ApiLoggingConfig {
    private static final int MAX_PAYLOAD_LENGTH = 10000;

    @Autowired
    private ApiLoggingFilter apiLoggingFilter;

    /**
     * @description logging filter config
     * @method requestLoggingFilter
     * @param []
     * @return
     * @time 2019/1/23
     * @author tianxiang@insightchain.io
     */
    @Bean
    public ServletContextRequestLoggingFilter requestLoggingFilter() {
        ServletContextRequestLoggingFilter loggingFilter = apiLoggingFilter;
        loggingFilter.setIncludeClientInfo(true);
        loggingFilter.setIncludeQueryString(true);
        loggingFilter.setIncludePayload(true);
        loggingFilter.setIncludeHeaders(true);
        loggingFilter.setBeforeMessagePrefix(Thread.currentThread().getId()+" -- "+Thread.currentThread().getName());
        loggingFilter.setMaxPayloadLength(MAX_PAYLOAD_LENGTH);
        return loggingFilter;
    }
}

