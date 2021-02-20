package com.chiang.java.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author PF14EBBQ
 */
public class StreamLearn {
    public static void main(String[] args) {
        List<Dish> intList = new ArrayList<com.chiang.java.stream.StreamLearn.Dish>();
        intList.add(new Dish("a", 1));
        intList.add(new Dish("b", 2));
        intList.add(new Dish("c", 3));
        intList.stream().filter(dish -> {
            return dish.amount >= 2;
        }).forEach(dish -> {
            System.out.println(dish.getAmount());
        });
        System.out.println(intList.stream().filter(dish -> {
            return dish.amount >= 2;
        }).collect(Collectors.toList()));
    }

    private static class Dish {
        String name;
        Integer amount;

        public Dish(String name, Integer amount) {
            this.name = name;
            this.amount = amount;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAmount() {
            return amount;
        }

        public void setAmount(Integer amount) {
            this.amount = amount;
        }
    }
}

