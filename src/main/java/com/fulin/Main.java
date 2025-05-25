package com.fulin;

import com.fulin.proxy.FulinHandler;
import com.fulin.proxy.FulinInterface;
import com.fulin.proxy.FulinInterfaceFactory;

import java.lang.reflect.Field;

/**
 * @Author: Fulin
 * @Description: 主函数
 * @DateTime: 2025/4/9 下午9:38
 **/
public class Main {
    public static void main(String[] args) throws Exception {
        FulinInterface proxyObject = FulinInterfaceFactory.createProxyObject(new PrintFunctionName());
        proxyObject.func1();
        proxyObject.func2();
        proxyObject.func3();
        System.out.println("--------------------------");
        proxyObject = FulinInterfaceFactory.createProxyObject(new PrintFunctionName1());
        proxyObject.func1();
        proxyObject.func2();
        proxyObject.func3();
        System.out.println("--------------------------");
        proxyObject = FulinInterfaceFactory.createProxyObject(new LogHandler(proxyObject));
        proxyObject.func1();
        proxyObject.func2();
        proxyObject.func3();
    }

    static class PrintFunctionName implements FulinHandler{
        @Override
        public String functionBody(String methodName) {
            return "System.out.println(\""+methodName+"\");";
        }
    }

    static class PrintFunctionName1 implements FulinHandler{
        @Override
        public String functionBody(String methodName) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("System.out.println(1);")
                    .append("System.out.println(\""+methodName+"\");");
            return stringBuilder.toString();
        }
    }

    static class LogHandler implements FulinHandler{

        FulinInterface fulinInterface;

        public LogHandler(FulinInterface fulinInterface) {
            this.fulinInterface = fulinInterface;
        }
        @Override
        public String functionBody(String methodName) {
            return "System.out.println(\"before\");\n" +
                    "fulinInterface." + methodName + "();\n" +
                    "System.out.println(\"after\");";
        }

        @Override
        public void setProxy(FulinInterface proxy) {
            Class<? extends FulinInterface> aClass = proxy.getClass();
            Field field = null;
            try {
                field = aClass.getDeclaredField("fulinInterface");
                field.setAccessible(true);
                field.set(proxy,fulinInterface);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}