package com.company;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DataProcessorTest {

    DataProcessor data = new DataProcessor();

    @Test
    void stream() throws MyException {

        List<FilmIndustry> list = new ArrayList<>();
        assertThrows(MyException.class, () -> data.stream(list, 5, 3));

        list.add(new Film(1, 5, 1));
        list.add(new Film(5, 3, 1));
        list.add(new Film(17, 4, 2));
        list.add(new Film(31, 3, 4));
        list.add(new Film(40, 1, 1));
        list.add(new Film(45, 5, 2));
        list.add(new Serial(40, 5, 2, 10));
        list.add(new Serial(12, 4, 4, 15));
        list.add(new Serial(4, 5, 1, 6));
        list.add(new Serial(9, 3, 4, 2));
        list.add(new Serial(13, 4, 3, 10));

        List<FilmIndustry> list2 = new ArrayList<>();
        list2.add(new Film(5, 3, 1));
        list2.add(new Film(31, 3, 4));
        list2.add(new Serial(9, 3, 4, 2));

        assertEquals(list2, data.stream(list, 3, 5));

    }

    @Test
    void find() {
        ArrayList<FilmIndustry> list = new ArrayList<>();
        list.add(new Film(5, 4, 4));

        assertEquals(false, data.find(list, 3).isPresent());
        assertEquals(true, data.find(list, 4).isPresent());

        list.add(new Film(10, 5, 1));
        list.add(new Film(15, 2, 2));

        assertEquals(list.get(1), data.find(list, 5).get());

    }
}