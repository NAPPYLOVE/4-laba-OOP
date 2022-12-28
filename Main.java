package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        int numberOfFilms = 6, numberOfSerials = 5, numberOfGames = 4;

        List<FilmIndustry> films = new ArrayList<>();
        films.add(new Film(1, 5, 1));
        films.add(new Film(5, 3, 1));
        films.add(new Film(17, 4, 2));
        films.add(new Film(31, 3, 4));
        films.add(new Film(40, 1, 1));
        films.add(new Film(45, 5, 2));
        films.add(new Serial(40, 5, 2, 10));
        films.add(new Serial(12, 4, 4, 15));
        films.add(new Serial(4, 5, 1, 6));
        films.add(new Serial(9, 3, 4, 2));
        films.add(new Serial(13, 4, 3, 10));
        List<Game> games = new ArrayList<>();
        games.add(new Game(12, 4, 2));
        games.add(new Game(4, 2, 4));
        games.add(new Game(17, 3, 2));
        games.add(new Game(45, 1, 1));
        List<Info> obj = new ArrayList<>();

        int maxRating = 0, minRating, numberViews = 0, t, totalNumber = numberOfFilms + numberOfSerials, startingPoint = 0, endPoint = numberOfFilms;
        float averageRating = 0, numberOfEpisodes = 0;
        int[] myArray1 = new int[totalNumber];
        int[] myArray2 = new int[numberOfGames];
        minRating = films.get(0).mark;

        for (int i = 0; i < totalNumber; i++) {
            averageRating = averageRating + films.get(i).mark;
            numberViews++;
            if (films.get(i).mark > maxRating)
                maxRating = films.get(i).mark;
            if (films.get(i).mark < minRating)
                minRating = films.get(i).mark;
            if (i == numberOfFilms - 1) {
                System.out.println();
                System.out.println("Статистика фильмов:");
                System.out.println("Средняя оценка = " + averageRating/numberViews);
                System.out.println("Максимальная оценка = " + maxRating);
                System.out.println("Минимальная оценка = " + minRating);
                System.out.println();
                averageRating = 0;
                numberViews = 0;
                maxRating = 0;
                minRating = films.get(i).mark;
            }
        }

        System.out.println("Статистика сериалов:");
        System.out.println("Средняя оценка = " + averageRating/numberViews);
        System.out.println("Максимальная оценка = " + maxRating);
        System.out.println("Минимальная оценка = " + minRating);
        System.out.println();

        minRating = games.get(0).mark;
        maxRating = 0;
        numberViews = 0;
        averageRating = 0;

        for (int i = 0; i < numberOfGames; i++) {
            averageRating = averageRating + games.get(i).mark;
            numberViews++;
            if (games.get(i).mark > maxRating)
                maxRating = games.get(i).mark;
            if (games.get(i).mark < minRating)
                minRating = games.get(i).mark;
        }

        System.out.println("Статистика игр:");
        System.out.println("Средняя оценка = " + averageRating/numberViews);
        System.out.println("Максимальная оценка = " + maxRating);
        System.out.println("Минимальная оценка = " + minRating);

        for (int i = 0; i < totalNumber; i++) {
            if (i == numberOfFilms) {
                startingPoint = numberOfFilms;
                endPoint += numberOfSerials;
                System.out.println();
            }
            t = 0;
            for (int j = startingPoint; j < myArray1.length; j++) {
                if (films.get(i).genre == myArray1[j]) {
                    t = 1;
                    continue;
                }
            }
            if (t == 1) continue;

            averageRating = films.get(i).mark;
            numberOfEpisodes = films.get(i).getInform();
            numberViews = 1;

            for (int j = i+1; j < endPoint; j++) {
                if (films.get(i).genre == films.get(j).genre) {
                    numberViews++;
                    averageRating = averageRating + films.get(j).mark;
                    numberOfEpisodes = numberOfEpisodes + films.get(j).getInform();
                    myArray1[i] = films.get(i).genre;
                }
            }

            averageRating = averageRating/numberViews;

            films.get(i).averageRating = averageRating;
            films.get(i).numberOfEpisodes = numberOfEpisodes;
            films.get(i).totalNumber = numberViews;

            obj.add(films.get(i));
        }

        for (int i = 0; i < numberOfGames; i++) {
            t = 0;
            for (int j = 0; j < myArray2.length; j++) {
                if (games.get(i).genre == myArray2[j]) {
                    t = 1;
                    continue;
                }
            }
            if (t == 1) continue;
            averageRating = games.get(i).mark;
            numberViews = 1;

            for (int j = i+1; j < numberOfGames; j++) {
                if (games.get(i).genre == games.get(j).genre) {
                    numberViews++;
                    averageRating = averageRating + games.get(j).mark;
                    myArray2[i] = games.get(i).genre;
                }
            }
            averageRating = averageRating/numberViews;
            games.get(i).averageRating = averageRating;
            games.get(i).totalNumber = numberViews;

            obj.add(games.get(i));
        }

        for (int i = 0; i < obj.size(); i++) {
            System.out.println(obj.get(i).print());
        }

        System.out.println();

        DataProcessor<FilmIndustry> data = new DataProcessor<>();
        try{
            List<FilmIndustry> exportFilms = data.stream(films,3, 5);
            if (data.find(films, 4).isPresent()) {
                System.out.println("Точный фильм найден: ");
                System.out.println(data.find(films, 4).get().print2());
                System.out.println();
            } else {
                System.out.println("Точный фильм не найден: ");
                System.out.println();
            }
            System.out.println("Фильмы соответствующие заданным параметрам:");
            for (int i = 0; i < exportFilms.size(); i++){
                System.out.println(exportFilms.get(i).print2());
            }
        } catch (MyException e) {
            System.out.println("Ошибка в данных! UUID: " + e.getRandomUUID());
        }
    }
}