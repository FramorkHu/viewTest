package com.work.security;

import com.work.core.model.pojo.UserInfo;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by IntelliJ IDEA.
 * User: Haffner
 * Date: 12-11-16
 * Time: 下午2:23
 * To change this template use File | Settings | File Templates.
 */
public class PermissionHandler extends HandlerInterceptorAdapter {
    private String deniedTarget;

    private String relogTarget;

    private String excludeURL;

    /**
     * This implementation always returns <code>true</code>.
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        UserInfo user = (UserInfo) session.getAttribute("user");
        // 登录判断
        if (user == null && isExcludeURL(request)) {
            response.setHeader("Content-Type", "text/html;charset=UTF-8");
            response.sendRedirect(request.getContextPath() + relogTarget);

            return false;
        }

        return true;
    }

    /**
     * 例外URI判断
     *
     * @param request
     * @return true - 需要登录 false-不需要登录即可使用的资源
     */
    public boolean isExcludeURL(HttpServletRequest request) {
        String uri = request.getRequestURI();
        if (uri.contains("Admin") ){
            return true;
        }
        return false;

    }

    public String getDeniedTarget() {
        return deniedTarget;
    }

    public void setDeniedTarget(String deniedTarget) {
        this.deniedTarget = deniedTarget;
    }

    public String getRelogTarget() {
        return relogTarget;
    }

    public void setRelogTarget(String relogTarget) {
        this.relogTarget = relogTarget;
    }

    public String getExcludeURL() {
        return excludeURL;
    }

    public void setExcludeURL(String excludeURL) {
        this.excludeURL = excludeURL;
    }
}