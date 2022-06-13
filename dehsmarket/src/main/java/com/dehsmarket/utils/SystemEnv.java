package com.dehsmarket.utils;

public class SystemEnv {

    public static String get(String environmentVariable){

        return System.getenv(environmentVariable);

    }
    
}
