package com.code.design.pattern.behavioral.templatemethod;

/**
 * Created by geely
 */
public class DesignPatternCourse extends ACourse {
    @Override
    void packageCourse() {
        System.out.println("提供课程Java源代码");
    }

    @Override
    public boolean needWriteArticle() {
        return true;
    }

}
