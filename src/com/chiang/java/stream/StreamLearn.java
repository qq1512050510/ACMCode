package com.chiang.java.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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
        List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 4, 5, 6, 7, 8, 9, 0);
        /**
         * limit(n) 取前n个元素 skip(n) 跳过前n个元素
         *
         */
        numbers.stream().filter(i -> i % 2 == 0).limit(3).distinct().forEach(System.out::println);
        System.out.println("---------");
        numbers.stream().filter(i -> i % 2 == 0).skip(3).distinct().forEach(System.out::println);
        List<String> words = Arrays.asList(new String[]{"Java 8", "Lambdas", "In", "Action"});
        System.out.println(words.stream().map(String::length).collect(Collectors.toList()));
        Stream<String> streamOfWords = Arrays.stream((String[]) words.toArray());
        System.out.println(words.stream().map(word -> word.split("")).map(Arrays::stream).distinct().collect(Collectors.toList()));
        /**
         * flatMap
         */
        System.out.println(words.stream().map(word -> word.split("")).flatMap(Arrays::stream).distinct().collect(Collectors.toList()));
        List<Integer> ints = Arrays.asList(1, 2, 3, 4, 6);
        System.out.println(ints.stream().map(n -> n * n).collect(Collectors.toList()));
        List<Integer> number1 = Arrays.asList(1, 2, 3);
        List<Integer> number2 = Arrays.asList(3, 4);
        System.out.println(number1.stream().map(i -> number2.stream().map(j -> new int[]{i, j})).collect(Collectors.toList()));
        System.out.println(number1.stream().flatMap(i -> number2.stream().map(j -> new int[]{i, j})).collect(Collectors.toList()));
        System.out.println("----");
        number1.stream().map(i -> {
            System.out.println(i);
            return i;
        });
        number1.stream().flatMap(i -> {
            System.out.println(i);
            return null;
        });
        System.out.println("----------");

        System.out.println(number1.stream().allMatch(num -> num >= 1));
        Optional<Integer> numOpt = number1.stream().filter(num -> num > 1).findAny();
        System.out.println(numOpt);
        numOpt.ifPresent(num -> System.out.println(num));
        /**
         *归约
         */
        System.out.println(number1.stream().reduce(1, (a, b) -> {
            return a * b;
        }));
        /**
         * 返回整数
         */
        System.out.println(number1.stream().reduce(0, Integer::sum));
        /**
         * 返回Optional
         */
        System.out.println(number1.stream().reduce((a, b) -> a + b));

        System.out.println(number1.stream().reduce(Integer::max));
        System.out.println(number1.stream().reduce(Integer::min).get());
        StreamLearn stream = new StreamLearn();
        stream.flatMapTest();
    }

    /**
     * shengcheng
     */
    public void pythagoreanTriples() {
        IntStream.rangeClosed(0, 100);
    }

    public void flatMapTest() {
        String[] strings = new String[]{"hello welcome", "world hello", "hello world", "hello world welcome"};
        Stream<String> streams = Stream.of(strings);
        Stream.of(strings).flatMap(str -> Arrays.stream(str.split(" "))).distinct().forEach(System.out::println);
        Stream.of(strings).map(s -> s.split(" ")).forEach(System.out::println);
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

