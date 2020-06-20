package com.debug.kill.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Mail {
    //主题
    private String subject;
    //内容
    private String content;
    //收件人
    private String[] receiver;
}
