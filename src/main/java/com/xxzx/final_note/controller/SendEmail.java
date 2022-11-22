package com.xxzx.final_note.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Random;

@Controller
@RequestMapping("/email")
public class SendEmail {

    @Resource
    private JavaMailSender javaMailSender;

    //读取yml文件中username的值并赋值给form
    @Value("${spring.mail.username}")
    private String from;

    @RequestMapping("/sendEmail")
    public String sendSimpleMail(@RequestParam(value = "emailReceiver") String emailReceiver,
                                 HttpServletRequest request) {
        HttpSession session =  request.getSession();

        // 构建一个邮件对象
        SimpleMailMessage message = new SimpleMailMessage();
        // 设置邮件发送者
        message.setFrom(from);
        // 设置邮件接收者
        message.setTo(emailReceiver);
        // 设置邮件的主题
        message.setSubject("登录验证码");
        // 设置邮件的正文
        Random random = new Random();
        StringBuilder code = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            int r = random.nextInt(10);
            code.append(r);
        }
        String text = "您的验证码为：" + code + ",请勿泄露给他人。";
        message.setText(text);
        // 把验证码存入session
        session.setAttribute("code", code);
//        System.out.println("code="+session.getAttribute("code"));
        // 发送邮件
        try {
            javaMailSender.send(message);
            return "redirect:/user/login";
        } catch (MailException e) {
            e.printStackTrace();
        }
        return "redirect:/user/login";
    }
}
