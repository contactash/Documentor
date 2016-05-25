package com.ace.utils;

class OSDetectionUtils
{
    private static boolean isWindows = false;
    private static boolean isLinux = false;
    private static boolean isMac = false;

    static
    {
        String os = System.getProperty("os.name").toLowerCase();
        isWindows = os.contains("win");
        isLinux = os.contains("nux") || os.contains("nix");
        isMac = os.contains("mac");
    }

    static boolean isWindows() { return isWindows; }
    static boolean isLinux() { return isLinux; }
    static boolean isMac() { return isMac; }

}