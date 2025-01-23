package com.dev.superior.dslist.dto;

import com.dev.superior.dslist.entities.Game;
import com.dev.superior.dslist.projections.GameMinProjection;

public class GameMinDTO{

    private Long id;
    private String title;
    private Integer year;
    private String imgURL;
    private String shortDescription;

    public GameMinDTO(){
    }

    public GameMinDTO(Game game) {
        this.id = game.getId();
        this.title = game.getTitle();
        this.year = game.getYear();
        this.imgURL = game.getImgUrl();
        this.shortDescription = game.getShortDescription();
    }

    public GameMinDTO(GameMinProjection gameMinProjection){
        this.id = gameMinProjection.getId();
        this.title = gameMinProjection.getTitle();
        this.year = gameMinProjection.getYear();
        this.imgURL = gameMinProjection.getImgUrl();
        this.shortDescription = gameMinProjection.getShortDescription();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Integer getYear() {
        return year;
    }

    public String getImgURL() {
        return imgURL;
    }

    public String getShortDescription() {
        return shortDescription;
    }
}
