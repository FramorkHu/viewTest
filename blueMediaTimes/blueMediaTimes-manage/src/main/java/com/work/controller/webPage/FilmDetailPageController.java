package com.work.controller.webPage;

import com.work.core.model.bvo.MovieSourceDetailBvo;
import com.work.service.MovieSourceDetailInfoService;
import org.apache.commons.lang.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by huyan on 15/5/17.
 */
@Controller
@RequestMapping(value = "/film")
public class FilmDetailPageController {

    private static final String PREFIX = "/web_page/";

    @Autowired
    MovieSourceDetailInfoService movieSourceDetailInfoService;

    @RequestMapping("filmDetail")
    public String getFilmDetailData(Model model, String film){

        int filmId = NumberUtils.toInt(film);
        MovieSourceDetailBvo detailBvo =
                movieSourceDetailInfoService.getMovieSourceDetailBvo(filmId);

        model.addAttribute("detailBvo", detailBvo);

        return PREFIX+"filmpage";
    }

    @RequestMapping("playFilm")
    public String playFilm(Model model, String film){
        int filmId = NumberUtils.toInt(film);
        MovieSourceDetailBvo detailBvo =
                movieSourceDetailInfoService.getMovieSourceDetailBvo(filmId);
        model.addAttribute("detailBvo", detailBvo);
        return PREFIX+"play";
    }


}
