package com.chiang.serializable;

import java.io.*;

public class ExternalizableTest {
    public static void main(String[] args) throws Exception {
        SerializeUserS();
        DeSerializeUserS();
//        serializeUser();
//        deSerializeUser();
    }

    private static void serializeUser() throws Exception {
        User user = new User();
        user.setName("JAVA序列化测试");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("d://test"));
        oos.writeObject(user);
        oos.close();
        System.out.printf("使用Externalizable接口，添加transient关键字序列化指之前：%s", user.getName());
    }
    //反序列化
    private static void deSerializeUser() throws IOException, ClassNotFoundException {
        File file = new File("d://test");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        User newUser = (User)ois.readObject();
        System.out.println("使用Externalizable接口，添加了transient关键字序列化之后："+newUser.getName());
    }
    /*private static void deSerializeUser() throws Exception {
        File file = new File("d://test");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        User user = (User) ois.readObject();
        System.out.printf("使用Externalizable接口，添加了transient关键字序列化之后的user:%s", user.getName());
    }*/

    //序列化
    private static void SerializeUserS() throws FileNotFoundException, IOException, ClassNotFoundException {
        UserS user = new UserS();
        user.setName("Java的架构师技术栈");
        user.setAge(24);
        ObjectOutputStream oos =
                new ObjectOutputStream(new FileOutputStream("d://template"));
        oos.writeObject(user);
        oos.close();
        System.out.println("添加了transient关键字序列化：age=  " + user.getAge() + user.getName());
    }

    //反序列化
    private static void DeSerializeUserS() throws IOException, ClassNotFoundException {
        File file = new File("d://template");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        UserS newUser = (UserS) ois.readObject();
        System.out.println("添加了transient关键字反序列化：age=  " + newUser.getAge() + newUser.getName());
    }
}

class User implements Externalizable {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(name);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name = (String) in.readObject();
    }
}

class UserS implements Serializable {
    private static final long serialVersionUID = 123456L;
    private transient int age;
    private String name;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
