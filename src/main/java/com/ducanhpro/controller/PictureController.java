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
import java.util.Date;

@Controller
public class PictureController {
    @Autowired
    private ICommentService commentService ;

    @GetMapping("/home")
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView("/picture");
        modelAndView.addObject("comment",new Comment());
        modelAndView.addObject("listComment",commentService.findAll());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView createComment(@ModelAttribute("comment") Comment comment){
        comment.setDate(LocalDate.now());
        commentService.save(comment);
        ModelAndView modelAndView = new ModelAndView("/picture");
        modelAndView.addObject("listComment",commentService.findAll());
        return modelAndView;
    }

}
