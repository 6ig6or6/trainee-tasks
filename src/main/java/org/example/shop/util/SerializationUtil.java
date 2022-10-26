package org.example.shop.util;

import java.io.*;

public class SerializationUtil {
    private static final String FILE_PATH = "src/main/resources/bucket.txt";

    public static Object deserialize() throws IOException,
            ClassNotFoundException {
        FileInputStream fis = new FileInputStream(FILE_PATH);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Object obj = ois.readObject();
        ois.close();
        return obj;
    }

    public static void serialize(Object obj)
            throws IOException {
        FileOutputStream fos = new FileOutputStream(FILE_PATH);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(obj);
        fos.close();
    }
}
