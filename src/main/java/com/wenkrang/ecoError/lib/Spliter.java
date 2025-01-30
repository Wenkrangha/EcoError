package com.wenkrang.ecoError.lib;

import java.util.ArrayList;
import java.util.List;

public class Spliter {
    public static List<String> splitEveryNChars(String str, int n) {
        List<String> result = new ArrayList<>();
        int index = 0;
        while (index < str.length()) {
            result.add("§7" + str.substring(index, Math.min(index + n, str.length())));
            index += n;
        }
        return result;
    }
}
