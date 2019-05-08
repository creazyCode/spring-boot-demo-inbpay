package com.insightchain.common.constants;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
*
* @description  properties constants
* @time 2019/1/21 3:56
* @author tianxiang@insightchain.io
*
*/
@Configuration
public class PropertiesConstant {

    public static Boolean IS_DEBUG;

    public static Boolean IS_USE_CACHE;

    public static Boolean IS_REQUEST_ENCRYPT;

    public static Boolean IS_USE_MQ;


    @Value("${system.config.isDebug}")
    public void setIsDebug(Boolean isDebug) {
        IS_DEBUG = isDebug;
    }

    @Value("${system.config.isMqUse}")
    public void setIsUseMq(Boolean isUseMq) {
        IS_USE_MQ = isUseMq;
    }

    @Value("${system.config.isCacheUse}")
    public void setIsUseCache(Boolean isUseCache) {
        IS_USE_CACHE = isUseCache;
    }

    @Value("${system.config.isRequestEncrypt}")
    public void setIsRequestEncrypt(Boolean isRequestEncrypt) {
        IS_REQUEST_ENCRYPT = isRequestEncrypt;
    }
}
