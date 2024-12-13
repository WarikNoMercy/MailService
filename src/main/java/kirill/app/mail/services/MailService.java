package kirill.app.mail.services;

import kirill.app.mail.models.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String mailSend;

    @Autowired
    public MailService(JavaMailSender mailSender){
        this.mailSender = mailSender;
    }

    public void sendMail(Mail mail){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(mailSend);
        message.setTo(mail.getReciever());
        message.setText(mail.getContent());
        message.setSubject(mail.getSubject());

        mailSender.send(message);
    }
}
