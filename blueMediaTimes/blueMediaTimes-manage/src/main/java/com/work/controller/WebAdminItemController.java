package com.work.controller;

import com.work.core.model.bvo.ItemModelSourceInfo;
import com.work.service.ItemSourceInfoService;
import org.apache.commons.lang.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by huyan on 15/5/9.
 */
@Controller
@RequestMapping(value = "/webAdminItem")
public class WebAdminItemController extends AbstractController{

    @Autowired
    ItemSourceInfoService itemSourceInfoService;

    private static final String PREFIX = "/web_admin/index/";

    @RequestMapping(value = "index")
    public String indexItemView(Model model, String modelId){
        model.addAttribute("modelId",modelId);
        return PREFIX + "index";
    }

    @RequestMapping("getIndexModelData")
    public void getIndexData(Model model, HttpServletResponse response, String modelId){
        Integer modelIdInt = NumberUtils.toInt(modelId);

        List<ItemModelSourceInfo> modelSourceInfos =
                itemSourceInfoService.getItemModelSourceInfos(1, modelIdInt);

        Map<String,Object> map = new HashMap<String, Object>();

        map.put(ROWS, modelSourceInfos);
        map.put(TOTAL, modelSourceInfos.size());

        writeJson(response, map);

    }


}
