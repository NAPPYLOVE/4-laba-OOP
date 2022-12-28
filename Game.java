package com.company;

public class Game implements Info {

    public int id;
    public int mark;
    public int genre;
    public int totalNumber;
    public float averageRating;

    public Game (int id, int mark, int genre) {
        this.id = id;
        this.mark = mark;
        this.genre = genre;
    }

    @Override
    public int getInform() {
        return 0;
    }

    public String print() {
        return "Game - Жанр " + this.genre + ": Количество проданных копий " + this.totalNumber + ", средняя оценка " + (int) this.averageRating;
    }

    public String print2() {
        return "Игра: " + this.id + " оценка " + this.mark;
    }
}