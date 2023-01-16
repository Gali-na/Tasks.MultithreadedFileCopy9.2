package org.example;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        DataBuffer dataBuffer = new DataBuffer();
        File file1 = new File("txt.txt");
        File file2 = new File("C:\\Users\\Acer Nitro 5\\Desktop\\English text");

        ReaderFile readerFile = new ReaderFile(dataBuffer, file1);
        WriterFile writerFile = new WriterFile(dataBuffer, file1, file2);

        Thread readTread = new Thread(readerFile);
        Thread writer = new Thread(writerFile);
        readTread.start();
        writer.start();

    }
}
