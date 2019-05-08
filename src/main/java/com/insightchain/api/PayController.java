package com.insightchain.api;


import com.insightchain.service.common.IAccountFlowsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
*
* @description
* @time 2019/5/5 22:04
* @author tianxiang@insightchain.io
*
*/
@RestController
@RequestMapping("/account")
public class PayController {

    @Autowired
    private IAccountFlowsService accountFlowsService;

    /*@PostMapping("/flow/add")
    public ResponseObject setQuestionnaire() {
        return ResponseObject.getSuccessfulResponseObject(result);
    }*/
}
