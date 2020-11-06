package com.geektrust.family.service.add;

public abstract class AddMember implements AddService {
    AddMember() {

    }

    private static boolean isLoggingEnabled;

    public static boolean isIsLoggingEnabled() {
        return isLoggingEnabled;
    }

    public static void setIsLoggingEnabled(boolean isLoggingEnabled) {
        AddMember.isLoggingEnabled = isLoggingEnabled;
    }
}
