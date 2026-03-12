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
import java.util.Map;
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

           
            
            String iconCode = weather.getWeatherInfo().get(0).getIcon(); 

            String iconoUrl = "https://openweathermap.org/img/wn/" + iconCode + "@4x.png";
            message.setSubject("El tiempo de hoy");
            String html = """
                <html>
                <head>
                <meta charset="UTF-8">
                </head>
                <body style="background:#4facfe;font-family:Arial;text-align:center;">
                      
                <div style="
                max-width:400px;
                margin:auto;
                background: linear-gradient(135deg,#4facfe,#00f2fe);
                padding:35px;
                border-radius:15px;
               
                box-shadow:0 10px 25px rgba(0,0,0,0.2);
                
                ">

              <h1 style="color:white;">WeatherApp</h1>
                <img src="%s" width="120" style="margin:10px;">

                <h2 style="color:white;margin:5px 0;">%s</h2>

               <h1 style="font-size:48px;margin:10px 0;">%s&deg;C</h1>
               <hr style="border:none;border-top:1px solid #eee;margin:20px 0;">
               <table width="100%%">
                <tr>
                <td align="center">⬆ Max %s°C</td>
                <td align="center">⬇ Min %s°C</td>
                </tr>
                </table>

                </div>

                </body>
                </html>
                        """.formatted(iconoUrl, weather.getName(), Math.round(weather.getMain().getTemp()), Math.round(weather.getMain().getTemp_max()),
                    Math.round(weather.getMain().getTemp_min()));

            message.setContent(html, "text/html; charset=UTF-8");

            Transport.send(message);

        } catch (AddressException ex) {
            Logger.getLogger(EmailService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(EmailService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
