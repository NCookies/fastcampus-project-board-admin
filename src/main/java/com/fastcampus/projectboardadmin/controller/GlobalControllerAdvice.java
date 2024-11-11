package com.fastcampus.projectboardadmin.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class GlobalControllerAdvice {

    @ModelAttribute
    public void addHttpServletRequestToModel(Model model, HttpServletRequest request) {
        model.addAttribute("request", request);
    }

}
