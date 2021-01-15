package com.emobilis.firstapp.model;

public class RecycerModel {
    //declare u data variables
    private int image;
    private String text;

    //constructor
    public RecycerModel(int image,String text){
        //match data to expect with data in model
        this.image = image;
        this.text = text;
    }

    //set the getters and setters

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
