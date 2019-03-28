package com.code.jvm;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by phoenix on 2018/3/12.
 */

public class DiskClassLoader extends ClassLoader {

    private String mFilePath;

    public DiskClassLoader(String mFilePath) {
        this.mFilePath = mFilePath;
    }

    public static void main(String[] args) {
        System.out.println(String.class.getClassLoader());
        ClassLoader loader = DiskClassLoader.class.getClassLoader();
        while (loader != null) {
            // sun.misc.Launcher$AppClassLoader@58644d46
            // sun.misc.Launcher$ExtClassLoader@7ea987ac
            System.out.println(loader);
            loader = loader.getParent();
        }
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String fileName = getFileName(name);
        File file = new File(mFilePath, fileName);
        try {
            FileInputStream ins = new FileInputStream(file);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            int len = 0;
            try {
                while ((len = ins.read()) != -1) {
                    bos.write(len);
                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
            byte[] data = bos.toByteArray();
            ins.close();
            bos.close();
            return this.defineClass(name, data, 0, data.length);
        } catch (IOException exp) {
            exp.printStackTrace();
        }
        return super.findClass(name);
    }

    private String getFileName(String name) {
        int index = name.lastIndexOf('.');
        if (index == -1) {
            return name + ".class";
        } else {
            return name.substring(index) + ".class";
        }
    }
}
