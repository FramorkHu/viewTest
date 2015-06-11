package com.work.controller.webPage;

import com.work.controller.AbstractController;
import com.work.core.model.bvo.ItemModelSourceInfo;
import com.work.service.ItemSourceInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by huyan on 15/5/16.
 */
@Controller
@RequestMapping(value = "/")
public class IndexController extends AbstractController {

    private static final String PREFIX = "/web_page/";
    @Autowired
    ItemSourceInfoService itemSourceInfoService;

    @RequestMapping("/")
    public String getIndexData(Model model){

        List<ItemModelSourceInfo> headPicInfos =
                itemSourceInfoService.getItemModelSourceInfos(1, 11);
        List<ItemModelSourceInfo> newInfos =
                itemSourceInfoService.getItemModelSourceInfos(1,12);
        List<ItemModelSourceInfo> koreanMovieInfos =
                itemSourceInfoService.getItemModelSourceInfos(1,13);
        List<ItemModelSourceInfo> classicInfos =
                itemSourceInfoService.getItemModelSourceInfos(1,14);

        model.addAttribute("headPicInfos",headPicInfos);
        model.addAttribute("newInfos",newInfos);
        model.addAttribute("koreanMovieInfos",koreanMovieInfos);
        model.addAttribute("classicInfos",classicInfos);

        return PREFIX+"index";
    }
}
