package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FilmTest {

    @Test
    void getInform() {
        Film film = new Film(10,2,4);
        assertEquals(0, film.getInform());
    }

    @Test
    void print() {
        Film film = new Film(10,2,4);
        assertEquals("Film - Жанр " + 4 + ": просмотрено " + 0 + ", средняя оценка " + 0, film.print());
    }

    @Test
    void print2() {
        Film film = new Film(10,2,4);
        assertEquals("Фильм: " + 10 + " оценка " + 2, film.print2());
    }
}