package com.hand.exam.service;

import com.hand.exam.entity.Film;
import com.hand.exam.entity.Page;

import java.util.List;

public interface FilmService {

    Short insert(Film film);
    List<Film> list(Page page);
}
