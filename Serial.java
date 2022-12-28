package com.company;

public class Serial extends FilmIndustry {

    public int series;

    public Serial(int id, int mark, int genre, int series) {
        this.id = id;
        this.mark = mark;
        this.genre = genre;
        this.series = series;
    }

    @Override
    public int getInform() {
        return this.series;
    }

    public String print() {
        return "Serial - Жанр "+this.genre +": просмотрено "+ this.totalNumber +", средняя оценка "+(int)this.averageRating +", общее количество серий "+(int)this.numberOfEpisodes;
    }

    public String print2() {
        return "Сериал: " + this.id + " оценка " + this.mark;
    }
}