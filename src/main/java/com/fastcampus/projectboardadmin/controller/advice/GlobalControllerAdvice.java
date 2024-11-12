package com.fastcampus.projectboardadmin.controller.advice;

import com.fastcampus.projectboardadmin.service.VisitCounterService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@RequiredArgsConstructor
@ControllerAdvice
public class GlobalControllerAdvice {

    private final VisitCounterService visitCounterService;

    @ModelAttribute("request")
    public HttpServletRequest addHttpServletRequest(HttpServletRequest request) {
        return request;
    }

    @ModelAttribute("visitCount")
    public Long visitCount() {
        return visitCounterService.visitCount();
    }

}
