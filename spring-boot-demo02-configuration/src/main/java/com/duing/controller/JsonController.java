package com.duing.controller;

import com.duing.bean.Food;
import com.duing.bean.Vegetables;
import com.duing.config.FoodConfig;
import com.duing.config.VegetablesConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JsonController {

//    @Value("${food.meat}")
//    private String meat;
//    @Value("${food.rice}")
//    private String rice;
    @Autowired
    private FoodConfig foodConfig;

    @RequestMapping("/json")
    public Food json(){
        Food food = new Food();
//        food.setMeat("烤肉");
//        food.setRice("拌饭");
        food.setMeat(foodConfig.getMeat());
        food.setRice(foodConfig.getRice());
        return food;
    }

    @Autowired
    private VegetablesConfig vegetablesConfig;

    @RequestMapping("/vegetables")
    public Vegetables vegetables(){
        Vegetables vegetables = new Vegetables();
        vegetables.setPotato(vegetablesConfig.getPotato());
        vegetables.setEggplant(vegetablesConfig.getEggplant());
        vegetables.setGreenPepper(vegetablesConfig.getGreenPepper());
        return vegetables;
    }
    @Value("${info.username}")
    private String username;
    @Value("${info.password}")
    private String password;

    @RequestMapping("/jasypt")
    public String jasypt(){
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(username);
        stringBuffer.append("\t");
        stringBuffer.append(password);
        return stringBuffer.toString();
    }
}
