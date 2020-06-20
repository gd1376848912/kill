package com.debug.kill.server.service;

import com.debug.kill.model.entity.Mail;
import com.debug.kill.model.entity.OrderInfo;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

@Component
@EnableAsync
public class ReceiveService {


    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private ItemKillSuccessService itemKillSuccessService;

    @Autowired
    private Environment env;

    @RabbitHandler
    @RabbitListener(queues = "MailMq")
    public void getMsg(OrderInfo result){
        System.out.println(result);
        final String content=String.format(env.getProperty("mail.kill.item.success.content"),result.getItemName(),result.getCode());
        Mail mail = new Mail(env.getProperty("mail.kill.item.success.subject"),content,new String[]{result.getEmail()});
        sendMail(mail);
    }

    @Async
    public void sendMail(final Mail mail){
        try{
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setFrom(env.getProperty("mail.send.from"));
            simpleMailMessage.setSubject(mail.getSubject());
            simpleMailMessage.setTo(mail.getReceiver());
            simpleMailMessage.setText(mail.getContent());
            javaMailSender.send(simpleMailMessage);
        }catch ( Exception e){
            System.out.println("异常----------MailService");
        }
    }

    @RabbitListener(queues="kill.dead.real")
    public void orderExpire(OrderInfo orderInfo){
        if(orderInfo != null){
            if(itemKillSuccessService.queryById(orderInfo.getCode()) != null){
                itemKillSuccessService.expireOrder(orderInfo.getCode());
            }
        }
    }
}
