/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectoeltiempo;

import jakarta.mail.Authenticator;
import jakarta.mail.*;
import jakarta.mail.internet.*;
import jakarta.mail.Session;
import jakarta.mail.Authenticator;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jorge
 */
public class EmailService {

    void sendEmail(String mensaje) {

        Properties props = new Properties();

        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(props, new Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication("jorgelesta476@gmail.com", "emvp wffq azvl ernc");

            }

        });

    
     
        try { 
            InternetAddress address = new InternetAddress("jorge_lesta476@gmail.com");
            Message message = new MimeMessage(session); 
            message.setFrom(address);
            InternetAddress addressDestino = new InternetAddress("jorge_lesta@hotmail.com"); 
            message.setRecipient(Message.RecipientType.TO, addressDestino); 
            message.setSubject("El tiempo de hoy");
            message.setText(mensaje);
            Transport.send(message);
            
            
            
            
        } catch (AddressException ex) {
            Logger.getLogger(EmailService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(EmailService.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        
    }
}
