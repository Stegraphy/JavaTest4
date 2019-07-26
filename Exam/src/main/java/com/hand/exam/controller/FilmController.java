package com.hand.exam.controller;

import com.hand.exam.entity.Film;
import com.hand.exam.entity.Page;
import com.hand.exam.service.FilmService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/film")
public class FilmController {
    private ch.qos.logback.classic.Logger logger = (ch.qos.logback.classic.Logger) LoggerFactory.getLogger(FilmController.class);

    @Autowired
    private FilmService filmService;
    @GetMapping(value = "/list")
    public List<Film> list(@RequestBody Page page){
        page.setSort("ASC");
        List<Film> films = filmService.list(page);
        logger.info("<<<<<<<<<Start With PageHelper>>>>>>>>>>>");
        for (int i = 0;i<films.size();i++){
            logger.info(films.get(i).toString());
        }
        return films;

    }

    @GetMapping(value = "/list1")
    public List<Film> getAllFilm(int currentPage,int pageSize){
        HashMap<String,Object> map = new HashMap<>();
        map.put("startIndex",(currentPage-1)*pageSize);
        map.put("pageSize",pageSize);
        logger.info(">>>>>>>>>>>>>>Implement with Original method to paging");
        List<Film> films = filmService.getFilm(map);
        for (int i =0 ;i<films.size();i++){
            logger.info(films.get(i).toString());
        }
        return films;
    }

    @PutMapping(value = "/add")
    public Film insert(@RequestBody Film film){
        Film film1 = new Film();
        film1.setDescription(film.getDescription());
        film1.setFilmId(film.getFilmId());
        film1.setLanguageId(film.getLanguageId());
        film1.setLastUpdate(film.getLastUpdate());
        film1.setLength(film.getLength());
        film1.setOriginalLanguageId(film.getOriginalLanguageId());
        film1.setTitle(film.getTitle());
        film1.setRentalDuration(film.getRentalDuration());
        film1.setRating(film.getRating());
        film1.setSpecialFeatures(film.getSpecialFeatures());
        film1.setReplacementCost(film.getReplacementCost());
        film1.setReleaseYear(film.getReleaseYear());

        short id = film.getFilmId();
        filmService.insert(film1);
        logger.info("Film_id="+id+"插入成功");
        return film;
    }
}
