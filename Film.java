package com.company;

public class Film extends FilmIndustry {

    public Film (int id, int mark, int genre) {
        this.id = id;
        this.mark = mark;
        this.genre = genre;
    }

    @Override
    public int getInform() {
        return 0;
    }

    public String print() {
        return "Film - Жанр " + this.genre + ": просмотрено " + this.totalNumber + ", средняя оценка " + (int) this.averageRating;
    }

    public String print2() {
        return "Фильм: " + this.id + " оценка " + this.mark;
    }
}