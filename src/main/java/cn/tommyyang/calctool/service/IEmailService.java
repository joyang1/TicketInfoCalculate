package cn.tommyyang.calctool.service;


import cn.tommyyang.calctool.config.MailSenderInfo;

/**
 * Created by TommyYang on 2017/9/12.
 */
public interface IEmailService {

    void sendTextMail(MailSenderInfo mailSenderInfo);

    void sendHtmlMail(MailSenderInfo mailSenderInfo);

    void sendEmail(MailSenderInfo mailSenderInfo);
}
