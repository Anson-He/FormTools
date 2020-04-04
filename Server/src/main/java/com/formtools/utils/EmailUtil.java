package com.formtools.utils;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailUtil {

    //发件人邮箱,授权码(可以在邮箱设置中获取到授权码的信息)
    private static final String myEmail="nanrailgun@163.com";

    private static final String myPassword="lzn422780767666";

    /**
     * 发送邮件
     * @param email 收件人邮箱
     * @param code 待发送验证码
     * @return 成功返回true
     * @throws MessagingException 失败抛出异常
     */
    public static boolean SendEmail(String email,String code) throws MessagingException {

        Properties props = new Properties();
        props.setProperty("mail.smtp.auth", "true");
        props.setProperty("mail.transport.protocol", "smtp");
        props.put("mail.smtp.host","smtp.163.com");// smtp服务器地址

        Session session = Session.getInstance(props);
        //debug模式
        session.setDebug(false);

        Message msg = new MimeMessage(session);
        //标题
        msg.setSubject("表单工具邮箱验证"+code);
        //正文
        msg.setContent("验证码："+code, "text/html;charset=UTF-8");
        msg.setFrom(new InternetAddress(myEmail));//发件人邮箱(我的163邮箱)
        msg.setRecipient(Message.RecipientType.TO,
                new InternetAddress(email)); //收件人邮箱
        msg.saveChanges();

        Transport transport = session.getTransport();
        transport.connect(myEmail,myPassword);//发件人邮箱,授权码(可以在邮箱设置中获取到授权码的信息)

        transport.sendMessage(msg, msg.getAllRecipients());

        transport.close();

        return true;
    }
}
