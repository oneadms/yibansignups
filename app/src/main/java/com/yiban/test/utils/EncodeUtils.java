package com.yiban.test.utils;

import android.util.Base64;

public class EncodeUtils {
    public static byte[] base64Encode(final byte[] input) {
        if (input == null || input.length == 0) return new byte[0];
        return Base64.encode(input, Base64.NO_WRAP);
    }
}

