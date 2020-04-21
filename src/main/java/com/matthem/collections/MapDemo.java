package com.matthem.collections;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {
    public static void show() {
        // Java: Maps
        // C#: Dictionary
        // Python: Dictionary
        // JavaScript: Objects
        // var person = { name: "a" }
        var c1 = new Customer("a", "e1");
        var c2 = new Customer("b", "e2");

        Map<String, Customer> map = new HashMap<>();
        map.put(c1.getEmail(), c1);
        map.put(c2.getEmail(), c2);

       map.replace("e1", new Customer("a++", "e1"));
//            var customer = map.getOrDefault(
//                "e10",
//                new Customer("Unknown", ""));

        System.out.println(map);

        for (var customer: map.values()) {
            System.out.println(customer);
        }
    }
}
