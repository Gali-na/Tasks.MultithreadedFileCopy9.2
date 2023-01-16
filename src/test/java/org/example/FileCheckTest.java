package org.example;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class FileCheckTest {
    private File file;

    @Test
    void check_ArgumentIsNotFile_GetFalse() {
        file =new File("Directory");
      assertEquals(false,FileCheck.check(file));
    }

    @Test
    void check_ArgumentIsNull_GetFalse() {
        file =null;
        assertEquals(false,FileCheck.check(file));
    }

    @Test
    void check_ArgumentExistFile_GetTrue() {
        file =new File("txt.txt");
        assertEquals(true,FileCheck.check(file));
    }
}