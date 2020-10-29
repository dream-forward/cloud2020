package com.athuayu.springcloud.controller;
/*
 *@author Leelay
 *@date 2020/10/2918:54
 *@Description:
 */

import com.athuayu.springcloud.service.IMessageProvider;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
@RestController
public class SendMessageController {
    @Resource
    private IMessageProvider messageProvider;

    @RequestMapping("/sendMessage")
    public String sendMessage() {
        String send = messageProvider.send();
        return send;
    }
}
