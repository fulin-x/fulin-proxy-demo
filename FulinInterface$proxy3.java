package com.fulin.proxy;

public class FulinInterface$proxy3 implements FulinInterface {
FulinInterface fulinInterface;
    @Override
    public void func1() {
        System.out.println("before");
fulinInterface.func1();
System.out.println("after");
    }

    @Override
    public void func2() {
        System.out.println("before");
fulinInterface.func2();
System.out.println("after");
    }

    @Override
    public void func3() {
        System.out.println("before");
fulinInterface.func3();
System.out.println("after");
    }
}