package org.example;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class WriterFileTest {
    private WriterFile writerFile;
    private DataBuffer buffer;

    @Test
    void creatNameForNewFile_FileForCopyIsNull_GetEmptyString() {
        File file = new File("");
        writerFile = new WriterFile(buffer, null,new File("Directory"));
         assertEquals("",writerFile.creatNameForNewFile());
    }

    @Test
    void creatNameForNewFile_FileForCopyIsNotFile_GetEmptyString() {
        File file = new File("");
        writerFile = new WriterFile(buffer, new File("Directory"),new File("Directory"));
        assertEquals("",writerFile.creatNameForNewFile());
    }

    @Test
    void creatNameForNewFile_SizeFileForCopyEmty_GetEmptyString() {
        File file = new File("trr.txt");
        writerFile = new WriterFile(buffer, new File("Directory"),new File("Directory"));
        assertEquals("",writerFile.creatNameForNewFile());
    }

    @Test
    void creatNameForNewFile_NewFileIsNotDirectory_GetEmptyString() {
        File file = new File("trr.txt");
        writerFile = new WriterFile(buffer, new File("Directory"),new File("Directory.txt"));
        assertEquals("",writerFile.creatNameForNewFile());
    }

    @Test
    void creatNameForNewFile__GetNameForNewFile() {
        writerFile = new WriterFile(buffer, new File("txt.txt"),new File("Directory"));
        assertEquals("Directory\\txt.txt",writerFile.creatNameForNewFile());
    }
    @Test
    void writeFile() {
        writerFile = new WriterFile(buffer, new File("txt.txt"),new File("Directory"));
    }
}