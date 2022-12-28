package com.company;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class DataProcessor<T extends FilmIndustry> {

    public List<T> stream(List<T> filmStream, int a, int b) throws MyException {
            if(a > b){
                throw new MyException("Извините, вы ошиблись, ПОЖАЛУЙСТА!");
            } else {
                return filmStream.stream()
                        .filter(film -> film.mark >= a && film.mark < b)
                        .sorted(Comparator.comparing(film -> film.mark))
                        .limit(3)
                        .collect(Collectors.toList());
            }
    }
    public Optional<T> find(List<T> filmStream, int a) {
        return filmStream.stream()
                .filter(film -> film.mark == a)
                .findFirst();
    }
}