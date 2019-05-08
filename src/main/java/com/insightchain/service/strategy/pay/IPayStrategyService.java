package com.insightchain.service.strategy.pay;

import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.InitializingBean;

/**
*
* @description 支付 策略类
* @time 2019/5/7 16:39
* @author tianxiang@insightchain.io
*
*/
public interface IPayStrategyService  {


    /**
     *  pay for insight
     */
    void pay();
}
