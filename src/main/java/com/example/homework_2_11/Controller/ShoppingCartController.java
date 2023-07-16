package com.example.homework_2_11.Controller;

import com.example.homework_2_11.Service.ShoppingCartService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Map;

@RestController
@RequestMapping("/order")
public class ShoppingCartController {

    private final ShoppingCartService shoppingCartService;

    public ShoppingCartController(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    // вывод на экран каталога товаров
    @GetMapping("/catalog")
    public Map<Integer, String> printCatalog() {
        return shoppingCartService.printCatalog();
    }

    // добавление товаров в корзину
    @GetMapping("/add")
    public void add(@RequestParam("items") ArrayList<Integer> items) {
        shoppingCartService.add(items);
    }

    // получение полного списка товаров в заказе
    @GetMapping("/get")
    public Map<Integer,String> get(){
        return shoppingCartService.get();
    }

    // удаление всех товаров из корзины
    @GetMapping("/clear")
    public void clear(){
        shoppingCartService.clear();
    }
}
