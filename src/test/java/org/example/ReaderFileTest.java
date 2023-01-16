package org.example;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class ReaderFileTest {
    private DataBuffer dataBuffer = new DataBuffer();
    private ReaderFile readerFile;
    @Test
    void readFile_FileIsNull_GetFalse() {
        readerFile= new ReaderFile(dataBuffer,null);
        assertEquals(false,readerFile.readFile());
    }

    @Test
    void readFile_FileIsDirectiry_GetFalse() {
        readerFile= new ReaderFile(dataBuffer,new File("Directory"));
        assertEquals(false,readerFile.readFile());
    }

    @Test
    void readFile_FileSize0_GetFalse() {
        readerFile= new ReaderFile(dataBuffer,new File("tvy.txt"));
        assertEquals(false,readerFile.readFile());
    }
    @Test
    void readFile_FileIsExist_GetFalse() {
        readerFile= new ReaderFile(dataBuffer,new File("txt.txt"));
        assertEquals(true,readerFile.readFile());
    }
}