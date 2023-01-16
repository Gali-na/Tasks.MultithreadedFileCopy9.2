package org.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DataBufferTest {
    private static DataBuffer dataBuffer;

    @BeforeAll
    public static void init() {
        dataBuffer = new DataBuffer();
    }

    @Test
    void getStorage() {
        assertEquals(0, dataBuffer.getStorage().size());
    }

    @Test
    void putArrayInformation() {
        byte[] bytes = new byte[]{};
        dataBuffer.putArrayInformation(bytes);
        assertEquals(bytes, dataBuffer.takeArrayInformation());
    }

    @Test
    void takeArrayInformation() {
        byte[] bytes = new byte[]{};
        dataBuffer.putArrayInformation(bytes);
        assertEquals(bytes, dataBuffer.takeArrayInformation());
    }
}