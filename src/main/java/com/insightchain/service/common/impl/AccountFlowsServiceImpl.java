package com.insightchain.service.common.impl;

import com.insightchain.dao.domain.AccountFlows;
import com.insightchain.dao.repository.IAccountFlowsRepository;
import com.insightchain.service.common.IAccountFlowsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

/**
*
* @description
* @time 2019/5/6 10:28
* @author tianxiang@insightchain.io
*
*/
@Service
@Slf4j
public class AccountFlowsServiceImpl implements IAccountFlowsService {

    @Autowired
    private IAccountFlowsRepository accountFlowsRepository;

    public void addAccountFlow(){

    }

    public void insert(Long orderId, Long fromUserId, Long toUserId, Double coinNumber, Integer type, String symbol){
        AccountFlows accountFlows = new AccountFlows();
        accountFlows.setOrderId(orderId);
        accountFlows.setFromUserId(fromUserId);
        accountFlows.setToUserId(toUserId);
        accountFlows.setCoinNumber(coinNumber);
        accountFlows.setType(type);

        Timestamp now = new Timestamp(System.currentTimeMillis());
        accountFlows.setTime(now);
        accountFlows.setCreatedTime(now);
        accountFlows.setUpdatedTime(now);
        accountFlowsRepository.save(accountFlows);
    }
}
