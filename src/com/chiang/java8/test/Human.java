package com.chiang.java8.test;

public class Human {
    public void speak(String words) {
        System.out.printf("Human speak %s \n", words);
    }
}

class Black extends Human {
    @Override
    public void speak(String words) {
        super.speak("hello");
        System.out.printf("Black say %s \n", words);
    }

    public static void main(String[] args) {
        Human black = new Black();
        black.speak("haha");
    }
}
