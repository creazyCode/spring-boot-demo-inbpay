package com.insightchain.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.ServletContextRequestLoggingFilter;

import javax.servlet.http.HttpServletRequest;

/**
*
* @description api log handler
* @time 2019/1/21 4:19
* @author tianxiang@insightchain.io
*
*/
@Slf4j
@Component
public class ApiLoggingFilter extends ServletContextRequestLoggingFilter {

        @Override
        protected void beforeRequest(HttpServletRequest request, String message) {
                this.getServletContext().log(message);
        }

        @Override
        protected void afterRequest(HttpServletRequest request, String message) {
            super.afterRequest(request, message);
        }
}
