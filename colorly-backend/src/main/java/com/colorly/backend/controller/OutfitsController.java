package com.colorly.backend.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.colorly.backend.exception.HTTPErrorException;
import com.colorly.backend.model.Outfit;
import com.colorly.backend.model.User;
import com.colorly.backend.repository.OutfitRepository;
import com.colorly.backend.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/outfits")
public class OutfitsController {
    @Autowired
    private OutfitRepository outfitRepository;

    @Autowired
    private UserService userService;

    private Outfit getOutfitById(Integer id) {
        return outfitRepository.findById(id)
                .orElseThrow(() -> new HTTPErrorException(HttpStatus.NOT_FOUND, "Outfit not found!"));
    }

    @GetMapping(path = "/all")
    public List<Outfit> getAll() {
        List<Outfit> result = new ArrayList<Outfit>();
        outfitRepository.findAll().forEach(result::add);
        return result;
    }

    @GetMapping(path = "/popular")
    public List<Outfit> getPopular() {
        return outfitRepository.findTopTen();
    }

    @GetMapping(path = "/{outfitId}")
    public Outfit getOutfit(@PathVariable Integer outfitId) {
        return getOutfitById(outfitId);
    }

    @DeleteMapping(path = "/{outfitId}")
    public void deleteOutfit(@PathVariable Integer outfitId, HttpSession session) {
        User user = userService.getUserBySession(session);
        Outfit outfit = getOutfitById(outfitId);
        if (outfit.getOwner().getId() != user.getId()) {
            new HTTPErrorException(HttpStatus.FORBIDDEN, "You do not own this outfit!");
        }
        outfitRepository.delete(outfit);
    }

    @GetMapping(path = "/{outfitId}/liked")
    public Map<String, Boolean> isLiked(@PathVariable Integer outfitId, HttpSession session) {
        Outfit outfit = getOutfitById(outfitId);
        User user = userService.getUserBySession(session);
        return Map.of("liked", outfit.getLikers().contains(user));
    }

    @GetMapping(path = "/{outfitId}/like")
    public void like(@PathVariable Integer outfitId, HttpSession session) {
        Outfit outfit = getOutfitById(outfitId);
        User user = userService.getUserBySession(session);
        outfit.addLiker(user);
        outfitRepository.save(outfit);
    }

    @GetMapping(path = "/{outfitId}/unlike")
    public void dislike(@PathVariable Integer outfitId, HttpSession session) {
        Outfit outfit = getOutfitById(outfitId);
        User user = userService.getUserBySession(session);
        outfit.removeLiker(user);
        outfitRepository.save(outfit);
    }
}
