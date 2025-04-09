package com.fulin;

import com.fulin.proxy.FulinInterface;
import com.fulin.proxy.FulinInterfaceFactory;

/**
 * @Author: Fulin
 * @Description: 主函数
 * @DateTime: 2025/4/9 下午9:38
 **/
public class Main {
    public static void main(String[] args) throws Exception {
        FulinInterface proxyObject = FulinInterfaceFactory.createProxyObject();
        proxyObject.func1();
        proxyObject.func2();
        proxyObject.func3();
    }
}