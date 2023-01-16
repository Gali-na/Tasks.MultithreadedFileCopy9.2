package org.example;

import java.io.*;

public class WriterFile implements Runnable {
    private DataBuffer dataBuffer;
    private File fileForCopy;
    private File directoryForNewfile;

    public WriterFile(DataBuffer dataBuffer, File fileForCopy, File directoryForNewfile) {
        this.dataBuffer = dataBuffer;
        this.fileForCopy = fileForCopy;
        this.directoryForNewfile = directoryForNewfile;
    }

    public String creatNameForNewFile() {
        String nameNewFile = "";
        if (FileCheck.check(fileForCopy) && DirectoryCheck.check(directoryForNewfile)) {
            String nameFileSorce = fileForCopy.getName();
            nameNewFile = directoryForNewfile + "\\" + nameFileSorce;
        }
        return nameNewFile;
    }

    public boolean writeFile() {
        boolean rezult = false;
        PrinterRezult printerRezult = new PrinterRezult(this.fileForCopy);
        if (creatNameForNewFile().length() != 0) {
            File file = new File(creatNameForNewFile());
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            try (OutputStream writer = new BufferedOutputStream(new FileOutputStream(creatNameForNewFile()))) {
                for (byte[] arryByte : dataBuffer.getStorage()) {
                    writer.write(arryByte);
                    System.out.println(printerRezult.showRezult());
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

        writeFile();
    }
}
