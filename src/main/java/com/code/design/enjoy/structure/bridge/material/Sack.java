package com.code.design.enjoy.structure.bridge.material;

/**
 * 包装接口 Material
 */
public class Sack implements Material {
    @Override public void draw() {
        System.out.print("用麻袋");
    }

}
