package com.work.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by huyan on 15/5/6.
 */
@Controller
@RequestMapping(value = "/admin")
public class MainController  extends AbstractController{


    private static final String PREFIX = "/";

    @RequestMapping("/main")
    public String main(HttpServletRequest request, Model model) {
        if (null == request.getSession().getAttribute("user")) {
            return "redirect:/admin/login?from-main";
        }
        return PREFIX + "main";
    }

    @RequestMapping("")
    public String index() {
        return redirect("admin/main");
    }

    @RequestMapping("/app/error")
    public String error() {
        return PREFIX+"error";
    }

}
