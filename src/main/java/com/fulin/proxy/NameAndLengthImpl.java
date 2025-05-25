package com.fulin.proxy;

/**
 * @Author: Fulin
 * @Description: 实现类
 * @DateTime: 2025/4/9 下午9:43
 **/
public class NameAndLengthImpl implements FulinInterface {
    @Override
    public void func1() {
        String methodName = "func1";
        System.out.println(methodName);
        System.out.println(methodName.length());
    }

    @Override
    public void func2() {
        String methodName = "func2";
        System.out.println(methodName);
        System.out.println(methodName.length());
    }

    @Override
    public void func3() {
        String methodName = "func3";
        System.out.println(methodName);
        System.out.println(methodName.length());
    }
}
