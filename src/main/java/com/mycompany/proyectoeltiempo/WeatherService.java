/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectoeltiempo;

import java.io.BufferedInputStream;
import jakarta.mail.*; 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import com.google.gson.Gson; 
import java.util.logging.Level;
import java.util.logging.Logger;
import com.mycompany.proyectoeltiempo.Weather; 
import com.mycompany.proyectoeltiempo.EmailService; 
/**
 *
 * @author jorge
 */
public class WeatherService {

    public void getWeather() {

        String url = "https://api.openweathermap.org/data/2.5/weather?q=A%20Coruna,ES&units=metric&appid=309e91a5d8a1468b066569ac58abf226";
        try {
            URL apiUrl = new URL(url);
            System.out.println(apiUrl);

            HttpURLConnection conexion = (HttpURLConnection) apiUrl.openConnection();

            conexion.setRequestMethod("GET");

            int resultado = conexion.getResponseCode();

            System.out.println("Resultado : " + resultado);

            if (resultado == 200) {

                InputStream inPut = conexion.getInputStream();
                InputStreamReader inReader = new InputStreamReader(inPut);
                BufferedReader br = new BufferedReader(inReader);

                StringBuilder sb = new StringBuilder();
                String linea = "";

                while ((linea = br.readLine()) != null) {

                   
                    sb.append(linea + "\n");

                }
                
                Gson gson = new Gson(); 
                Weather w = gson.fromJson(sb.toString(),Weather.class); 
                
                String tiempo = ("Temperatura:" + w.getMain().temp + "\n" +
                "Temperatura Maxima:" + w.getMain().temp_max + "\n" +
                        "Temperatura minina:" + w.getMain().temp_min);
                
               EmailService es = new EmailService(); 
               
               es.sendEmail(tiempo);
                
             
                
                
            }

        } catch (MalformedURLException ex) {
            System.out.println("Error malformed");
            Logger.getLogger(WeatherService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            System.out.println("Fallo en el URLconnection");
            Logger.getLogger(WeatherService.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("Consultando API del tiempo..");

    }

}
