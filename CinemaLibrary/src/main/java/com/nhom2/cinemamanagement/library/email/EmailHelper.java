package com.nhom2.cinemamanagement.library.email;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

public class EmailHelper {

    public static void sendEmail(JavaMailSender javaMailSender, String from, String to, String subject, String message) {

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(from);
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(message);

        javaMailSender.send(simpleMailMessage);
    }

    public static void sendHTMLEmail(JavaMailSender javaMailSender, String from, String to, String subject, String message) throws MessagingException {

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
        helper.setSubject(subject);
        helper.setFrom(from);
        helper.setTo(to);
        helper.setText("<h1>Green Academy Cinema</<h1>" + message);

        javaMailSender.send(mimeMessage);
    }
}
