package com.example.demo;

import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.sql.Date;

public class Movie {
    private String title, genre, director, studio;
    private Integer likes;
    private Date releaseDate;
    private Label likeLabel;

    public Movie(String title, String genre, String director, String studio, Date releaseDate, Integer likes) {
        this.title = title;
        this.genre = genre;
        this.director = director;
        this.studio = studio;
        this.likes = 0;
        this.releaseDate = releaseDate;
    }

    public Movie(String title,String genre, Integer likes,Label likeLabel) {
        this.title = title;
        this.genre=genre;
        this.likes=likes;
        this.likeLabel=likeLabel;
    }

    public void Like() {
        this.likes++;
        likeLabel.setText(likes.toString());

    }

    //setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setLikeLabel(Label likeLabel) {
        this.likeLabel = likeLabel;
    }



    //getters
    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public String getDirector() {
        return director;
    }

    public String getStudio() {
        return studio;
    }

    public Integer getLikes() {
        return likes;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public Label getLikeLabel() {
        return likeLabel;
    }
}
