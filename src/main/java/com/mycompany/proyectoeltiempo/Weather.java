/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectoeltiempo;

import java.util.List;

/**
 *
 * @author jorge
 */
public class Weather {
    
    private Main main ; 
    private String name ;
    private List weather ; 

    public List getWeather() {
        return weather;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }
    
}
