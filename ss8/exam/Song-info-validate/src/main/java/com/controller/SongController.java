package com.controller;

import com.dto.SongDto;
import com.model.Song;
import com.service.impl.SongServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SongController {
    @Autowired
    private SongServiceImpl songService;

    @GetMapping("/")
    public String showList(Model model) {

        model.addAttribute("songList",songService.findAll());
        return "/list";
    }

    @GetMapping("/create")
    public String create( Model model) {

        model.addAttribute("songDto",new SongDto());
        return "/create";
    }
    @PostMapping("/save")
    public String save(@Validated @ModelAttribute SongDto songDto,BindingResult bindingResult,Model model){
        if (bindingResult.hasErrors()) {
            model.addAttribute("songDto",songDto);
            return "/create";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songDto,song);
        songService.update(song);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String updateSong(@PathVariable int id, Model model) {
        Song song = songService.findById(id);
        model.addAttribute("song",song);
        return "/edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute Song song) {
        songService.update(song);
        return "redirect:/";
    }
}
