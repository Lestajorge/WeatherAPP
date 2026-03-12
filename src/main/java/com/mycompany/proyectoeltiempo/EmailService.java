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
import javax.swing.Icon;

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

            String iconoURl = "https://openweathermap.org/img/wn/01d@2x.png";
            message.setSubject("El tiempo de hoy");
            String html = """
                <html>
                <head>
                <meta charset="UTF-8">
                </head>
                <body style="background:#f2f2f2;font-family:Arial;text-align:center;">
                      
                <div style="
                max-width:400px;
                margin:auto;
                background:white;
                padding:20px;
                border-radius:10px;
                box-shadow:0px 0px 10px rgba(0,0,0,0.2);
                ">

                <h1 style="color:#4a90e2;">WeatherApp</h1>

                <img src="%s" width="100">

                <h2>%s</h2>

                <h1>%s°C</h1>

                <p>TempMAX: %sªC</p>
                <p>TempMIN: %sºC</p>

                </div>

                </body>
                </html>
                        """.formatted(iconoURl, weather.getName(), weather.getMain().getTemp(), weather.getMain().getTemp_max(),
                     weather.getMain().getTemp_min());

            message.setContent(html, "text/html ; charset=UTF-8");

            Transport.send(message);

        } catch (AddressException ex) {
            Logger.getLogger(EmailService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(EmailService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
