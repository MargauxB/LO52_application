package com.example.margaux.test04menulattral;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.widget.ImageView;

/**
 * Created by margaux on 23/12/2016.
 */

public class FilmRow {
    String name;
    Drawable poster;
    String year;
    String producer;
    String[] types;
    String actors;
    String synopsis;
/*Constructor*/
    public FilmRow(String name,Drawable poster, String year, String producer, String actors, String[] types, String synopsis) {
        this.synopsis = synopsis;
        this.actors = actors;
        this.name = name;
        this.poster = poster;
        this.year = year;
        this.producer = producer;
        this.types = types;
    }
/*Getters & Setters*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Drawable getPoster() {
        return poster;
    }

    public void setPoster(Drawable poster) {
        this.poster = poster;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String[] getTypes() {
        return types;
    }

    public void setTypes(String[] types) {
        this.types = types;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) { this.synopsis = synopsis;}


}
