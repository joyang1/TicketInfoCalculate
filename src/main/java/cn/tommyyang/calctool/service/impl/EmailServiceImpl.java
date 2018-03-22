package cn.tommyyang.calctool.service.impl;

import cn.tommyyang.calctool.config.MailSenderInfo;
import cn.tommyyang.calctool.service.IEmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Date;
import java.util.Properties;

/**
 * Created by TommyYang on 2017/9/12.
 */
@Service
public class EmailServiceImpl implements IEmailService {

    private final static Logger logger = LoggerFactory.getLogger(EmailServiceImpl.class);


    @Override
    public void sendTextMail(MailSenderInfo mailSenderInfo) {
        Session session = this.getSession(mailSenderInfo);
        try {
            Message mailMessage = new MimeMessage(session);
            Address from = new InternetAddress(mailSenderInfo.getFromAddress());
            mailMessage.setFrom(from);
            if(mailSenderInfo.getToAddresses().contains("@") && mailSenderInfo.getToAddresses().contains("com")){
                mailMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mailSenderInfo.getToAddresses()));
            }
            if(mailSenderInfo.getCopytoAddresses().contains("@") && mailSenderInfo.getCopytoAddresses().contains("com")){
                mailMessage.setRecipients(Message.RecipientType.CC, InternetAddress.parse(mailSenderInfo.getCopytoAddresses()));
            }
            mailMessage.setSubject(mailSenderInfo.getSubject());
            mailMessage.setSentDate(new Date());
            mailMessage.setText(mailSenderInfo.getContent());
            Transport.send(mailMessage);
        }catch (MessagingException e){
            logger.error("send email error", e);
        }
    }

    @Override
    public void sendHtmlMail(MailSenderInfo mailSenderInfo) {
        Session session = this.getSession(mailSenderInfo);
        try {
            Message mailMessage = new MimeMessage(session);
            Address from = new InternetAddress(mailSenderInfo.getFromAddress());
            mailMessage.setFrom(from);
            if(mailSenderInfo.getToAddresses().contains("@") && mailSenderInfo.getToAddresses().contains("com")){
                mailMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mailSenderInfo.getToAddresses()));
            }
            if(mailSenderInfo.getCopytoAddresses().contains("@") && mailSenderInfo.getCopytoAddresses().contains("com")){
                mailMessage.setRecipients(Message.RecipientType.CC, InternetAddress.parse(mailSenderInfo.getCopytoAddresses()));
            }
            mailMessage.setSubject(mailSenderInfo.getSubject());
            mailMessage.setSentDate(new Date());
            Multipart mainPart = new MimeMultipart();
            BodyPart htmlBody = new MimeBodyPart();
            htmlBody.setContent(mailSenderInfo.getContent(), "text/html; charset=UTF-8");
            mainPart.addBodyPart(htmlBody);
            mailMessage.setContent(mainPart);
            System.setProperty("java.net.preferIPv4Stack", "true");
            Transport.send(mailMessage);
        }catch (Exception e){
            logger.error("send email error", e);
        }
    }

    private Session getSession(final MailSenderInfo mailSenderInfo) {
        Properties properties = mailSenderInfo.getProperties();
        Authenticator authenticator = null;
        if(mailSenderInfo.getValidate()){
            authenticator = new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(mailSenderInfo.getUserName(), mailSenderInfo.getPassword());
                }
            };
        }
        Session session = Session.getDefaultInstance(properties,authenticator);
        return session;
    }

    class SendEmailThread implements Runnable {
        private MailSenderInfo mailSenderInfo;

        public SendEmailThread(MailSenderInfo mailSenderInfo) {
            this.mailSenderInfo = mailSenderInfo;
        }

        @Override
        public void run() {
            try {
                if (this.mailSenderInfo != null) {
                    sendHtmlMail(mailSenderInfo);
                }
            } catch (Exception e) {
                logger.error("send email error", e);
            }
        }
    }

    @Override
    public void sendEmail(MailSenderInfo mailSenderInfo) {
        SendEmailThread thread = new SendEmailThread(mailSenderInfo);
        Thread t = new Thread(thread);
        t.start();
    }
}