package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("")
public class homeController {

    @GetMapping("")
    public String home() {return "home.html";}

    @GetMapping("/producto")
    public String itemdetail(){return "pages/itemdetail";}

    @GetMapping("/carrito")
    public String getCart(){return "pages/cart";}

    @GetMapping("/orden")
    public String orderdetail(){return "pages/orderdetail";}

    @GetMapping("/guardarorden")
    public String saveOrder(){return "redirect:/";}
}
