package com.insightchain.service.biz;

import com.insightchain.common.domain.resp.ResponseObject;
import com.insightchain.dao.repository.IUserRepository;
import com.insightchain.service.common.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
*
* @description
* @time 2019/5/6 10:28
* @author tianxiang@insightchain.io
*
*/
@Service
@Slf4j
public class PayService {

    @Autowired
    private IUserService userService;

    public ResponseObject pay(){
        /**
         *  参数校验：用户是否存在，余额是否充足、订单是否已支付，
         */
        //根据支付方式调用实现类
        //返回结果
        return null;
    }
}
