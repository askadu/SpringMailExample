/*
 *  2014 Roza Infotech Inc. 

 */
package com.rozainfotech.serviceimpl;

import com.rozainfotech.service.MailService;
import java.io.StringWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.ParseErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

/**
 *
 * @author Akshay Kadu <akshay@rozainfotech.com>
 */
@Service("mailService")
public class MailServiceImpl implements MailService{

    @Autowired
    private MailSender mailSender;
    
    @Autowired
    private SimpleMailMessage templateMessage;
    
    @Autowired 
    private VelocityEngine velocityEngine;

    /**
     *
     */
    @Override
    public void sendMessage() {
        try {
            SimpleMailMessage msg = new SimpleMailMessage(templateMessage);
            msg.setTo("akshay.kadu@blobcity.com");
            
            Template template = velocityEngine.getTemplate("./templates/newyear.vm");
            
            VelocityContext velocityContext = new VelocityContext();
            velocityContext.put("firstName", "Akshay");
            velocityContext.put("lastName", "Kadu");
            velocityContext.put("location", "INDIA");
            
            StringWriter stringWriter = new StringWriter();
            
            template.merge(velocityContext, stringWriter);
            msg.setText(stringWriter.toString());
            
            this.mailSender.send(msg);
        } catch (ParseErrorException ex) {
            Logger.getLogger(MailServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(MailServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
