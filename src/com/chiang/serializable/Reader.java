package com.chiang.serializable;


import java.io.Serializable;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class Reader implements Serializable {
    private static final long serialVersionUID = 10L;

    private void readObject(ObjectInputStream stream) {
        System.out.println("foo...bar...");
    }

    public static byte[] serialize(Object obj) {
        //序列化对象
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ObjectOutputStream output = null;
        try {
            output = new ObjectOutputStream(out);
            output.writeObject(obj);
            output.flush();
            output.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return out.toByteArray();

    }

    public static Object deserialize(byte[] bytes) {
        //反序列化处理
        ByteArrayInputStream in = new ByteArrayInputStream(bytes);
        ObjectInputStream input;
        Object obj = null;
        try {
            input = new ObjectInputStream(in);
            obj = input.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return obj;

    }

    public static void main(String[] args) {
        byte[] data = serialize(new Reader()); //对类自身进行序列化
        Object response = deserialize(data);
        System.out.println(response);
    }
}
