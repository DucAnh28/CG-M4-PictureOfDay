package com.ducanhpro.controller;

import com.ducanhpro.model.Comment;
import com.ducanhpro.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Controller
public class PictureController {
    @Autowired
    private ICommentService commentService ;

    @GetMapping("/home")
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView("/picture");
        modelAndView.addObject("comment",new Comment());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView createComment(@ModelAttribute("comment") Comment comment){
        Date date = new Date(String.valueOf(LocalDate.now()));
        comment.setDate(date);
        commentService.save(comment);
        ModelAndView modelAndView = new ModelAndView("/picture");
        Date date1 = java.sql.Date.valueOf(LocalDate.now());
        modelAndView.addObject("listComment",commentService.findCommentByDate(date1));
        return modelAndView;
    }

}
