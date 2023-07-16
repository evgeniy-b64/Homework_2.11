package com.example.homework_2_11.Service;

import com.example.homework_2_11.Exceptions.IncorrectInputException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import javax.annotation.PostConstruct;
import java.util.*;

@Service
@SessionScope
public class ShoppingCartService {
    private final Map<Integer,String> shoppingCart = new HashMap<>(); // список товаров в корзине
    private final Map<Integer, String> catalog = new HashMap<>(); // каталог для хранения всех доступных товаров

    @PostConstruct
    // заполнение каталога
    public void init() {
        int i = 0;
        catalog.put(i++, "арбуз");
        catalog.put(i++, "банан");
        catalog.put(i++, "вишня");
        catalog.put(i++, "груша");
        catalog.put(i++, "дыня");
    }

    public Map<Integer, String> printCatalog() {
        return catalog;
    }

    // добавление списка покупок
    public void add(ArrayList<Integer> items) {

        // проверка корректности ввода списка покупок
        if (StringUtils.isNumeric(items.toString())) {
            //System.out.println("Ошибка ввода: список содержит не только числа");
            throw new IncorrectInputException("список содержит не только числа");
        }

        // делаем список покупок в виде HashMap
        for (int i = 0, j=shoppingCart.size(); i < items.size(); i++) {
            shoppingCart.put(i+j, catalog.get(items.get(i))); // добавляем новые товары в корзину
        }

        System.out.println(shoppingCart);
    }

    // получение полного списка товаров в заказе
    public Map<Integer,String> get() {
        return Collections.unmodifiableMap(shoppingCart);
    }

    // удаление всех товаров из корзины
    public void clear() {
        shoppingCart.clear();
    }
}
