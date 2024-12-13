package kirill.app.mail.controller;

import kirill.app.mail.models.Mail;
import kirill.app.mail.services.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    private MailService mailService;

    @Autowired
    public MainController(MailService mailService){
        this.mailService = mailService;
    }

    @RequestMapping("/")
    public String mainPage(){
        return "index";
    }

    @PostMapping("/send")
    @ResponseBody
    public ResponseEntity<String> sendMail(@RequestBody Mail mail){
        try {
            mailService.sendMail(mail);
            return ResponseEntity.ok("Письмо успешно отправлено");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Ошибка при отправке письма: " + e.getMessage());
        }
    }

}
