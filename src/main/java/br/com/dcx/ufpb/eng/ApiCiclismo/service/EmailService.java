package br.com.dcx.ufpb.eng.ApiCiclismo.service;

import br.com.dcx.ufpb.eng.ApiCiclismo.entity.EmailModel;
import br.com.dcx.ufpb.eng.ApiCiclismo.entity.User;
import br.com.dcx.ufpb.eng.ApiCiclismo.enums.StatusEmail;
import br.com.dcx.ufpb.eng.ApiCiclismo.repositories.EmailRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;


@Service
public class EmailService {
    @Autowired
    EmailRepository emailRepository;

    @Autowired
    private JavaMailSender emailSender;

    @Transactional
    public EmailModel sendEmail(EmailModel emailModel, User user) {
        emailModel.setSendDateEmail(LocalDateTime.now());

        try{
            SimpleMailMessage message = new SimpleMailMessage();
            emailModel.setStatusEmail(StatusEmail.SENT);
            message.setFrom("ciclismocamelo@gmail.com");
            message.setTo(user.getEmail());
            message.setSubject("Bem Vindo ao Camelo :) ");
            message.setText("Bem vindo  " + user.getEmail() + " ao Camelo! espero que voce possa ter uma boa experiencia! e otimas pedaladas! ");
            message.setSentDate(new Date());
            emailSender.send(message);

        } catch (MailException e){
            emailModel.setStatusEmail(StatusEmail.ERROR);
        } finally {
            return emailRepository.save(emailModel);
        }
    }


    public Page<EmailModel> findAll(Pageable pageable) {
        return  emailRepository.findAll(pageable);
    }

    public Optional<EmailModel> findById(Long emailId) {
        return emailRepository.findById(emailId);
    }
}
