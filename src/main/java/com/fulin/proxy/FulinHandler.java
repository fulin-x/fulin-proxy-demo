package com.fulin.proxy;

/**
 * @Author: Fulin
 * @Description: FulinHandler
 * @DateTime: 2025/4/9 下午10:53
 **/
public interface FulinHandler {
    String functionBody(String methodName);

    default void setProxy(FulinInterface proxy){}
}
