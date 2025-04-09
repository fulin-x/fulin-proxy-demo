package com.fulin.proxy;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.nio.file.Files;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: Fulin
 * @Description: 代理工厂
 * @DateTime: 2025/4/9 下午9:45
 **/
public class FulinInterfaceFactory {

    private static final AtomicInteger count = new AtomicInteger();

    private static File createJavaFile(String className) throws IOException {

        String func1Body = functionBody("func1");
        String func2Body = functionBody("func2");
        String func3Body = functionBody("func3");

        String context ="package com.fulin.proxy;\n" +
                "\n" +
                "public class "+className+" implements FulinInterface {\n" +
                "    @Override\n" +
                "    public void func1() {\n" +
                "        "+func1Body+"\n" +
                "    }\n" +
                "\n" +
                "    @Override\n" +
                "    public void func2() {\n" +
                "        "+func2Body+"\n" +
                "    }\n" +
                "\n" +
                "    @Override\n" +
                "    public void func3() {\n" +
                "        "+func3Body+"\n" +
                "    }\n" +
                "}";
        File javaFile = new File(className+".java");
        Files.writeString(javaFile.toPath(),context);
        return javaFile;
    }

    private static String getClassName() {
        return "FulinInterface$proxy" + count.incrementAndGet();
    }

    private static String functionBody(String methodName){
        return "System.out.println(\""+methodName+"\");";
    }

    private static FulinInterface newInstance(String className) throws Exception{
        Class<?> aClass = FulinInterfaceFactory.class.getClassLoader().loadClass(className);
        Constructor<?> constructor = aClass.getConstructor();
        FulinInterface proxy = (FulinInterface) constructor.newInstance();
        return proxy;
    }

    public static FulinInterface createProxyObject() throws Exception {
        String className = getClassName();
        File javaFile = createJavaFile(className);
        Compiler.compile(javaFile);
        return newInstance("com.fulin.proxy."+className);
    }

}
