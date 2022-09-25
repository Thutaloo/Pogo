package com.example.pogo.ui.slideshow;

public class Pokemon {
    private String ID;
    private String name;
    private int image;

    public Pokemon(){
    }

    public Pokemon(String ID, String name) {
        this.ID = ID;
        this.name = name;

    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public int getImage() {
//        return image;
//    }
//
//    public void setImage(int image) {
//        this.image = image;
//    }
}
