package com.dev.superior.dslist.services;

import com.dev.superior.dslist.dto.GameDTO;
import com.dev.superior.dslist.dto.GameMinDTO;
import com.dev.superior.dslist.entities.Game;
import com.dev.superior.dslist.repository.GameRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll(){
        var result = gameRepository.findAll();
        return result.stream().map(g -> new GameMinDTO(g)).toList();
    }

    @Transactional(readOnly = true)
    public GameDTO findById(Long id){
        Optional<Game> optionalGame = gameRepository.findById(id);
        if(optionalGame.isPresent()){
            var game = optionalGame.get();
            return new GameDTO(game);
        }else{
            throw new RuntimeException("Registro não cadastrado no banco!");
        }
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findByList(Long listId){
        var result = gameRepository.searchByList(listId);
        return result.stream().map(g -> new GameMinDTO(g)).toList();
    }
}
