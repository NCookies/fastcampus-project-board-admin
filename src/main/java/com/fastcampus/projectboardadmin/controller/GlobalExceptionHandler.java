package com.fastcampus.projectboardadmin.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GlobalExceptionHandler implements ErrorController {

    @RequestMapping("/error")
    public String handleException(Model model, HttpServletRequest request, HttpServletResponse response) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if (status != null) {
            model.addAttribute("request", request);
            model.addAttribute("response", response);

            int statusCode = Integer.parseInt(status.toString());

            if (statusCode >= 400 && statusCode < 500) {
                return "error/4xx";  // 4xx.html 템플릿 사용
            } else if (statusCode >= 500) {
                return "error/5xx";  // 5xx.html 템플릿 사용
            }
        }

        return "error";
    }

}
