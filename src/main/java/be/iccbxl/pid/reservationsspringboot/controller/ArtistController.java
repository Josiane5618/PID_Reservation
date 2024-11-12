package be.iccbxl.pid.reservationsspringboot.controller;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import be.iccbxl.pid.reservationsspringboot.model.Artist;
import be.iccbxl.pid.reservationsspringboot.service.ArtistService;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class ArtistController {
    @Autowired
    ArtistService service;

    //…

    @GetMapping("/artists/create")
    public String create(Model model) {
        Artist artist = new Artist(null,null);

        model.addAttribute("artist", artist);

        return "artist/create";
    }

    @PostMapping("/artists/create")
    public String store(@Valid @ModelAttribute("artist") Artist artist, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "artist/create";
        }

        service.addArtist(artist);

        return "redirect:/artists/"+artist.getId();
    }

}
