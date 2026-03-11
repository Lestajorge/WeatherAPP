/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.proyectoeltiempo;

/**
 *
 * @author jorge
 */
public class MainPrincipal {

    public static void main(String[] args) {

        System.out.println("Consultando el tiempo..");

        WeatherService weatherService = new WeatherService();

        weatherService.getWeather();
        
        Weather weather = new Weather(); 
        
        Main main = new Main(); 
        
    }
}
