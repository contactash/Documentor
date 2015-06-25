package com.ace.utils;

import com.ace.constants.FileUtilsConstants;

import java.awt.*;
import java.io.File;

public class FileUtils {

    public static void openFile(String file) {

        try {
            System.out.println(file);
            if ((new File(file)).exists()) {

                if(OSDetectionUtils.isWindows()) {
                    Process p = Runtime.getRuntime().exec(FileUtilsConstants.RUN_DLL + file);
                    p.waitFor();
                } else if (OSDetectionUtils.isLinux() || OSDetectionUtils.isMac()) {
                    Process p = Runtime.getRuntime().exec(new String[]{FileUtilsConstants.OPEN_COMMAND,
                            file});
                    p.waitFor();
                }  else if (Desktop.isDesktopSupported()) {
                    Desktop.getDesktop().open(new File(file));
                }
            } else {
                System.out.println(FileUtilsConstants.FILE_DOES_NOT_EXISTS);
            }
            System.out.println(FileUtilsConstants.DONE);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
