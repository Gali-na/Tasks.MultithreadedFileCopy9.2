package org.example;

import java.io.File;

public class FileCheck {
    public static boolean check(File file) {
        if (file!=null && file.isFile() && file.length() != 0) {
            return true;
        }
        return false;
    }
}
