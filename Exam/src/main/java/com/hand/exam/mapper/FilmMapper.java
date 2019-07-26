package com.hand.exam.mapper;

import com.hand.exam.entity.Film;
import tk.mybatis.mapper.common.Mapper;

import java.util.HashMap;
import java.util.List;


public interface FilmMapper extends Mapper<Film> {

    List<Film> getFilm(HashMap<String,Object> map);
}
