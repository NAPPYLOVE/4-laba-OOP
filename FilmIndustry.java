package com.company;

import java.util.Objects;

public abstract class FilmIndustry implements Info {

    public int id;
    public int mark;
    public int genre;
    public int totalNumber;
    public float averageRating;
    public float numberOfEpisodes;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilmIndustry that = (FilmIndustry) o;
        return id == that.id && mark == that.mark && genre == that.genre && totalNumber == that.totalNumber && Float.compare(that.averageRating, averageRating) == 0 && Float.compare(that.numberOfEpisodes, numberOfEpisodes) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, mark, genre, totalNumber, averageRating, numberOfEpisodes);
    }

    public abstract String print();
    public abstract String print2();
}