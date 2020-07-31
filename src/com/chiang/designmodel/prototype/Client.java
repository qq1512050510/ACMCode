package com.chiang.designmodel.prototype;

import java.lang.String;
import java.util.Random;

public class Client {
    private final static int MAX_MAIL = 100;
    private static void send(Mail mail){
        System.out.println("发送邮件:"+mail.getReceiver());
    }
    private static String getRandString(int count){
        String source = "abcdefghijklmnopqrstuvwxyz";
        StringBuffer stringBuffer = new StringBuffer();
        for(int i=0;i<count;i++){
            stringBuffer.append(source.charAt(new Random().nextInt(source.length())));
        }
        return stringBuffer.toString();
    }
    public static void main(String[] args) {
        AdvTemplate advTemplate = new AdvTemplate();
        Mail mail = new Mail(advTemplate);
        int i = 0;
        while(i<100){
            Mail mailClone = mail.clone();
            System.out.print(mailClone.hashCode());
            System.out.print(mail.hashCode());
            mail.setReceiver(getRandString(10));
            send(mail);
            i++;
        }
    }
}
