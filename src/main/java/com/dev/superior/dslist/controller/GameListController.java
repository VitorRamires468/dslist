package com.dev.superior.dslist.controller;

import com.dev.superior.dslist.dto.GameListDTO;
import com.dev.superior.dslist.dto.GameMinDTO;
import com.dev.superior.dslist.dto.ReplacementDTO;
import com.dev.superior.dslist.services.GameListService;
import com.dev.superior.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameListDTO> findAll(){
        var result = gameListService.findAll();
        return result;
    }

    @GetMapping("/{listId}/games")
    public List<GameMinDTO> findByLIst(@PathVariable  Long listId){
        var result = gameService.findByList(listId);
        return result;
    }

    @PostMapping("/{listId}/replacement")
    @Transactional
    public void moce(@RequestBody ReplacementDTO dados, @PathVariable Long listId){
        gameListService.move(listId,dados.getSourceIndex(),dados.getDestinationIndex());
    }

}
