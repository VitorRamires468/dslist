package com.dev.superior.dslist.services;

import com.dev.superior.dslist.dto.GameMinDTO;
import com.dev.superior.dslist.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public List<GameMinDTO> findAll(){
        var result = gameRepository.findAll();
        return result.stream().map(g -> new GameMinDTO(g)).toList();
    }
}
