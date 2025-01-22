package com.dev.superior.dslist.controller;

import com.dev.superior.dslist.dto.GameMinDTO;
import com.dev.superior.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/games")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameMinDTO> listarGames(){
        var result = gameService.findAll();
        return result;
    }
}
