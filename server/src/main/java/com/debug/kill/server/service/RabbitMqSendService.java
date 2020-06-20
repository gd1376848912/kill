package com.debug.kill.server.service;

import com.debug.kill.model.entity.ItemKillVO;
import com.debug.kill.model.entity.OrderInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.AbstractJavaTypeMapper;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class RabbitMqSendService {

    @Autowired
    private ItemKillSuccessService itemKillSuccessService;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Autowired
    private Environment env;

    public void sendKillSuccessMsg(String orderNo){
        //设置发送的格式
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
        //设置交换机
        rabbitTemplate.setExchange(env.getProperty("mq.kill.item.success.email.exchange"));
        //设置route
        rabbitTemplate.setRoutingKey(env.getProperty("mq.kill.item.success.email.exchange"));
        ItemKillVO itemKillVO = new ItemKillVO();
        itemKillVO.setId(1);
        rabbitTemplate.convertAndSend((Object) orderNo, new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) throws AmqpException {
                MessageProperties messageProperties = message.getMessageProperties();
                messageProperties.setDeliveryMode(MessageDeliveryMode.PERSISTENT);
                messageProperties.setHeader(AbstractJavaTypeMapper.DEFAULT_KEY_CLASSID_FIELD_NAME,ItemKillVO.class);
                return message;
            }
        });
    }

    /**
     * rabbitmq 发送消息
     *
     */
    public void sendMsg(String orderNo){
        OrderInfo result = itemKillSuccessService.queryById(orderNo);
        amqpTemplate.convertAndSend("MailMq",result);
    }


    public void sendDeadMsg(String orderNo){
        try {
            if (StringUtils.isNotBlank(orderNo)){
                OrderInfo info= itemKillSuccessService.queryById(orderNo);
                if (info!=null){
                    rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
                    rabbitTemplate.setExchange("kill.dead.real.exchange");
                    rabbitTemplate.setRoutingKey("kill.dead.real.routing");
                    rabbitTemplate.convertAndSend(info, new MessagePostProcessor() {
                        @Override
                        public Message postProcessMessage(Message message) throws AmqpException {
                            MessageProperties mp=message.getMessageProperties();
                            mp.setDeliveryMode(MessageDeliveryMode.PERSISTENT);
                            mp.setHeader(AbstractJavaTypeMapper.DEFAULT_CONTENT_CLASSID_FIELD_NAME,OrderInfo.class);

                            //TODO：动态设置TTL(为了测试方便，暂且设置10s)
                            mp.setExpiration("10000");
                            return message;
                        }
                    });
                }
            }
        }catch (Exception e){
            System.out.println("秒杀成功后生成抢购订单-发送信息入死信队列，等待着一定时间失效超时未支付的订单-发生异常，消息为：{}"+orderNo);
        }
    }
}
