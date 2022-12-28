package com.company;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @org.junit.jupiter.api.Test
    void getInform() {
        Game game = new Game(5,3,2);
        assertEquals(0,game.getInform());
    }

    @org.junit.jupiter.api.Test
    void print() {
        Game game = new Game(5,3,2);
        assertEquals("Game - Жанр " + 2 + ": Количество проданных копий " + 0 + ", средняя оценка " + 0, game.print());
    }

    @org.junit.jupiter.api.Test
    void print2() {
        Game game = new Game(5,3,2);
        assertEquals("Игра: " + 5 + " оценка " + 3, game.print2());
    }
}