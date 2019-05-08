package com.insightchain.service.strategy.pay;

import org.springframework.stereotype.Component;

/**
*
* @description 支付策略 环境类
* @time 2019/5/7 16:38
* @author tianxiang@insightchain.io
*
*/

public class PayStrategyContext {

    private IPayStrategyService payStrategyService;

    public IPayStrategyService getPayStrategyService() {
        return payStrategyService;
    }

    public void setPayStrategyService(IPayStrategyService payStrategyService) {
        this.payStrategyService = payStrategyService;
    }

    public void pay(String symbol){

        payStrategyService.pay(); //支付

    }
}
