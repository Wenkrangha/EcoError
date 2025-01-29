package com.wenkrang.ecoError.lib;

import java.util.function.Consumer;

@SuppressWarnings("unused")
public class JavaUse {
    public static <T> void use(T var1, Consumer<T> var2) {
        var2.accept(var1);
    }
}
