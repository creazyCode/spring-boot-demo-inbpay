package com.insightchain.service.common.impl;

import com.insightchain.dao.repository.IAccountFlowsRepository;
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
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserRepository userRepository;

}
