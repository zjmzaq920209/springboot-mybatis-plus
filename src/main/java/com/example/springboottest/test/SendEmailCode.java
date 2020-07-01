package com.example.springboottest.test;

import java.util.Properties;
import javax.mail.Address;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * @PackageName: com.example.springboottest.test
 * @className: SendEmailCode
 * @Description:
 * @Author: Jingmeng
 * @Date: 2020/4/20 12:11
 **/
public class SendEmailCode {

  public static boolean sendEmail(String emailAddress, String emailMsg) {
    //发送方
    String from = "zjmzaq920209@163.com";
    //发送目标
    String to = emailAddress;

    //发送方的用户名密码，用以登陆
    final String userName = "zjmzaq920209@163.com";
    final String passWord = "455341405za";

    Properties properties = new Properties();

    /*
     * mail.smtp.host ：指定连接的邮件服务器的主机名。如：163邮箱就填写smtp.163.com
     * 若在本地测试的话，需要在本地安装smtp服务器
     */
    properties.setProperty("mail.smtp.host", "smtp.163.com");

    // mail.smtp.auth：指定客户端是否要向邮件服务器提交验证
    properties.setProperty("mail.smtp.auth", "true");

    /*
     * mail.transport.protocol：指定邮件发送协议：smtp。smtp：发邮件；pop3：收邮件
     * mail.store.protocol:指定邮件接收协议
     */
    properties.setProperty("mail.transport.protocol", "smtp");

    // 获取session对象
    Session session = Session.getInstance(properties);

    // 当设置为true，JavaMail AP就会将其运行过程和邮件服务器的交互命令信息输出到console中，用于JavaMail的调试
    session.setDebug(true);
    try {

      // 创建邮件对象
      MimeMessage message = new MimeMessage(session);

      // 设置邮件发送方
      message.setFrom(new InternetAddress(from,"问道客服","UTF-8"));

      // 设置邮件发送的主题<邮件标题>
      message.setSubject("测试邮件");
      String bodyText = "<font size =\"100\" face=\"宋体\" color = \"red\">这是宋体</font>";
      // 设置邮件发送的内容
      message.setContent(bodyText,"text/html;charset=utf-8");
      Transport transport=session.getTransport();

      // 连接邮件服务器，“”中填写邮件服务器主机名
      transport.connect("smtp.163.com",25, userName, passWord);
      transport.sendMessage(message,new Address[]{new InternetAddress(to)});
      transport.close();
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }

  }

  public static void main(String[] args) {
    sendEmail("455341405@qq.com","这是一段测试代码");
  }

}
