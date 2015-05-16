package com.ace.utils;

import java.awt.*;
import java.io.File;

public class FileUtils {

    public static void openFile(String file) {

        try {
            System.out.println(file);
            if ((new File(file)).exists()) {

                if(OSDetector.isWindows()) {
                    Process p = Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+ file);
                    p.waitFor();
                } else if (OSDetector.isLinux() || OSDetector.isMac()) {
                    Process p = Runtime.getRuntime().exec(new String[]{"/usr/bin/open",
                            file});
                    p.waitFor();
                }  else if (Desktop.isDesktopSupported()) {
                    Desktop.getDesktop().open(new File(file));
                }
            } else {
                System.out.println("File does not exists");
            }
            System.out.println("Done");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
