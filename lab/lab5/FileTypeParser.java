package lab.lab5;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FileTypeParser {
    static Map<byte[], String> map = new HashMap<>();
    static final String[] type = {"png", "zip or jar", "class"};
    static final byte[][] header = {
            {(byte) 0x89, 0x50, 0x4e, 0x47},
            {0x50, 0x4b, 0x03, 0x04},
            {(byte) 0xca, (byte) 0xfe, (byte) 0xba, (byte) 0xbe}};
    static FileInputStream fileInputStream;
    static byte[] bytes = new byte[4];

    public static void main(String[] args) throws IOException {
        map.put(header[0], type[0]);
        map.put(header[1], type[1]);
        map.put(header[2], type[2]);
        Scanner in = new Scanner(System.in);
        System.out.print("File name: ");
        String s = in.next();
        fileInputStream = new FileInputStream("src/main/java/lab/lab5/" + s);
        fileInputStream.read(bytes);
        if (equals(bytes, header[0])) {
            System.out.println("File Header(Hex): " + byteTohex(header[0]));
            System.out.println("File Type: " + map.get(header[0]));
        } else if (equals(bytes, header[1])) {
            System.out.println("File Header(Hex): " + byteTohex(header[1]));
            System.out.println("File Type: " + map.get(header[1]));
        } else if (equals(bytes, header[2])) {
            System.out.println("File Header(Hex): " + byteTohex(header[2]));
            System.out.println("File Type: " + map.get(header[2]));
        }
    }

    public static String byteTohex(byte[] bytes) {
        StringBuilder hex = new StringBuilder("[");
        for (int i = 0; i < bytes.length; i++) {
            hex.append(String.format("0X%02x", bytes[i]));
            if (i != bytes.length-1) hex.append(", ");
        }
        hex.append("]");
        return hex.toString();
    }

    public static boolean equals(byte[] o1, byte[] o2) {
        if (o1.length != o2.length) return false;
        for (int i = 0; i < o1.length; i++) {
            if (o1[i] != o2[i]) return false;
        }
        return true;
    }
}
