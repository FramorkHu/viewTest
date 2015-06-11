package com.work.controller;

import com.util.ParseMD5;
import com.work.core.model.pojo.UserInfo;
import com.work.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
* Created by IntelliJ IDEA.
* User: li
* Date: 12-12-11
* Time: 上午11:07
* To change this template use File | Settings | File Templates.
*/
@Controller
@RequestMapping(value = "/admin")
public class LoginController extends AbstractController {

    @Autowired
    UserInfoService userInfoService;

    private static final String PREFIX = "/";

    @RequestMapping(value = {"/login", "relogin"}, method = GET)
    public String login(Model model) {
        model.addAttribute(MSG, "");
        return PREFIX + "login";
    }

    @RequestMapping(value = {"/login", "relogin"}, method = POST)
    public String login(Model model,String userName, String password, HttpServletRequest request) {
        String encodePass = ParseMD5.parseStrToMd5L32(password);
        UserInfo userInfo = userInfoService.getUserInfoData(userName, encodePass);
        if (userInfo != null){
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("user", userInfo);
            return redirect("admin/main?login-success");
        } else {
            model.addAttribute(MSG, "用户名或密码错误");
            return PREFIX+"login";
        }

    }


    @RequestMapping("logout")
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return redirect("admin/login?from-logout");
    }

    @RequestMapping("/app_aaw")
    public String denied(Model model) {
        return PREFIX + "denied";
    }
}