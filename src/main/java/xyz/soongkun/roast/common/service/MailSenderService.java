package xyz.soongkun.roast.common.service;import java.io.UnsupportedEncodingException;import javax.mail.MessagingException;import javax.mail.internet.MimeMessage;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.mail.javamail.JavaMailSenderImpl;import org.springframework.mail.javamail.MimeMessageHelper;import org.springframework.stereotype.Service;import xyz.soongkun.roast.common.config.Global;import xyz.soongkun.roast.common.model.MailBean;@Servicepublic class MailSenderService {    @Autowired    private JavaMailSenderImpl javaMailSenderImpl;    public MailSenderService() {    }    public MimeMessage createMimeMessage(MailBean mailBean) throws MessagingException, UnsupportedEncodingException {        MimeMessage mimeMessage = this.javaMailSenderImpl.createMimeMessage();        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");        messageHelper.setFrom(Global.getConfig("mail.from"), Global.getConfig("mail.fromName"));        messageHelper.setSubject(mailBean.getSubject());        messageHelper.setCc(Global.getConfig("mail.from"));        messageHelper.setTo(mailBean.getToEmails());        messageHelper.setText(mailBean.getContext(), true);        return mimeMessage;    }    public void sendMail(MailBean mailBean) throws UnsupportedEncodingException, MessagingException {        MimeMessage msg = this.createMimeMessage(mailBean);        this.javaMailSenderImpl.send(msg);    }}