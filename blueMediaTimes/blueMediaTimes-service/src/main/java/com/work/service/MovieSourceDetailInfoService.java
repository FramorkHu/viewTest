package com.work.service;

import com.work.core.model.bvo.MovieSourceBaseDataBvo;
import com.work.core.model.bvo.MovieSourceDetailBvo;
import com.work.core.model.pojo.MovieSourceDetailInfo;
import com.work.core.model.pojo.MovieSourceDetailInfoWithBLOBs;

import java.util.List;

/**
 * Created by huyan on 15/5/11.
 */
public interface MovieSourceDetailInfoService {

    public List<String> getProductYearMovieSource();

    public List<MovieSourceBaseDataBvo> getMovieSourceByCondition(Integer year, Integer classifyId, Integer attribute, Integer start, Integer rows);

    public int countMovieSourceByCondition(Integer year, Integer classifyId, Integer attribute);

    public int insertMovieSourceDetailInfo(MovieSourceDetailInfoWithBLOBs detailInfo);

    public List<MovieSourceDetailInfoWithBLOBs> getMovieSourceDetailInfo(String movieName, Integer startPage, Integer pageSize);

    public List<MovieSourceBaseDataBvo> getMovieSourceBaseDataByName(String movieName);

    public int countMovieSourceDetailInfo(String movieName);

    public MovieSourceDetailBvo getMovieSourceDetailBvo(Integer sourceId);

    public int updateMovieSourceDetailInfo(MovieSourceDetailInfoWithBLOBs infoWithBLOBs);

    public int deleteMovieSourceDetail(Integer sourceId);

}
