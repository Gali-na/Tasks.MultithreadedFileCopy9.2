package org.example;

import java.util.LinkedList;

public class DataBuffer {
    private LinkedList<byte[]> storage;

    public DataBuffer() {

        this.storage = new LinkedList<>();
    }

    public LinkedList<byte[]> getStorage() {
        return storage;
    }

    public void putArrayInformation(byte[] currentarry) {
        storage.addLast(currentarry);
    }

    public byte[] takeArrayInformation() {
        return storage.poll();
    }
}
