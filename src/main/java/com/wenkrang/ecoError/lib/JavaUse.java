package com.wenkrang.ecoError.lib;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Objects;

@SuppressWarnings("unused")
public class JavaUse {
    //nn(obj) 等同于Kotlin中的 obj!!
    @Nonnull public static <T> T nn(@Nullable T var1) {
        return Objects.requireNonNull(var1);
    }
    //nNqm(obj1, obj2) 等同于Kotlin中的 obj1 ?: obj2
    @Nonnull public static <T> T nNqm(@Nullable T var1, @Nonnull T var2) {
        return Objects.requireNonNullElse(var1, var2);
    }
}
