package com.example.assignment2.controller;

import com.example.assignment2.data_access.ThymeleafCustomerRepository;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


public class ThymeleafCustomerController {
    ThymeleafCustomerRepository thymeleafCustomerRepository = new ThymeleafCustomerRepository();

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getRandomSongs(Model model){
        model.addAttribute("songs", thymeleafCustomerRepository.get5RandomSongs());
        model.addAttribute("artists", thymeleafCustomerRepository.get5RandomArtists());
        model.addAttribute("genres", thymeleafCustomerRepository.get5RandomGenres());
        return "home";
    }
    @RequestMapping(value = "/searchResult", method = RequestMethod.GET)
    public String getSongInformation(@RequestParam("searchQuery") String searchQuery, Model model) {
        model.addAttribute("songs", thymeleafCustomerRepository.getSongInformation(searchQuery));
        model.addAttribute("searchQuery", searchQuery);
        return "searchResult";
    }

}
