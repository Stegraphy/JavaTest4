package com.hand.exam.service.impl;

import com.github.pagehelper.PageHelper;
import com.hand.exam.entity.Film;
import com.hand.exam.entity.Page;
import com.hand.exam.mapper.FilmMapper;
import com.hand.exam.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmServiceImpl implements FilmService {

    @Autowired
    private FilmMapper filmMapper;

    @Override
    public Short insert(Film film) {
            filmMapper.insert(film);
            return film.getFilmId();
    }

    @Override
    public List<Film> list(Page page) {
        PageHelper.startPage(page.getPage(),page.getPageSize());
        PageHelper.orderBy("film_id");
        return filmMapper.selectAll();
    }
}
