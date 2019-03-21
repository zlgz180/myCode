package com.code;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * @author tianwei
 * @since 2019-03-21 18:00
 */
public class ValidationData {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        ArrayList<String> ints = toArrayByFileReader1("E:\\test.txt");
        for (String tmp : ints) {
            if (set.contains(tmp)) {
                System.out.println("数据重复:" + tmp);
            } else {
                set.add(tmp);
            }
        }
        System.out.println(ints.size());
    }

    public static ArrayList<String> toArrayByFileReader1(String name) {
        // 使用ArrayList来存储每行读取到的字符串
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            FileReader fr = new FileReader(name);
            BufferedReader bf = new BufferedReader(fr);
            String str;
            // 按行读取字符串
            while ((str = bf.readLine()) != null) {
                arrayList.add(str);
            }
            bf.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 返回数组
        return arrayList;
    }
}
