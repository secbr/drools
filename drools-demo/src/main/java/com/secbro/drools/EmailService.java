package com.secbro.drools;

import com.secbro.drools.model.Message;

/**
 * Created by zhuzs on 2017/8/11.
 */
public class EmailService {

    public void sendEmail(Message message){
        System.out.println("Send message to email,the fired rule is '" + message.getRule()
                + "', and description  is '" + message.getDesc() + "'");
    }
}
