package com.rating.utilities;

import java.util.UUID;

public class UtilityMethods {

    public static String generateRandomId() {
        return UUID.randomUUID().toString();
    }
}
