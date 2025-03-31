package com.example.swiftcode.util;

import java.util.Arrays;
import java.util.Locale;

public class Iso2CodeHelper {
    public static boolean isIso2CodeValid(String code) {
        return Arrays.stream(Locale.getISOCountries()).toList().contains(code);
    }
}
