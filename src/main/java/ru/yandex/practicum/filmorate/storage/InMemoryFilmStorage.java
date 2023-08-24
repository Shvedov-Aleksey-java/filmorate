package ru.yandex.practicum.filmorate.storage;

import ru.yandex.practicum.filmorate.exeption.ValidationException;
import ru.yandex.practicum.filmorate.model.Film;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryFilmStorage implements FilmStorage{

    private final Map<Long, Film> films = new HashMap<>();

    @Override
    public List<Film> getFilms() {
        return new ArrayList<>(films.values());
    }

    @Override
    public Film add(Film film) {
        films.put(film.getId(), film);
        return film;
    }

    @Override
    public Film update(Film film) {
        if (films.get(film.getId()) == null) {
            throw new ValidationException("Not found key: " + film.getId());
        }
        films.put(film.getId(), film);
        return film;
    }
}