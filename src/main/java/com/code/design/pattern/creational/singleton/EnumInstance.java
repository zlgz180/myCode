package com.code.design.pattern.creational.singleton;

/**
 * Created by geely
 */
public enum EnumInstance {
    INSTANCE {
        @Override
        protected void printTest() {
            System.out.println("Geely Print Test");
        }
    };
    private Object data;

    public static EnumInstance getInstance() {
        return INSTANCE;
    }

    protected abstract void printTest();

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
