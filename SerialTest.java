package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SerialTest {

    @Test
    void getInform() {
        Serial serial = new Serial(40,5,1, 10);
        assertEquals(10,serial.getInform());
    }

    @Test
    void print() {
        Serial serial = new Serial(40,5,1, 10);
        assertEquals("Serial - Жанр " + 1 + ": просмотрено " + 0 + ", средняя оценка " + 0 + ", общее количество серий " + 0, serial.print());
    }

    @Test
    void print2() {
        Serial serial = new Serial(40,5,1, 10);
        assertEquals("Сериал: " + 40 + " оценка " + 5, serial.print2());
    }
}