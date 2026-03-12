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

    void sendEmail(Weather weather) {

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

            String html = "<html>"
                    + "<body>"
                    + "<h1>WeatherApp</h1>"
                    + "<p>Ciudad: " + weather.getMain().getCiudad() + "</p>"
                    + "<p>Temperatura: " + weather.getMain().getTemp() + "°C</p>"
                    + "<p>Temperatura Minima: " + weather.getMain().getTemp_min() + "°C</p>"
                    + "<p>Temperatura Maxima: " + weather.getMain().getTemp_max() + "°C</p>"
                    + "</body>"
                    + "</html>";

            message.setContent(html, "text/html");

            Transport.send(message);

        } catch (AddressException ex) {
            Logger.getLogger(EmailService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(EmailService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
