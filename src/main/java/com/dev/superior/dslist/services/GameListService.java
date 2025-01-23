package com.dev.superior.dslist.services;

import com.dev.superior.dslist.dto.GameListDTO;
import com.dev.superior.dslist.repository.GameListRepository;
import com.dev.superior.dslist.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
        var result = gameListRepository.findAll();
        return result.stream().map(g -> new GameListDTO(g)).toList();
    }

    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex){
        var list = gameRepository.searchByList(listId);
        var objRemovido = list.remove(sourceIndex);
        list.add(destinationIndex,objRemovido);

        int min = sourceIndex < destinationIndex ? sourceIndex:destinationIndex;
        int max = sourceIndex < destinationIndex ? destinationIndex:sourceIndex;

        for(int i = min;i<=max;i++){
            gameListRepository.updateBelongingPosition(listId,list.get(i).getId(),i);
        }
    }
}