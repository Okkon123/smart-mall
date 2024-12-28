package com.cqu.cs.mall.context;

public class BaseContext {

    public static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void setCurrentToken(String token) {
        threadLocal.set(token);
    }

    public static String getCurrentToken() {
        return threadLocal.get();
    }

    public static void removeCurrentId() {
        threadLocal.remove();
    }

}
