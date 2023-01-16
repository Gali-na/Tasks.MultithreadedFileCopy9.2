package org.example;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class DirectoryCheckTest {
    private File file;

    @Test
    void check_ArgumentIsNull_GetFalse() {
        file = null;
        assertEquals(false, FileCheck.check(file));
    }

    @Test
    void check_ArgumentIsNotDirectory_GetFalse() {
        file = new File("Directory.txt");
        assertEquals(false, FileCheck.check(file));
    }

    @Test
    void check_ArgumentIsDirectory_GetFalse() {
        file = new File("Directory");
        assertEquals(false, FileCheck.check(file));
    }
}