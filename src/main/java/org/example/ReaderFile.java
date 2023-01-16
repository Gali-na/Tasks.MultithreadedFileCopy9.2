package org.example;

import java.io.*;

public class ReaderFile implements Runnable {
    private DataBuffer dataBuffer;

    private File file;

    public ReaderFile(DataBuffer dataBuffer, File file) {
        this.file = file;
        this.dataBuffer = dataBuffer;
    }

    public boolean readFile() {
        boolean rezult = false;
        if (FileCheck.check(this.file)) {
            try (InputStream reder = new BufferedInputStream(new FileInputStream(file))) {
                byte[] arryByte = new byte[1024];
                while (reder.read(arryByte) > -1) {
                    dataBuffer.putArrayInformation(arryByte);
                    arryByte = new byte[1024];
                    rezult = true;
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return rezult;
    }

    @Override
    public void run() {
        readFile();
    }
}
