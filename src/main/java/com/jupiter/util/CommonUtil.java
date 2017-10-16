package com.jupiter.util;

import java.util.UUID;

public class CommonUtil {

    public static String generateUniqueId() {
        return UUID.randomUUID().toString();
    }
}
