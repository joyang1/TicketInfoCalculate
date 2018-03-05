package cn.tommyyang.calctool.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * Created by tommyyang on 2017/9/12.
 */

@Configuration
public class MailSenderInfo {

    @Value("${email.mailServerHost}")
    private String mailServerHost;

    @Value("${email.mailServerPort}")
    private String mailServerPort;

    @Value("${email.mailProtocol}")
    private String mailProtocol;

    @Value("${email.fromAddress}")
    private String fromAddress;
    private String[] toAddresses;
    private String[] copytoAddresses;
    private String[] attachFileNames;

    @Value("${email.userName}")
    private String userName;

    @Value("${email.password}")
    private String password;

    @Value("${email.isValidate}")
    private Boolean isValidate;

    private String subject;
    private String content;

    public Properties getProperties(){
        Properties p = new Properties();
        p.put("mail.smtp.host", this.mailServerHost);
        p.put("mail.smtp.port", this.mailServerPort);
        p.put("mail.transport.protocol", this.mailProtocol);
        p.put("mail.smtp.auth", isValidate ? "true" : "false");
        return p;
    }

    public String getMailServerHost() {
        return mailServerHost;
    }

    public void setMailServerHost(String mailServerHost) {
        this.mailServerHost = mailServerHost;
    }

    public String getMailServerPort() {
        return mailServerPort;
    }

    public void setMailServerPort(String mailServerPort) {
        this.mailServerPort = mailServerPort;
    }

    public String getMailProtocol() {
        return mailProtocol;
    }

    public void setMailProtocol(String mailProtocol) {
        this.mailProtocol = mailProtocol;
    }

    public String getFromAddress() {
        return fromAddress;
    }

    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }

    public String[] getToAddresses() {
        return toAddresses;
    }

    public void setToAddresses(String[] toAddresses) {
        this.toAddresses = toAddresses;
    }

    public String[] getCopytoAddresses() {
        return copytoAddresses;
    }

    public void setCopytoAddresses(String[] copytoAddresses) {
        this.copytoAddresses = copytoAddresses;
    }

    public String[] getAttachFileNames() {
        return attachFileNames;
    }

    public void setAttachFileNames(String[] attachFileNames) {
        this.attachFileNames = attachFileNames;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getValidate() {
        return isValidate;
    }

    public void setValidate(Boolean validate) {
        isValidate = validate;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
